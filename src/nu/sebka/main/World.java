package nu.sebka.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.CobbleBlock;
import nu.sebka.main.blocks.DirtBlock;
import nu.sebka.main.blocks.GrassBlock;
import nu.sebka.main.blocks.IDReference;
import nu.sebka.main.blocks.LogBlock;

import org.lwjgl.opengl.GL11;

public class World {

    public ArrayList<Instance> instances = new ArrayList<Instance>();
    public Camera cam = new Camera(70, (float) Main.WIDTH / (float) Main.HEIGHT, 0.03f, 1000);

    public World(){
    	File worldFile = new File("world/world.txt");
    	Scanner diskScanner = null;
    	try {
			diskScanner = new Scanner(worldFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	while(diskScanner.hasNext()){
    		String s = diskScanner.nextLine();
    		String[] parts = s.split(" ");
    		int id = Integer.parseInt(parts[0]);
    		float x = Float.parseFloat(parts[1]);
    		float y = Float.parseFloat(parts[2]);
    		float z = Float.parseFloat(parts[3]);
    		System.out.println(x + " " + y + " " + z);
    		addBlockToWorld(id, x, y, z);
    	}
    	
        cam.setY(-Block.getSize() * 2);

        /*for (int i = 0; i < 16; i += 1) {
            for (int ii = 0; ii < 16; ii += 1) {
                instances.add(new GrassBlock(i * Block.getSize(), 0, -ii * Block.getSize()));
            }
        }
        
        instances.add(new CobbleBlock(5*Block.getSize(),-Block.getSize()*2,-5*Block.getSize()));
        instances.add(new LogBlock(5*Block.getSize(),-Block.getSize()*3,-5*Block.getSize()));*/
    }
    
    public void addBlockToWorld(int id, float x, float y, float z){
    	switch(id){
    	case IDReference.COBBLE_ID: instances.add(new CobbleBlock(x, y, z)); break;
    	case IDReference.GRASS_ID: instances.add(new GrassBlock(x, y, z)); break;
    	case IDReference.WOOD_ID: instances.add(new LogBlock(x, y, z)); break;
    	case IDReference.DIRT_ID: instances.add(new DirtBlock(x, y, z)); break;
    	default: instances.add(new AirBlock(x, y, z));
    	}
    	/*Block block = ((Block) Block.blockIds.get(id));
    	block.setX(x);
    	block.setY(y);
    	block.setZ(z);
    	instances.add(block); //FIXME*/
    }

    public void tick() {
        for (Instance instance : instances) {
            instance.tick();
        }
    }

    public void draw() {


        GL11.glLoadIdentity();
        cam.tick();
        cam.useView();


        GL11.glPushMatrix();
        for (Instance instance : instances) {

            instance.draw();


        }
        GL11.glPopMatrix();


    }


    public Block getBlockAtPrecise(double x, double y, double z) {
        for (int i = 0; i < instances.size(); i++) {
            Instance instance = instances.get(i);
            if (
                    x >= instance.getX() && x <= instance.getX() &&
                            y >= instance.getY() && y <= instance.getY() &&
                            z >= instance.getZ() && z <= instance.getZ()

                    ) {
                return (Block) instance;
            }
        }

        return new AirBlock((float) x, (float) y, (float) z);
    }


    public Block getBlockAt(double x, double y, double z) {
        for (int i = 0; i < instances.size(); i++) {
            Instance instance = instances.get(i);
            if (
                    x >= instance.getX() - Block.getSize() / 2 && x <= instance.getX() + Block.getSize() &&
                            y >= instance.getY() - Block.getSize() / 2 && y <= instance.getY() + Block.getSize() &&
                            z >= instance.getZ() - Block.getSize() / 2 && z <= instance.getZ() + Block.getSize()

                    ) {
                return (Block) instance;
            }
        }

        return new AirBlock((float) x, (float) y, (float) z);
    }

}
