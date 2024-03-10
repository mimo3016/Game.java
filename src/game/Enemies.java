package game;

import city.cs.engine.*;

import java.awt.*;


public class Enemies extends Walker {
    private final static BoxShape studentShape = new BoxShape(0.01F, 1.3F);
    private final BodyImage studentImage = new BodyImage("data/npizza.png" , 3);

    public Enemies(World world , boolean disableGravity){
        super(world, studentShape);
        addImage(studentImage);

        setFillColor(new Color(0, 0, 0, 0));
        setLineColor(new Color(0, 0, 0, 0));

        if (disableGravity) {
            setGravityScale(0);
        }

    }


}
