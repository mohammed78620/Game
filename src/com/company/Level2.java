package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {
    Player player;
    Enemy2 enemy2;
    Sword sword;
    private PlatformL2 platformL2;



    private static final int NUM_COINS= 4;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground

        for (float i=-10; i<=10;i=i+5){
            platformL2 = new PlatformL2 (this);
            platformL2.setPosition (new Vec2(i, -11.5f));


        }



        // make enemy
        enemy2 = new Enemy2 (this);
        enemy2.setPosition (new Vec2 (0,-10));
        enemy2.addCollisionListener (new PickUp (getPlayer ()));

        //make sword
        sword = new Sword (this);
        sword.setPosition (new Vec2 (10,6));
        sword.addCollisionListener (new PickUp (getPlayer ()));
        sword.setAngle (3.1415926536f );


        // make some platforms
        platformL2 = new PlatformL2 (this);
        platformL2.setPosition (new Vec2(5, -6.5f));
        platformL2 = new PlatformL2 (this);
        platformL2.setPosition (new Vec2(-7, -2.2f));
        platformL2 = new PlatformL2 (this);
        platformL2.setPosition (new Vec2(-2, -2.2f));










        //make Coin
        Body coin = new Coin (this);
        coin.setPosition(new Vec2( -8 , -10));
        coin.addCollisionListener(new PickUp(getPlayer()));



    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(10, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-6.4f, -0.6f);
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
