package game;

import city.cs.engine.*;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;


/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;
    /** Initialise a new Game. */
    public Game() {




        //1. make an empty game world
        GameWorld world = new GameWorld();
        StaticBody platform = world.getPlatform();
        StaticBody platform5 = world.getPlatform5();
        Enemies enemies = world.getEnemies();
        FlyingEnemy enemy = world.getEnemy();
        world.addStepListener(new GameStepListener(platform , enemies, enemy, platform5));
        Character character = world.getCharacter();


        // make a view




        /* set up JFrame ... */


        GameStepListener stepListener = new GameStepListener(world.getPlatform(), world.getEnemies(), world.getEnemy(), world.getPlatform5());
        MyCollisionListener collisionListener = new MyCollisionListener(world, stepListener , world);
        world.addMyCollisionListener(collisionListener);



        DemoKeyListener keyListener = new DemoKeyListener(character);
        character.setGravityScale(10);

        //2. populate it with bodies (ex: platforms, collectibles, characters)


        //3. make a view to look into the game world
        GameView view = new GameView(world, 500, 500);




        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        frame.addKeyListener(new DemoKeyListener(character));

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
         //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }




    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
