package game;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoKeyListener implements KeyListener {

    Character character;

    public DemoKeyListener(Character character) {
        this.character = character;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            character.jump(30);
        } else if (e.getKeyChar() == 'd') {
            character.startWalking(5);
        } else if (e.getKeyChar() == 'a') {
            character.startWalking(-5);
        }
    }

        @Override
        public void keyReleased (KeyEvent e){
            if (e.getKeyChar() == 'd') {
                character.stopWalking();
            }
            else if (e.getKeyChar() == 'a'){
                character.stopWalking();
            }
        }
    }

