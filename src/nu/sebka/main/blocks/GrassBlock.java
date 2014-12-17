package nu.sebka.main.blocks;

import org.newdawn.slick.opengl.Texture;

import nu.sebka.main.api.block.Block;

public class GrassBlock extends Block {

	public static Texture DIRT_TEXTURE = loadTexture("dirt");
	public static Texture GRASS_TEXTURE = loadTexture("grass");
	
    public GrassBlock(float x, float y, float z) {
        super(IDReference.GRASS_ID, x, y, z);
        textures[0] = DIRT_TEXTURE;
        textures[1] = DIRT_TEXTURE;
        textures[2] = DIRT_TEXTURE;
        textures[3] = DIRT_TEXTURE;
        textures[4] = DIRT_TEXTURE;
        textures[5] = GRASS_TEXTURE;
    }

}
