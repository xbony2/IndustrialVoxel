package nu.sebka.main;

import java.util.ArrayList;
import java.util.Random;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.CobbleBlock;
import nu.sebka.main.blocks.GrassBlock;
import nu.sebka.main.blocks.LogBlock;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

	public static int SCALE = 2;
	public static int WIDTH = (640) * SCALE;
	public static int HEIGHT = (WIDTH / 16 * 9);


	float xx = 0, yy = -0.4f, zz = 6.5f;
	
	float rotation = 0;

	float yorient = 0;
	float zorient = 0;
	float angle = 0;
	
	public static ArrayList<Instance> instances = new ArrayList<Instance>();

	public Main(){
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Minecraft");
			Display.create();

		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		for(int i = 0; i < 4; i++){
			instances.add(new LogBlock(Block.getSize()*4,Block.getSize()+i*Block.getSize(),-Block.getSize()*4));
		}

		

		

		Camera cam = new Camera(70, (float) WIDTH / (float) HEIGHT, 0.03f,1000);
		cam.setY(-Block.getSize()*2);
		while(!Display.isCloseRequested()){
			
			
			tick();
			
			boolean falling = false;
			
			if(getBlockAt(cam.getX(),cam.getY()+Block.getSize()*2,cam.getZ()) instanceof AirBlock){
				System.out.println("COBBLE!");
				falling = true;
			}
			
			if(falling){
				cam.setY(cam.getY()+0.01f);
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				cam.move(1, 0.01f);
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
				cam.setY(cam.getY()-Block.getSize()/2);
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				instances.add(new CobbleBlock(-cam.getX(),-cam.getY(),-cam.getZ()));
			}
			
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
				cam.setRY(cam.getRY()-3);
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
				cam.setRY(cam.getRY()+3);
			}
			
			
			float mx = Mouse.getX();
			float my = HEIGHT - Mouse.getY() +1;
			
			float centerx = WIDTH/2;
			float centery = HEIGHT/2;
			
			cam.setRY(cam.getRY()+Mouse.getDX());
			cam.setRX(cam.getRX()-Mouse.getDY());
			
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			cam.useView();
			
			
			
			
			
			
			

		
			
			GL11.glPushMatrix();
			
			
			for(Instance instance : instances){

				instance.draw();
			}
			
			GL11.glPopMatrix();
			
			
			
			
			
			
			
			
			
			

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}

	void tick(){
		for(Instance instance : instances){
			instance.tick();
		}
		
		
		
		
		
	}


	public static void main(String[] args){
		new Main();
	}
	
	public void loadTextures(){
		
	}
	
	public Block getBlockAt(float x, float y, float z){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			if(
					instance.x >= -x && instance.x <= -x+Block.getSize() &&
					instance.y >= -y && instance.y <= -y+Block.getSize() &&
					instance.z >= -z && instance.z <= -z+Block.getSize()
					
			){
				return (Block) instance;
			}
		}
		
		return new AirBlock(x,y,z);
	}

	
}
