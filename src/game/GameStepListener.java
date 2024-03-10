package game;

import city.cs.engine.StaticBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class GameStepListener implements StepListener {

    private StaticBody platform;
    private Enemies enemies;
    private FlyingEnemy enemy;
    private StaticBody platform5;


    private boolean movingRight = true;
    private boolean enemyMovingRight = true;
    private boolean platformMovingRight = true;
    private boolean platform5MovingUp = true;


    public GameStepListener(StaticBody platform, Enemies enemies, FlyingEnemy enemy, StaticBody platform5){
        this.platform = platform;
        this.enemies = enemies;
        this.enemy = enemy;
        this.platform5 = platform5;

    }


    float x = 10;
    @Override
    public void preStep(StepEvent stepEvent) {


        //enemies
        float xPosition = enemies.getPosition().x;
        if (xPosition <= -6 || xPosition >= 10) {

            movingRight = !movingRight;
        }

        float moveAmount = movingRight ? 6f : -6f;
        enemies.setLinearVelocity(new Vec2(moveAmount, 0));


        //flying enemy
        float enemyPosition = enemy.getPosition().x;
        if (enemyPosition <= -12 || enemyPosition >= 8) {
            enemyMovingRight = !enemyMovingRight;
        }


        float enemyMoveAmount = enemyMovingRight ? 3f : -3f;
        enemy.setLinearVelocity(new Vec2(enemyMoveAmount, 0));

        //platform
        float platformPosition = platform.getPosition().x;
        if (platformPosition <= -11 || platformPosition >= 11) {
            platformMovingRight = !platformMovingRight;
        }


        float platformMoveAmount = platformMovingRight ? 0.15f : -0.15f;
        platform.setPosition(platform.getPosition().add(new Vec2(platformMoveAmount, 0)));

        // Platform5 (move vertically)
        float platform5PositionY = platform5.getPosition().y;
        if (platform5PositionY <= -1 || platform5PositionY >= 9) {
            platform5MovingUp = !platform5MovingUp;
        }
        float platform5MoveAmountY = platform5MovingUp ? 0.05f : -0.05f;
        platform5.setPosition(platform5.getPosition().add(new Vec2(0, platform5MoveAmountY)));


    }

    @Override
    public void postStep(StepEvent stepEvent) {


    }
}
