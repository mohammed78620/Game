package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 2 of the game
 */
public class Level4 extends GameLevel {
    private Player player;

    private static final int NUM_COINS= 4;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make some platforms
//        Shape platformShape = new BoxShape(4, 0.5f);
//        Body platform1 = new StaticBody(this, platformShape);
//        platform1.setPosition(new Vec2(-7, 5.5f));
//        Body platform2 = new StaticBody(this, platformShape);
//        platform2.setPosition(new Vec2(5, -2.5f));


        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coin (this);
            coin.setPosition(new Vec2(i * 2 , 10));
            coin.addCollisionListener(new PickUp(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -5);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCounter () == NUM_COINS;
    }

    @Override
    public ImageIcon getBackground () {
        ImageIcon icon = new ImageIcon ("data/background2.png");
        return icon;
    }




}