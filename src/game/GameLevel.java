// GameLevel class
package game;

public abstract class GameLevel extends GameWorld {
    private Character character;
    private Enemies enemies;
    private FlyingEnemy enemy;

    public GameLevel(){
        character = new Character(this);
        enemies = new Enemies(this);
        enemy = new FlyingEnemy(this);
    }

    public Character getCharacter(){
        return character;
    }

    public Enemies getEnemies(){
        return enemies;
    }

    public FlyingEnemy getEnemy(){
        return enemy;
    }

    public abstract boolean isComplete();
}
