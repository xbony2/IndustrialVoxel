package nu.sebka.main;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

	public static int SCALE = 2;
	public static int WIDTH = (640) * SCALE;
	public static int HEIGHT = (WIDTH / 16 * 9);

	static ArrayList<World> worlds = new ArrayList<World>();
	public static int worldIndex = 0;
	


	public Main(){

		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Minecraft");
			Display.create();
			worlds.add(new World());
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		while(!Display.isCloseRequested()){
			

			GL11.glPushMatrix();
			
			update();
			
			GL11.glPopMatrix();
			

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}

	void update(){
		
		for(World world : worlds){
			world.tick();
			world.draw();
		}


	}


	public static void main(String[] args){
		new Main();
	}

	public static World getCurrentWorld(){
		return worlds.get(worldIndex);
	}
	
	

	







}
