package com.company;

import city.cs.engine.*;

public class Barrel extends DynamicBody {


    private static final Shape shape = new PolygonShape (-0.622f,0.996f, -0.906f,0.444f, -0.906f,-0.42f, -0.622f,-0.992f, 0.626f,-0.992f, 0.906f,-0.436f, 0.906f,0.444f, 0.626f,0.992f);

    public Barrel ( World world) {
        super(world, shape);
        addImage (new BodyImage ("data/barrel.png",2));
    }
}
