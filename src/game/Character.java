package game;

import city.cs.engine.*;


public class Character extends Walker {
    private final static BoxShape studentShape = new BoxShape(0.5F, 2);
    private final BodyImage studentImage = new BodyImage("data/unclegrandpa1.png" , 4);

    public Character(World world){
        super(world, studentShape);
        addImage(studentImage);
    }
}
