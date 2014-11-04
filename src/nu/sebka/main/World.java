package nu.sebka.main;

import java.util.ArrayList;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.CobbleBlock;
import nu.sebka.main.blocks.GrassBlock;
import nu.sebka.main.blocks.LogBlock;

import org.lwjgl.opengl.GL11;

public class World {

    public ArrayList<Instance> instances = new ArrayList<Instance>();
    public Camera cam = new Camera(70, (float) Main.WIDTH / (float) Main.HEIGHT, 0.03f, 1000);

    public World() {

        cam.setY(-Block.getSize() * 2);

        for (int i = 0; i < 16; i += 1) {
            for (int ii = 0; ii < 16; ii += 1) {
                instances.add(new GrassBlock(i * Block.getSize(), 0, -ii * Block.getSize()));

            }
        }
        
        instances.add(new CobbleBlock(5*Block.getSize(),-Block.getSize()*2,-5*Block.getSize()));
        instances.add(new LogBlock(5*Block.getSize(),-Block.getSize()*3,-5*Block.getSize()));
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
                    x >= instance.x && x <= instance.x &&
                            y >= instance.y && y <= instance.y &&
                            z >= instance.z && z <= instance.z

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
                    x >= instance.x - Block.getSize() / 2 && x <= instance.x + Block.getSize() &&
                            y >= instance.y - Block.getSize() / 2 && y <= instance.y + Block.getSize() &&
                            z >= instance.z - Block.getSize() / 2 && z <= instance.z + Block.getSize()

                    ) {
                return (Block) instance;
            }
        }

        return new AirBlock((float) x, (float) y, (float) z);
    }

}
