package game;

import city.cs.engine.StaticBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class GameStepListener implements StepListener {

    private StaticBody platform;

    public GameStepListener(StaticBody platform){
        this.platform = platform;

    }

    float x = 10;
    @Override
    public void preStep(StepEvent stepEvent) {

        platform.setPosition(new Vec2(x-=0.15, -3f));

        if (platform.setPosition(new Vec2(-10, -3f));)
        {
            platform.setPosition(new Vec2(x+=0.15, -3f));
        }
        else if(platform.setPosition(new Vec2(15, -3f));)
        {
            platform.setPosition(new Vec2(x-=0.15, -3f));
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
