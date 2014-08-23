package nu.sebka.main.blocks;

import nu.sebka.main.Block;
import nu.sebka.main.TextureBank;

public class LogBlock extends Block {

    public LogBlock(float x, float y, float z) {
        super(x, y, z);
        textures[0] = TextureBank.LOG_SIDE;
        textures[1] = TextureBank.LOG_SIDE;
        textures[2] = TextureBank.LOG_SIDE;
        textures[3] = TextureBank.LOG_SIDE;
        textures[4] = TextureBank.LOG_TOP;
        textures[5] = TextureBank.LOG_TOP;
    }

}
