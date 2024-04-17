// GameLevel class
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    Shape shape = new BoxShape(30, 0.5f);
    private Character character;
    private Enemies enemies;
    private FlyingEnemy enemy;
    private Game game;
    GameStepListener gameStepListener;
    StaticBody platform;
    StaticBody platform5;
    StaticBody platform6;
    private Portal portal;




    public GameLevel(Game game){
        this.game = game;


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
        platform = new StaticBody(this, platformShape2);
        platform.setPosition(new Vec2(10, -3f));

        // make a fourth suspended platform
        Shape platformShape3 = new BoxShape(1, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape3);
        platform4.setPosition(new Vec2(5, -1f));

        // make a fifth suspended platform
        Shape platformShape4 = new BoxShape(1, 0.5f);
        platform5 = new StaticBody(this, platformShape4);
        platform5.setPosition(new Vec2(10, 6f));

        /* make a sixth suspended platform
        Shape platformShape5 = new BoxShape(2, 0.9f);
        platform6 = new StaticBody(this, platformShape5);
        platform6.setPosition(new Vec2(-4, 6f));
        BodyImage platformImage = new BodyImage("data/nportal.png", 4f);
        platform6.addImage(platformImage);*/


        // make a seventh suspended platform
        Shape platformShape6 = new BoxShape(1, 0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape6);
        platform7.setPosition(new Vec2(3, 8f));

        // Create and add a collision listener
        character = new Character(this);
        character.addCollisionListener(new KeysPickup(character));

        // Create and add a step listener
        gameStepListener = new GameStepListener(platform, enemies, enemy, platform5);
        addStepListener(gameStepListener);

        portal = new Portal(this);
        portal.setPosition(new Vec2(-4, 6f));

        character.addCollisionListener(new PortalEncounter(this, game));



    }

    public Character getCharacter(){
        return character;
    }


    public Enemies getEnemies() {
        return enemies;
    }

    public FlyingEnemy getEnemy(){
        return enemy;
    }

    public abstract boolean isComplete();

    public StaticBody getPlatform() {
        return platform;
    }

    public StaticBody getPlatform5() {
        return platform5;
    }

    public StaticBody getPlatform6() {
        return platform6;
    }

    public Portal getPortal(){
        return portal;
    }

    public void addMyCollisionListener(MyCollisionListener collisionListener) {
    }

    public abstract String getBackgroundImagePath();
}
