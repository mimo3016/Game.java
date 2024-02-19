package game;

import city.cs.engine.*;


public class Character extends DynamicBody {
    private final static BoxShape studentShape = new BoxShape(1, 2);
    private final BodyImage studentImage = new BodyImage("data/rickg.png" , 4);

    public Character(World world){
        super(world, studentShape);
        addImage(studentImage);
    }
}
