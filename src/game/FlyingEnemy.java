package game;

import city.cs.engine.*;

import java.awt.*;

public class FlyingEnemy extends Walker{
    private final static BoxShape studentShape = new BoxShape(0.02F, 1.1F);
    private final BodyImage studentImage = new BodyImage("data/flyr.png" , 3);

    public FlyingEnemy(World world){

        super(world, studentShape);
        addImage(studentImage);

        setFillColor(new Color(0, 0, 0, 0));
        setLineColor(new Color(0, 0, 0, 0));

        setGravityScale(0);
    }

}
