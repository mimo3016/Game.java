package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

import javax.swing.*;
import java.awt.*;

public class MyCollisionListener implements CollisionListener {

    private GameWorld world;
    private GameStepListener stepListener;

    private GameWorld platform6;

    public MyCollisionListener(GameWorld world, GameStepListener stepListener, GameWorld platform6) {
        this.world = world;
        this.stepListener = stepListener;
        this.platform6 = platform6;
    }

    @Override
    public void collide(CollisionEvent e) {
        // Check if the collision involves the character and an enemy
        if ((e.getOtherBody() instanceof Character && e.getReportingBody() instanceof Enemies) ||
                (e.getOtherBody() instanceof Enemies && e.getReportingBody() instanceof Character) ||
                (e.getOtherBody() instanceof Character && e.getReportingBody() instanceof FlyingEnemy) ||
                (e.getOtherBody() instanceof FlyingEnemy && e.getReportingBody() instanceof Character)) {
            // Display game over image
            displayGameOverImage();

            // Stop the game
            world.stop();
        }
        else if ((e.getOtherBody() instanceof Character && e.getReportingBody() instanceof StaticBody)) {
                 displayPlatform6Image();
        }
    }



    private void displayGameOverImage() {
        // Load the game over image
        ImageIcon icon = new ImageIcon("data/lose.jpg");

        // Show the image in a JOptionPane
        JOptionPane.showMessageDialog(null, "", "Game Over", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    private void displayPlatform6Image() {
        // Load the image for platform6 collision
        ImageIcon icon = new ImageIcon("data/win.jpg");

        // Show the image in a JOptionPane
        JOptionPane.showMessageDialog(null, "", "Platform 6 Collision", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
