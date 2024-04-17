// Character class
package game;

import city.cs.engine.*;

public class Character extends Walker {
    private final static BoxShape studentShape = new BoxShape(0.5F, 2);
    private final BodyImage studentImage = new BodyImage("data/unclegrandpa1.png" , 4);
    private boolean touchedPortal;

    private int keysCount;

    public Character(World world){
        super(world, studentShape);
        addImage(studentImage);

        keysCount = 0;
    }

    public boolean hasTouchedPortal() {
        return touchedPortal;
    }

    public void setTouchedPortal(boolean touchedPortal) {
        this.touchedPortal = touchedPortal;
    }

    public void addKeys(){
        keysCount++;
        System.out.println("I'm coming gate: " +
                "keysCount = " + keysCount);
    }
    public int getKeysCount(){
        return keysCount;
    }
}
