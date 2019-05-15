package com.company;

import city.cs.engine.*;

public class PlatformL1 extends StaticBody {
    private static final Shape shape = new PolygonShape (-2.16f,0.61f, 2.55f,0.61f, 2.55f,-0.56f, -2.1f,-0.56f);

    private static final BodyImage image = new BodyImage("data/platformlevel1.png",6);

    public PlatformL1( World world ){
        super(world,shape);
        addImage (image);
    }
}
