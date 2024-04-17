package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class KeysPickup implements CollisionListener {

    private Character character;
    public KeysPickup(Character s){
        this.character = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Keys) {
            character.addKeys();
            e.getOtherBody().destroy();
        }
    }
}