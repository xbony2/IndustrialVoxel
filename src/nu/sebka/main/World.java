package nu.sebka.main;

import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.CobbleBlock;
import nu.sebka.main.blocks.GrassBlock;
import nu.sebka.main.blocks.LogBlock;

public class World {

	public ArrayList<Instance> instances = new ArrayList<Instance>();
	
	public Camera cam = new Camera(70, (float) Main.WIDTH / (float) Main.HEIGHT, 0.03f,1000);
	Light light = new Light(cam.getX(),cam.getY()+10,cam.getZ());
	public World(){
		
		cam.setY(-Block.getSize()*2);
		
		for(int i = 0; i < 16; i+=1){
			for(int ii = 0; ii < 16; ii+=1){
				instances.add(new GrassBlock(i*Block.getSize(),0,-ii*Block.getSize()));

			}
		}
		Random random = new Random();
		for(int i = 0; i < 16; i+=1){
			for(int ii = 0; ii < 16; ii+=1){

				if(random.nextInt(10) == 0){
					instances.add(new CobbleBlock(i*Block.getSize(),Block.getSize(),-ii*Block.getSize()));
				}

			}
		}
		
		for(int i = 0; i < 16; i+=1){
			for(int ii = 0; ii < 16; ii+=1){

				if(random.nextInt(10) == 0){
					instances.add(new CobbleBlock(i*Block.getSize(),Block.getSize()*2,-ii*Block.getSize()));
				}

			}
		}
		
		for(int i = 0; i < 16; i+=1){
			for(int ii = 0; ii < 16; ii+=1){

				if(random.nextInt(10) == 0){
					instances.add(new LogBlock(i*Block.getSize(),Block.getSize()*3,-ii*Block.getSize()));
				}

			}
		}
		
		for(int i = 0; i < 16; i+=1){
			for(int ii = 0; ii < 16; ii+=1){

				if(random.nextInt(10) == 0){
					instances.add(new LogBlock(i*Block.getSize(),Block.getSize()*4,-ii*Block.getSize()));
				}

			}
		}

		for(int i = 0; i < 4; i++){
			instances.add(new LogBlock(Block.getSize()*4,Block.getSize()+i*Block.getSize(),-Block.getSize()*4));
		}



		
		instances.add(light);

	}
	
	public void tick(){
		
		
		
		
		
		for(Instance instance : instances){
			instance.tick();
		}
	}
	
	public void draw(){

		
		GL11.glLoadIdentity();
		cam.tick();
		cam.useView();
		
		
		
		GL11.glPushMatrix();
		for(Instance instance : instances){

			instance.draw();
			
			
		}
		GL11.glPopMatrix();
		

		
	}
	
	
	public Block getBlockAt(double x, double y, double z){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			if(
					instance.x >= -x-Block.getSize()/2 && instance.x <= -x+Block.getSize()/2 &&
					instance.y >= -y-Block.getSize()/2  && instance.y <= -y+Block.getSize()/2 &&
					instance.z >= -z-Block.getSize()/2  && instance.z <= -z+Block.getSize()/2

					){
				return (Block) instance;
			}
		}

		return new AirBlock((float)x,(float)y,(float)z);
	}
}
