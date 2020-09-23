package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

// THESE ARE CLASSES FOR THE AUDIO
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The computer game.
 */
public class Game {
    
    private GameLevel world;
    private MyView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic; // THIS IS FOR MUSIC
    private ControlPanel panel;


    /** Initialise a new Game. */
    public Game() {

        level = 1;
        world = new Level1();
        world.populate(this);
        view = new MyView(world, this, 1000, 1000);
        
        // make the world
        //world = new GameWorld();


        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Multi-level Game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        panel = new ControlPanel(this);
        frame.add(panel, BorderLayout.EAST);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        
        
        
        frame.addKeyListener(new Controller(world.getPlayer()));
        
        
        // uncomment to make the view track Goku
        //Sworld.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // start!
        world.start();
        
        try {
            gameMusic = new SoundClip("data/DBZ - Perfect Cell Theme.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }  
    }
    
    /**
     * returns the main character 
     * @return
     */
    public Goku getPlayer() {
        return world.getPlayer();
    }
    
    /**
     * detects if the level is completed
     * @return
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /**
     * returns world
     * @return
     */
    public GameLevel getWorld(){
        return world;
    }
    
    /**
     * this method allows a user to progress to the next level
     */
    public void goNextLevel() {
        world.stop();
        if (level == 5) {
            System.exit(0);
        } else if(level == 4) {
            level++;
            world = new Level5();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else if(level == 3) {
            level++;
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else if(level == 2) {
            level++;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else  {
            level++;
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
    }
    
    /**
     * this method allows you to restart levels
     */
    public void restartLevel(){
        world.stop();
        if (level == 5) {
            world = new Level5();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        } else if(level == 4) {
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else if(level == 3) {
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else if(level == 2) {
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else  {
            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
    
    }

    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Game();
        
             
    }
}
