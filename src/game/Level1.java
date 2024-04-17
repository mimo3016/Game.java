package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;


public class Level1 extends GameLevel {

    Shape shape = new BoxShape(30, 0.5f);
    Shape studentShape = new BoxShape(1,2);


    StaticBody platform;

    StaticBody platform5;

    GameStepListener gameStepListener;

    private StaticBody platform6;

    Enemies enemies;
    FlyingEnemy enemy;


    private MyCollisionListener collisionListener;

    //Getter method for enemies

    public  Enemies getEnemies(){

        return enemies;
    }

    public  FlyingEnemy getEnemy(){

        return enemy;
    }

    public GameStepListener getGameStepListener(){
        return gameStepListener;
    }

    public Level1(Game game){
        super(game);

        Character character = getCharacter();
        character.setGravityScale(10);


        // Create and add keys to the level
        Keys keys1 = new Keys(this);
        keys1.setPosition(new Vec2(-5, 0)); // Example position
        Keys keys2 = new Keys(this);
        keys2.setPosition(new Vec2(3, 5)); // Example position


        enemies = new Enemies(this);
        enemy = new FlyingEnemy(this);

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

        // make a sixth suspended platform
        Shape platformShape5 = new BoxShape(2, 0.9f);
        platform6 = new StaticBody(this, platformShape5);
        platform6.setPosition(new Vec2(-4, 6f));
        BodyImage platformImage = new BodyImage("data/nportal.png", 4f);
        platform6.addImage(platformImage);


        // make a seventh suspended platform
        Shape platformShape6 = new BoxShape(1, 0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape6);
        platform7.setPosition(new Vec2(3, 8f));

        // Set up collision detection for losing condition
        // Create and add a step listener
        gameStepListener = new GameStepListener(platform, enemies, enemy, platform5);
        addStepListener(gameStepListener);

        // Create and add a collision listener
        //MyCollisionListener collisionListener = new MyCollisionListener(this, gameStepListener, this);
        //character.addCollisionListener(collisionListener);


        enemies.setPosition(new Vec2(10, -10));
        enemy.setPosition(new Vec2(8, 2));

        //this.collisionListener = new MyCollisionListener(this, gameStepListener, this);
        //character.addCollisionListener(this.collisionListener);

        //MyCollisionListener collisionListener = new MyCollisionListener(this, getGameStepListener(), this);

        // Initialize collision listener
        collisionListener = new MyCollisionListener(this); // Fix this line
        // Add collision listeners to relevant bodies
        getCharacter().addCollisionListener(collisionListener);
        getEnemies().addCollisionListener(collisionListener);
        getEnemy().addCollisionListener(collisionListener);
        getPlatform5().addCollisionListener(collisionListener);
        platform6.addCollisionListener(collisionListener); // Assuming platform6 is accessible

        // Set the positions of enemies and the flying enemy
        getEnemies().setPosition(new Vec2(10, -10));
        getEnemy().setPosition(new Vec2(8, 2));



    }




    public StaticBody getPlatform(){
        return platform;
    }
    public StaticBody getPlatform5(){
        return platform5;
    }



    @Override
    public boolean isComplete() {
        return getCharacter().getKeysCount() > 1;
    }

    @Override
    public String getBackgroundImagePath() {
        return "data/background.jpeg"; // Replace with the actual path to your background image
    }



}



