package nu.sebka.main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import org.lwjgl.opengl.GL11;

public class Camera 
{
	private float x;
	private float y;
	private float z;
	private float rx;
	private float ry;
	private float rz;

	private float fov;
	private float aspect;
	private float near;
	private float far;

	public Camera(float fov, float aspect, float near, float far)
	{
		x = 0;
		y = 0;
		z = 0;
		rx = 0;
		ry = 0;
		rz = 0;

		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		initProjection();
	}

	private void initProjection()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov,aspect,near,far);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		glEnable(GL_LIGHTING);
		glEnable(GL_LIGHT0);
		
		// Create light components
		
		float ambientLight[] = { 0.2f, 0.2f, 0.2f, 1.0f };
		float diffuseLight[] = { 0.8f, 0.8f, 0.8f, 1.0f };
		float specularLight[] = { 0.5f, 0.5f, 0.5f, 1.0f };
		float position[] = { -1.5f, 1.0f, -4.0f, 1.0f };
	
		
		
		// Assign created components to GL_LIGHT0
		glLightf(GL_LIGHT0, GL_AMBIENT, ambientLight[0]);
		glLightf(GL_LIGHT0, GL_DIFFUSE, diffuseLight[0]);
		glLightf(GL_LIGHT0, GL_SPECULAR, specularLight[0]);
		glLightf(GL_LIGHT0, GL_POSITION, position[0]);
		  
		   
		   

		   
	
	}

	public void useView()
	{
		glRotatef(rx,1,0,0);
		glRotatef(ry,0,1,0);
		glRotatef(rz,0,0,1);
		glTranslatef(x,y,z);
		
		
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public float getZ()
	{
		return z;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public void setZ(float z)
	{
		this.z = z;
	}

	public float getRX()
	{
		return rx;
	}

	public float getRY()
	{
		return ry;
	}

	public float getRZ()
	{
		return rz;
	}

	public void setRX(float rx)
	{
		this.rx = rx;
	}

	public void setRY(float ry)
	{
		this.ry = ry;
	}

	public void setRZ(float rz)
	{
		this.rz = rz;
	}
	
	public void move(float dir, float amt ){
		z += amt * Math.sin(Math.toRadians(ry + 90 *dir));
		x += amt * Math.cos(Math.toRadians(ry + 90 *dir));
	}
}