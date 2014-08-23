package nu.sebka.main;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.util.Random;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.GrassBlock;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Camera {
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

    public Camera(float fov, float aspect, float near, float far) {
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

    private void initProjection() {


        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(fov, aspect, near, far);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);


        //...
        // enable face culling


    }


    public void useView() {


        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);


        glRotatef(rx, 1, 0, 0);
        glRotatef(ry, 0, 1, 0);
        glRotatef(rz, 0, 0, 1);
        glTranslatef(-x, -y, -z);


    }


    public void tick() {
        boolean falling = false;
        boolean canmove = true;
        float fallspeed = 0.01f;

        System.out.println(Main.getCurrentWorld().getBlockAt(x, y + Block.getSize() * 2, z));

        if (Main.getCurrentWorld().getBlockAt(getX(), getY() + Block.getSize() * 2, getZ()) instanceof AirBlock) {
            falling = true;
        }


        if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
            Random random = new Random();
            GL11.glCullFace(random.nextInt(5));
            GL11.glEnable(GL11.GL_CULL_FACE);
        }


        while (Keyboard.next()) {
            if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
                if (Keyboard.getEventKeyState()) {
                    System.out.println("BLOCK PLACE");
                    Block block = Main.getCurrentWorld().getBlockAt(x, y + Block.getSize() * 2, z);
                    Block topblock = Main.getCurrentWorld().getBlockAtPrecise(block.x, block.y - Block.getSize() * 2, block.z);
                    if (topblock instanceof AirBlock) {
                        Main.getCurrentWorld().instances.add(new GrassBlock(block.x, block.y - Block.getSize(), block.z));
                    }
                }
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_W) && canmove) {
            move(1, 0.01f);
            try {
                Mouse.setNativeCursor(null);
            } catch (LWJGLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_S) && canmove) {
            move(-1, 0.01f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A) && canmove) {
            move(2, 0.01f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_D) && canmove) {
            move(0, 0.01f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            setY(getY() - Block.getSize() / 2);

        }

        if (falling) {
            fallspeed += 0.00016f;
            setY(getY() + fallspeed);
        } else {
            fallspeed = 0.01f;
        }


        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            setRY(getRY() - 3);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            setRY(getRY() + 3);
        }


        setRY(getRY() - Mouse.getDX());
        setRX(getRX() - Mouse.getDY());

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getRX() {
        return rx;
    }

    public float getRY() {
        return ry;
    }

    public float getRZ() {
        return rz;
    }

    public void setRX(float rx) {
        this.rx = rx;
    }

    public void setRY(float ry) {
        this.ry = ry;
    }

    public void setRZ(float rz) {
        this.rz = rz;
    }

    public void move(float dir, float amt) {
        z += amt * Math.sin(Math.toRadians(ry + 90 * dir));
        x += amt * Math.cos(Math.toRadians(ry + 90 * dir));
    }
}