package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalEncounter implements CollisionListener {

    GameLevel level;
    Game g;
    public PortalEncounter(GameLevel level, Game game){
        this.level = level;
        g = game;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Portal){
            System.out.println("Character collided with portal");
            //  Student s = (Student)e.getReportingBody();
            //  s.setCredits(s.getCredits()+15);
            if (level.isComplete()){
                g.goToNextLevel();
            }
        }
    }
}