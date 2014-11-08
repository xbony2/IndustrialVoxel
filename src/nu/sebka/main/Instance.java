package nu.sebka.main;

public abstract class Instance {

    private float x, y, z;

    public Instance(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public abstract void tick();

    public abstract void draw();
    
    public void setX(int x){
    	this.x = x;
    }
    
    public float getX(){
    	return x;
    }
    
    public void setY(int y){
    	this.y = y;
    }
    
    public float getY(){
    	return y;
    }
    
    public void setZ(int z){
    	this.z = z;
    }
    
    public float getZ(){
    	return z;
    }
    
}
