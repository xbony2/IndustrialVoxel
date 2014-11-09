package nu.sebka.main;


import nu.sebka.main.blocks.GrassBlock;


public class Light extends GrassBlock {


    public Light(float x, float y, float z) {
        super(x, y, z);

    }

    @Override
    public void tick() {
        this.setY(this.getY() + 0.01F);
    }


    @Override
    public void draw() {


    }


}
