package game;
import java.awt.*;

import city.cs.engine.UserView;

import javax.swing.*;

public class GameView extends UserView {
    private Image background;




    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }


    public GameView(GameLevel world, int width, int height) {


        super(world, width, height);
        background = new ImageIcon("data/background.jpeg").getImage();


    }
}