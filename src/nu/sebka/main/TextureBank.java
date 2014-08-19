package nu.sebka.main;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureBank {

	public static Texture GRASS_TEXTURE = loadTexture("png","res/grass.png");
	public static Texture DIRT_TEXTURE = loadTexture("png","res/dirt.png");
	public static Texture COBBLE_TEXTURE = loadTexture("png","res/cobble.png");
	public static Texture DIAMOND_ORE_TEXTURE = loadTexture("Png","res/diamond_ore.png");
	public static Texture LOG_TOP = loadTexture("png","res/logtop.png");
	public static Texture LOG_SIDE = loadTexture("png","res/logside.png");

			public static Texture loadTexture(String format, String path){
		try {
			
			Texture texture = TextureLoader.getTexture(format, ResourceLoader.getResourceAsStream(path));
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			return texture;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
	
}
