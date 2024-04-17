package game;

import city.cs.engine.*;

public class Portal extends StaticBody {

    private static final Shape portalShape = new PolygonShape(
            1.84f,1.99f, 1.96f,-0.3f, 1.5f,-2.36f,
            -0.47f,-2.33f, -1.98f,1.69f, 0.5f,2.46f);

    private static final BodyImage image =
            new BodyImage("data/nportal.png", 5f);


    public Portal(World world) {
        super(world, portalShape);
        addImage(image);
    }
}
