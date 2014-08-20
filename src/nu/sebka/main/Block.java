package nu.sebka.main;

import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLightf;

import java.io.IOException;
import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Block extends Instance {
	
	private static float size = 0.04f;
	public Texture[] textures = new Texture[6];
	Random random = new Random();
	public Block(float x, float y, float z) {
		super(x, y, z);
	
	}

	@Override
	public void tick() {
		//if(random.nextInt(50) == 0){
		//y += 0.01f;
		//}
		
	}

	@Override
	public void draw() {
		
		
		
		if(textures[0] != null){
			textures[0].bind();
		}
		
		
		
		
		
		 
		// White side - BACK
		GL11.glBegin(GL11.GL_POLYGON);
		
	
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(  x+size,y+ -size,z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f(  x+size, y+ size,z+ size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+-size, y+ size,z+ size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+-size, y+-size,z+ size );
		GL11.glEnd();
		
		
		if(textures[1] != null){
			textures[1].bind();
		}
		
		// White side - FRONT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(  x+size,y+ -size,z- size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f(  x+size, y+ size,z- size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+-size, y+ size,z- size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+-size, y+-size,z- size );
		GL11.glEnd();
		 
		
		if(textures[2] != null){
			textures[2].bind();
		}
		
		// Purple side - RIGHT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(x+ size,y+ -size,z+ -size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+size, y+ size,z+ -size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+size, y+ size,z+  size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+size,y+ -size,z+  size );
		GL11.glEnd();
		 
		
		if(textures[3] != null){
			textures[3].bind();
		}
		
		
		// Green side - LEFT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(x+ -size,y+ -size, z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+-size, y+ size, z+ size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f(x+ -size, y+ size, z+-size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f(x+ -size, y+-size, z+-size );
		GL11.glEnd();
		 
		
		if(textures[4] != null){
			textures[4].bind();
		}
		
		// Blue side - TOP
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f( x+ size, y+ size, z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+ size,  y+size,z+ -size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f(x+ -size,  y+size,z+ -size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f(x+-size,  y+size, z+ size );
		GL11.glEnd();
		 
		if(textures[5] != null){
			textures[5].bind();
		}
		
		// Red side - BOTTOM
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f( x+ size, y+-size,z+ -size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+ size, y+-size,z+  size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+-size, y+-size,z+  size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+-size, y+-size, z+-size );
		GL11.glEnd();
		
		
		
		GL11.glEnd();
		
		
		
		
	}
	
	public static float getSize(){
		return size*2;
	}
	
	
	

}
