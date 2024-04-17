package game;

import city.cs.engine.*;

import javax.swing.JFrame;


/**
 * Your main game entry point
 */
public class Game {

    DemoKeyListener controller;
    GameLevel currentLevel;
    GameView view;
    Character character;


    /** Initialise a new Game. */
    public Game() {


        currentLevel = new Level1(this);

        // Initialize character after currentLevel
        character = currentLevel.getCharacter();
        controller = new DemoKeyListener(currentLevel.getCharacter());

        GameStepListener stepListener = new GameStepListener(currentLevel.getPlatform(), currentLevel.getEnemies(), currentLevel.getEnemy(), currentLevel.getPlatform5()); // Add this line

        MyCollisionListener collisionListener = new MyCollisionListener(currentLevel); // Fix this line


        //1. make an empty game world

        /*StaticBody platform = currentLevel.getPlatform();
        StaticBody platform5 = currentLevel.getPlatform5();
        Enemies enemies = currentLevel.getEnemies();
        FlyingEnemy enemy = currentLevel.getEnemy();
        currentLevel.addStepListener(new GameStepListener(platform , enemies, enemy, platform5));
        Character character = currentLevel.getCharacter();*/


        // make a view




        /* set up JFrame ... */



        currentLevel.addMyCollisionListener(collisionListener);




        DemoKeyListener keyListener = new DemoKeyListener(character);
        character.setGravityScale(10);

        //2. populate it with bodies (ex: platforms, collectibles, characters)


        //3. make a view to look into the game world
        view = new GameView(currentLevel, 500, 500);
        view.addKeyListener(controller);





        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        frame.addKeyListener(controller);

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
         JFrame debugView = new DebugViewer(currentLevel, 500, 500);

        // start our game world simulation!
        currentLevel.start();
    }


    public void goToNextLevel() {
        System.out.println("Yes, let's go to the next level");

        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            Character prevCharacter = currentLevel.getCharacter();
            currentLevel = new Level2(this);
            Character newCharacter = currentLevel.getCharacter();
            view.setWorld(currentLevel);
            controller.updateCharacter(currentLevel.getCharacter());
            currentLevel.start();
        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            Character prevCharacter = currentLevel.getCharacter();
            currentLevel = new Level3(this);
            Character newCharacter = currentLevel.getCharacter();
            view.setWorld(currentLevel);
            controller.updateCharacter(currentLevel.getCharacter());
            currentLevel.start();
        } else {
            System.out.println("Game completed!");
        }
    }





    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
