package com.company;

import city.cs.engine.*;

public class PlatformL3 extends StaticBody {
    private static final Shape shape = new PolygonShape (-4.196f,0.556f, 4.196f,0.573f, 4.196f,-0.653f, -4.196f,-0.636f);

    private static final BodyImage image = new BodyImage("data/platformLevel3.png",2f);

    public PlatformL3( World world ){
        super(world,shape);
        addImage (image);
    }
}
