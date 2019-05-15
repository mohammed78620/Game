package com.company;

import city.cs.engine.*;

public class Sword extends DynamicBody {


    public Sword( World world ){
        super(world);
        Shape headShape = new PolygonShape(0.0f,2.14f, -0.32f,1.48f, -0.32f,-0.82f, 0.32f,-0.83f, 0.3f,1.47f);
        SolidFixture headFixture = new SolidFixture(this, headShape, 20);
        Shape handleShape = new PolygonShape(-0.7f,-0.83f, 0.67f,-0.83f, 0.67f,-1.11f, -0.68f,-1.11f);
        SolidFixture handleFixture = new SolidFixture(this, handleShape, 1);
        Shape hand = new PolygonShape(-0.15f,-1.1f, -0.22f,-1.77f, -0.21f,-1.93f, 0.0f,-2.11f, 0.21f,-1.94f, 0.22f,-1.77f, 0.13f,-1.11f);
        SolidFixture handFixture = new SolidFixture(this, hand, 1);
        addImage(new BodyImage ("data/sword.png", 5f));

    }




//    public Sword(World world) {
//        super(world);
//
//        Shape headShape = new PolygonShape(-0.85f,2.48f, 0.84f,2.5f, 0.83f,1.84f, -0.85f,1.87f);
//        SolidFixture headFixture = new SolidFixture(this, headShape, 20);
//        Shape handleShape = new PolygonShape(0.26f,1.83f, 0.22f,-2.5f, -0.26f,-2.47f, -0.22f,1.87f);
//        SolidFixture handleFixture = new SolidFixture(this, handleShape, 1);
//        addImage(new BodyImage ("data/sword.png", 5.0f));
//    }
}