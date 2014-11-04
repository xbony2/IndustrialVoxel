package nu.sebka.main.blocks;

import org.newdawn.slick.opengl.Texture;

import nu.sebka.main.Block;

public class CobbleBlock extends Block {

	public static Texture COBBLE_TEXTURE = loadTexture("cobble");
	
    public CobbleBlock(float x, float y, float z) {
        super(IDReference.COBBLE_ID, x, y, z);
        textures[0] = COBBLE_TEXTURE;
        textures[1] = COBBLE_TEXTURE;
        textures[2] = COBBLE_TEXTURE;
        textures[3] = COBBLE_TEXTURE;
        textures[4] = COBBLE_TEXTURE;
        textures[5] = COBBLE_TEXTURE;
    }

}
