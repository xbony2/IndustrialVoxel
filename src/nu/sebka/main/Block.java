package nu.sebka.main;

import java.util.Random;

import org.lwjgl.opengl.GL11;


public class Block extends Instance {
	
	float size = 0.05f;
	Random random = new Random();
	public Block(float x, float y, float z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(random.nextInt(50) == 0){
		y += 0.01f;
		}
		
	}

	@Override
	public void draw() {
		
		
		if(Main.dirttext != null){
		Main.dirttext.bind();
		}
		
		
		// White side - BACK
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(  x+size,y+ -size,z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f(  x+size, y+ size,z+ size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+-size, y+ size,z+ size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+-size, y+-size,z+ size );
		GL11.glEnd();
		
		// White side - FRONT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(  x+size,y+ -size,z- size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f(  x+size, y+ size,z- size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+-size, y+ size,z- size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+-size, y+-size,z- size );
		GL11.glEnd();
		 
		// Purple side - RIGHT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(x+ size,y+ -size,z+ -size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+size, y+ size,z+ -size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f( x+size, y+ size,z+  size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f( x+size,y+ -size,z+  size );
		GL11.glEnd();
		 
		// Green side - LEFT
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f(x+ -size,y+ -size, z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+-size, y+ size, z+ size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f(x+ -size, y+ size, z+-size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f(x+ -size, y+-size, z+-size );
		GL11.glEnd();
		 
		
		if(Main.grasstext != null){
			Main.grasstext.bind();
			}
		
		// Blue side - TOP
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(   1.0f,  1.0f,  1.0f );
		GL11.glTexCoord2f(1,0);	GL11.glVertex3f( x+ size, y+ size, z+ size );
		GL11.glTexCoord2f(0,0);	GL11.glVertex3f( x+ size,  y+size,z+ -size );
		GL11.glTexCoord2f(0,1);	GL11.glVertex3f(x+ -size,  y+size,z+ -size );
		GL11.glTexCoord2f(1,1);	GL11.glVertex3f(x+-size,  y+size, z+ size );
		GL11.glEnd();
		 
		if(Main.dirttext != null){
			Main.dirttext.bind();
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
	
	
	

}
