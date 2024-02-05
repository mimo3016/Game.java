package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {


    /** Initialise a new Game. */
    public Game() {

        //1. make an empty game world
        World world = new World();

        //2. populate it with bodies (ex: platforms, collectibles, characters)

        //make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a suspended platform
        Shape platformShape = new BoxShape(1, 0.5f);
        StaticBody platform1 = new StaticBody(world, platformShape);
        platform1.setPosition(new Vec2(-8, -9f));

        // make a second suspended platform
        Shape platformShape1 = new BoxShape(1, 0.5f);
        StaticBody platform2 = new StaticBody(world, platformShape1);
        platform2.setPosition(new Vec2(-2, -6f));

        // make a third suspended platform
        Shape platformShape2 = new BoxShape(1, 0.5f);
        StaticBody platform3 = new StaticBody(world, platformShape2);
        platform3.setPosition(new Vec2(10, -3f));

        // make a fourth suspended platform
        Shape platformShape3 = new BoxShape(1, 0.5f);
        StaticBody platform4 = new StaticBody(world, platformShape3);
        platform4.setPosition(new Vec2(4, -1f));

        // make a fifth suspended platform
        Shape platformShape4 = new BoxShape(1, 0.5f);
        StaticBody platform5 = new StaticBody(world, platformShape4);
        platform5.setPosition(new Vec2(-8, 4f));

        // make a sixth suspended platform
        Shape platformShape5 = new BoxShape(1, 0.5f);
        StaticBody platform6 = new StaticBody(world, platformShape5);
        platform6.setPosition(new Vec2(-4, 6f));

        // make a seventh suspended platform
        Shape platformShape6 = new BoxShape(1, 0.5f);
        StaticBody platform7 = new StaticBody(world, platformShape6);
        platform7.setPosition(new Vec2(4, 6f));

        //make a character (with an overlaid image)
        Shape studentShape = new BoxShape(1,2);
        DynamicBody student = new DynamicBody(world, studentShape);
        student.setPosition(new Vec2(5,-5));
        student.addImage(new BodyImage("data/rickg.png", 4));


        //3. make a view to look into the game world
        UserView view = new UserView(world, 500, 500);


        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

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
         JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
