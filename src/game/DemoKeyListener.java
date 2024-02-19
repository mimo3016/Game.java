package game;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoKeyListener implements KeyListener {

    Character character;

    public DemoKeyListener(Character character) {
        this.character = character;

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyChar() == 'w'){
            character.setLinearVelocity(new Vec2(0, 10));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
