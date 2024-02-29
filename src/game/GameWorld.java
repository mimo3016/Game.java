package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    Shape shape = new BoxShape(30, 0.5f);
    Shape studentShape = new BoxShape(1,2);
    Character character = new Character(this);

    //Getter Method
    public Character getStudent(){

        return character;
    }

    
    public GameWorld(){
        //make a ground platform

        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a suspended platform
        Shape platformShape = new BoxShape(1, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -9f));

        // make a second suspended platform
        Shape platformShape1 = new BoxShape(1, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(-3, -6f));

        // make a third suspended platform
        Shape platformShape2 = new BoxShape(1, 0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(10, -3f));

        // make a fourth suspended platform
        Shape platformShape3 = new BoxShape(1, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape3);
        platform4.setPosition(new Vec2(4, -1f));

        // make a fifth suspended platform
        Shape platformShape4 = new BoxShape(1, 0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape4);
        platform5.setPosition(new Vec2(-8, 4f));

        // make a sixth suspended platform
        Shape platformShape5 = new BoxShape(1, 0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape5);
        platform6.setPosition(new Vec2(-4, 6f));

        // make a seventh suspended platform
        Shape platformShape6 = new BoxShape(1, 0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape6);
        platform7.setPosition(new Vec2(4, 6f));


    }
}
