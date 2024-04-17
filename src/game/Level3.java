package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {

    private Shape shape = new BoxShape(30, 0.5f);
    private Enemies enemies;
    private FlyingEnemy enemy;
    private StaticBody platform;
    private StaticBody platform5;
    private GameStepListener gameStepListener;
    private MyCollisionListener collisionListener;

    public Level3(Game game) {
        super(game);

        Character character = getCharacter();
        character.setGravityScale(10);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // Initialize enemies and flying enemy
        enemies = new Enemies(this);
        enemy = new FlyingEnemy(this);
        enemies.setPosition(new Vec2(10, -10));
        enemy.setPosition(new Vec2(8, 2));

        // Set enemy images
        BodyImage enemyImage = new BodyImage("data/knightrb.png", 5f);
        enemies.removeAllImages();
        enemies.addImage(enemyImage);

        BodyImage flyingEnemyImage = new BodyImage("data/wizrb.png", 5f);
        enemy.removeAllImages();
        enemy.addImage(flyingEnemyImage);

        // Initialize platform5
        Shape platformShape5 = new BoxShape(2, 0.9f);
        platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-4, 6f));

        // Set platform5 image
        BodyImage platformImage = new BodyImage("data/ufo.gif", 4f);
        platform5.addImage(platformImage);

        // Initialize collision listener
        collisionListener = new MyCollisionListener(this); // Assuming MyCollisionListener constructor requires a GameLevel instance
        // Add collision listeners to relevant bodies
        getCharacter().addCollisionListener(collisionListener);
        enemies.addCollisionListener(collisionListener);
        enemy.addCollisionListener(collisionListener);
        platform5.addCollisionListener(collisionListener);

        // Create and add a step listener
        gameStepListener = new GameStepListener(platform5, enemies, enemy, platform); // Assuming platform is properly initialized
        addStepListener(gameStepListener);
    }

    @Override
    public StaticBody getPlatform() {
        return platform;
    }

    @Override
    public StaticBody getPlatform5() {
        return platform5;
    }

    @Override
    public boolean isComplete() {
        return getCharacter().getKeysCount() > 1;
    }

    @Override
    public String getBackgroundImagePath() {
        return "data/beach.gif"; // Replace with the actual path to your background image
    }
}
