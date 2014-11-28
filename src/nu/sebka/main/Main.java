package nu.sebka.main;

import java.io.File;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {

    public static int SCALE = 2;
    public static int WIDTH = (640) * SCALE;
    public static int HEIGHT = (WIDTH / 16 * 9);

    static ArrayList<World> worlds = new ArrayList<World>();
    public static int worldIndex = 0;


    public Main(){
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("IndustrialVoxel");
            Display.create();
            worlds.add(new World());
        } catch (LWJGLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while (!Display.isCloseRequested()) {

            GL11.glPushMatrix();

            update();

            GL11.glPopMatrix();

            Display.update();
            Display.sync(60);
        }
        Display.destroy();
        System.exit(0);
    }

    void update() {

        for (World world : worlds) {
            world.tick();
            world.draw();
        }


    }


    public static void main(String[] args){
        String operatingSystem = System.getProperty("os.name");
        File home = new File("./lib/natives");
        if (operatingSystem.contains("Windows")) {
            System.setProperty("org.lwjgl.librarypath", new File(home, "windows").getAbsolutePath());
        } else if (operatingSystem.contains("Mac")) {
            System.setProperty("org.lwjgl.librarypath", new File(home, "macosx").getAbsolutePath());
        } else if (operatingSystem.contains("Linux")) {
            System.setProperty("org.lwjgl.librarypath", new File(home, "linux").getAbsolutePath());
        } else if (operatingSystem.contains("Sun")) {
            System.setProperty("org.lwjgl.librarypath", new File(home, "solaris").getAbsolutePath());
        }
        new Main();
    }

    public static World getCurrentWorld() {
        return worlds.get(worldIndex);
    }


}
