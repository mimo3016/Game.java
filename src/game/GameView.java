package game;
import java.awt.*;

import city.cs.engine.UserView;

import javax.swing.*;

public class GameView extends UserView {
    private Image background;




    @Override
    protected void paintBackground(Graphics2D g) {
        String backgroundImagePath = ((GameLevel) getWorld()).getBackgroundImagePath();
        Image backgroundImage = new ImageIcon(backgroundImagePath).getImage();

        // Scale the background image to match the dimensions of the GameView
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        g.drawImage(backgroundImage, 0, 0, viewWidth, viewHeight, this);
    }


    public GameView(GameLevel world, int width, int height) {


        super(world, width, height);
        //background = new ImageIcon("data/cyb.gif").getImage();
        //background = background.getScaledInstance(800, 500, Image.SCALE_SMOOTH);


    }
}