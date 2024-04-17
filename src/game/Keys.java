package game;

import city.cs.engine.*;

public class Keys extends StaticBody {

    private static final Shape booksShape = new CircleShape(1);

    private static final BodyImage image = new BodyImage("data/key.gif", 2f);

    public Keys(World w) {
        super(w,booksShape);
        addImage(image);

    }
}
