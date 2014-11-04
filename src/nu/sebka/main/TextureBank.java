package nu.sebka.main;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureBank {

    public static Texture GRASS_TEXTURE = loadTexture("grass");
    public static Texture DIRT_TEXTURE = loadTexture("dirt");
    public static Texture COBBLE_TEXTURE = loadTexture("cobble");
    public static Texture LOG_TOP = loadTexture("logtop");
    public static Texture LOG_SIDE = loadTexture("logside");
    public static Texture SHADOW = loadTexture("shadow");

    public static Texture loadTexture(String texturename) {
        try {
            Texture texture = TextureLoader.getTexture("png", ResourceLoader.getResourceAsStream("res/" + texturename + ".png"));

            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            return texture;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
