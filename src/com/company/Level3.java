package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 1 of the game
 */
public class Level3 extends GameLevel {
    Player player;
    private PlatformL3 platformL31;



    private static final int NUM_COINS = 5;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
//        Shape groundShape = new BoxShape (11, 0.5f);
//        Body ground = new StaticBody (this, groundShape);
//        ground.setPosition(new Vec2(0, -11.5f));

        for (float i=-10; i<=10;i=i+5){
            platformL31 = new PlatformL3 (this);
            platformL31.setPosition (new Vec2(i, -11.5f));

        }

        //platform
        platformL31 = new PlatformL3 (this);
        platformL31.setPosition (new Vec2(5, -6.5f));

        platformL31 = new PlatformL3 (this);
        platformL31.setPosition (new Vec2( -5.5f, -2f));

        //make coin
        Body coin = new Coin (this);
        coin.setPosition(new Vec2( -5.5f, -1f));
        coin.addCollisionListener(new PickUp(getPlayer()));

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-4f, -9.6f);
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
        ImageIcon icon = new ImageIcon ("data/background3.png");
        return icon;
    }




}

