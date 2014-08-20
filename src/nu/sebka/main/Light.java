package nu.sebka.main;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import nu.sebka.main.blocks.GrassBlock;

import org.lwjgl.opengl.GL11;

public class Light extends GrassBlock {


	
	ByteBuffer temp = ByteBuffer.allocateDirect(16);
	float mat_specular[] = { 0.0f, 1.0f, 1.0f, 0.0f };
	float mat_shininess[] = { 0.0f, 1.0f, 1.0f, 0.0f };
	float light_position[] = { 0.0f, -1.0f, 1.0f, 0.0f };
	
	public Light(float x, float y, float z) {
		super(x, y, z);

		
	}

	@Override
	public void tick() {
		y += 0.01f;
		
	}

	
	@Override
	public void draw() {

		GL11.glTranslatef(x, y, z);
		temp.order(ByteOrder.nativeOrder());
		
		GL11.glPushMatrix();
		//GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, (FloatBuffer)temp.asFloatBuffer().put(lightAmbient).flip());// Setup The Ambient Light

		
		
			
		   GL11.glClearColor (0.0f, 0.0f, 0.0f, 0.0f);
		   GL11.glShadeModel (GL11.GL_SMOOTH);

		   
		  
		   //GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, (FloatBuffer)temp.asFloatBuffer().put(mat_specular).flip());
		   //GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SHININESS, (FloatBuffer)temp.asFloatBuffer().put(mat_shininess).flip());
		   GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, (FloatBuffer)temp.asFloatBuffer().put(light_position).flip());
		
		//GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, (FloatBuffer)temp.asFloatBuffer().put(lightAmbient).flip());// Setup The Ambient Light
		//GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, (FloatBuffer)temp.asFloatBuffer().put(lightDiffuse).flip());// Setup The Diffuse Light
		//GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION,(FloatBuffer)temp.asFloatBuffer().put(lightPosition).flip());// Position The Light
		GL11.glEnable(GL11.GL_LIGHT0);// Enable Light One
		GL11.glEnable(GL11.GL_LIGHTING);// Enable Lights
		GL11.glPopMatrix();
		GL11.glTranslatef(-x, -y, -z);
		
	}

	
}
