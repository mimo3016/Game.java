package game;
import java.awt.*;

import city.cs.engine.UserView;

import javax.swing.*;

public class GameView extends UserView {
    private Image background;
    private int health = 100;



    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {

        g.setColor(Color.green);
        g.fillRect(getWidth()-465, 30, health, 20);

    }
    public GameView(GameWorld world, int width, int height) {


        super(world, width, height);
        background = new ImageIcon("data/background.jpeg").getImage();


    }
}