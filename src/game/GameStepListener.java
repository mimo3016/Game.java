package game;

import city.cs.engine.StaticBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class GameStepListener implements StepListener {

    private StaticBody platform;
    private Enemies enemies;


    private boolean movingRight = true;

    public GameStepListener(StaticBody platform, Enemies enemies){
        this.platform = platform;
        this.enemies = enemies;

    }


    float x = 10;
    @Override
    public void preStep(StepEvent stepEvent) {

        platform.setPosition(platform.getPosition().add(new Vec2(-0.01f, 0)));
        platform.setPosition(new Vec2(x-=0.01, -3f));


        // Check if enemies reach the left or right edge
        float xPosition = enemies.getPosition().x;
        if (xPosition <= -6 || xPosition >= 10) {
            // Change direction
            movingRight = !movingRight;
        }

        // Move enemies accordingly
        float moveAmount = movingRight ? 8f : -8f;
        enemies.setLinearVelocity(new Vec2(moveAmount, 0));


    }

    @Override
    public void postStep(StepEvent stepEvent) {


    }
}
