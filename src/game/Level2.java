package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    private Shape shape = new BoxShape(30, 0.5f);
    //private Character character = new Character(this);

    private Enemies enemies;
    private FlyingEnemy enemy;

    private StaticBody platform;
    private StaticBody platform5;

    private GameStepListener gameStepListener;
    private MyCollisionListener collisionListener;

    public void addMyCollisionListener(MyCollisionListener listener) {
        this.collisionListener = listener;
    }

    public Level2(Game game) {
        super(game);
        Character character = getCharacter();
        character.setGravityScale(10);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // Set the positions of enemies and the flying enemy
        enemies = new Enemies(this);
        enemy = new FlyingEnemy(this);
        enemies.setPosition(new Vec2(10, -10));
        enemy.setPosition(new Vec2(8, 2));

        // Initialize platform5
        Shape platformShape4 = new BoxShape(1, 0.5f);
        platform5 = new StaticBody(this, platformShape4);
        platform5.setPosition(new Vec2(10, 6f));

         //Make a sixth suspended platform
        Shape platformShape5 = new BoxShape(2, 0.9f);
        platform = new StaticBody(this, platformShape5);
        platform.setPosition(new Vec2(-4, 6f));
        BodyImage platformImage = new BodyImage("data/ufo.gif", 4f);
        platform.addImage(platformImage);

        // Initialize the collision listener
        collisionListener = new MyCollisionListener(this, gameStepListener, this, game);
        addMyCollisionListener(collisionListener);

        // Create and add a step listener
        gameStepListener = new GameStepListener(platform, enemies, enemy, platform5);
        addStepListener(gameStepListener);

        // Add collision listener to character
        getCharacter().addCollisionListener(collisionListener);
    }

    public StaticBody getPlatform() {
        return platform;
    }

    public StaticBody getPlatform5() {
        return platform5;
    }

    @Override
    public boolean isComplete() {
        return getCharacter().getKeysCount() > 1;
    }

    @Override
    public String getBackgroundImagePath() {
        return "data/back.gif"; // Replace with the actual path to your background image
    }



}

