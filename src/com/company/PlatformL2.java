package com.company;

import city.cs.engine.*;

public class PlatformL2 extends StaticBody {
    private static final Shape shape = new PolygonShape (-2.963f,0.588f, 2.644f,0.588f, 2.657f,-0.541f, -2.963f,-0.554f);

    private static final BodyImage image = new BodyImage("data/platformLevel2.png",2f);

    public PlatformL2( World world ){
        super(world,shape);
        addImage (image);
    }
}