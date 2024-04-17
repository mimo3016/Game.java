package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

public class MyCollisionListener implements CollisionListener {

    private GameLevel world;
    private GameStepListener stepListener;
    private GameLevel platform6;
    private Game game;

    public MyCollisionListener(GameLevel world, GameStepListener stepListener, GameLevel platform6, Game game) {
        this.world = world;
        this.stepListener = stepListener;
        this.platform6 = platform6;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e) {
        // Check if the collision involves the character and an enemy
        if ((e.getOtherBody() instanceof Character && e.getReportingBody() instanceof Enemies) ||
                (e.getOtherBody() instanceof Enemies && e.getReportingBody() instanceof Character) ||
                (e.getOtherBody() instanceof Character && e.getReportingBody() instanceof FlyingEnemy) ||
                (e.getOtherBody() instanceof FlyingEnemy && e.getReportingBody() instanceof Character)) {
            // Destroy the enemy
            if (e.getOtherBody() instanceof Enemies) {
                ((Enemies) e.getOtherBody()).destroy();
            } else if (e.getOtherBody() instanceof FlyingEnemy) {
                ((FlyingEnemy) e.getOtherBody()).destroy();
            }
            // Display game over image
            displayGameOverImage();
            // Stop the game
            world.stop();
        }

        if (e.getOtherBody() instanceof Character && e.getReportingBody() instanceof Keys) {
            // Remove the collected key
            e.getReportingBody().destroy();

            // Increment the key count in the character
            world.getCharacter().addKeys();

            // Debugging output
            System.out.println("Keys collected: " + world.getCharacter().getKeysCount());

            // Check if all keys have been collected
            if (world.getCharacter().getKeysCount() >= 2) {
                // Transition to the next level
                game.goToNextLevel();
            }
        }
    }



    private void displayGameOverImage() {
        // Load the game over image
        ImageIcon icon = new ImageIcon("data/lose.jpg");
        // Show the image in a JOptionPane
        JOptionPane.showMessageDialog(null, "", "Game Over", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
