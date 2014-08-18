package nu.sebka.main;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Main {

	public static int SCALE = 2;
	public static int WIDTH = (640) * SCALE;
	public static int HEIGHT = (WIDTH / 16 * 9);
	public static Texture dirttext;
	public static Texture grasstext;

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

		for(float i = 0; i < 16; i+=0.1f){
			for(float ii= 0; ii < 16; ii+=0.1f){
				instances.add(new Block(i,-0.1f,-ii));
			}
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();

		GLU.gluPerspective((float)30f, (float)WIDTH/HEIGHT, 0.001f, 100f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT,GL11.GL_NICEST);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_TEXTURE_2D);




		//GL11.glEnable(GL11.GL_CULL_FACE);

		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_BLEND);
		loadTextures();
		GL11.glRotatef(10, 1.0f, 0.0f, 0.f);
		GL11.glRotatef(30, 0.0f, 1.0f, 0.f);

		while(!Display.isCloseRequested()){
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			
			tick();
			
			
			
			
			GL11.glTranslatef(xx, yy, zz);
			for(Instance instance : instances){

				instance.draw();
			}
			
			
			GL11.glTranslatef(-xx, -yy, -zz);
			
			
			
			
			
			
			
			System.out.println("X: "+xx+" Y:"+ yy +" Z:"+zz+"YORIENT: "+yorient+" ANGLE:"+yorient);
			
			

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
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			
			zz += (float)Math.cos(Math.toRadians(yorient));
			xx += (float)Math.sin(Math.toRadians(yorient));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			yorient += 6;
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			yorient -= 6;
			
		}
		
		float mx = Mouse.getX();
		float my = HEIGHT - Mouse.getY() +1;
		
		float centerx = WIDTH/2;
		float centery = HEIGHT/2;
		
		
	}


	public static void main(String[] args){
		new Main();
	}

	public static void loadTextures(){
		try {
			dirttext = TextureLoader.getTexture("png", ResourceLoader.getResourceAsStream("res/dirty.png"));
			grasstext = TextureLoader.getTexture("png", ResourceLoader.getResourceAsStream("res/grass.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
