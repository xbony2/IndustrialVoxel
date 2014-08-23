package nu.sebka.main;

public abstract class Instance {

    public float x, y, z;

    public Instance(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public abstract void tick();

    public abstract void draw();
}
