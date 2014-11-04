package nu.sebka.main.blocks;

import org.newdawn.slick.opengl.Texture;

import nu.sebka.main.Block;

public class LogBlock extends Block {
	public static Texture LOG_TOP = loadTexture("logtop");
	public static Texture LOG_SIDE = loadTexture("logside");

    public LogBlock(float x, float y, float z) {
        super(x, y, z);
        textures[0] = LOG_SIDE;
        textures[1] = LOG_SIDE;
        textures[2] = LOG_SIDE;
        textures[3] = LOG_SIDE;
        textures[4] = LOG_TOP;
        textures[5] = LOG_TOP;
    }

}
