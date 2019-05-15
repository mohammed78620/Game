package com.company;

import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {
    private Enemy enemy;
    private Player player;
    private Barrel barrel;
    private PlatformL1 platformL11;


    private int NUM_PLATFORMS = 11;







    private static final int NUM_COINS = 3;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);




        //make ground
//        Shape groundShape = new BoxShape(15, 0.5f);
//        Body ground = new StaticBody(this, groundShape);
//        ground.setPosition(new Vec2(0, -11.5f));


        //make platform
//        Shape groundShape1 = new BoxShape(11, 0.5f);
//        Body ground1 = new StaticBody(this, groundShape1);
//        ground1.setPosition(new Vec2(15, ));
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(5f, -6));
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(10f, -6));

        //make platform
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(-10f, -4));
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(-5f, -4));

//        Shape groundShape2 = new BoxShape(13, 0.5f);
//        Body ground2 = new StaticBody(this, groundShape2);
//        ground2.setPosition(new Vec2(-15, -4));

        //make platform
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(0, 1));
        platformL11 = new PlatformL1 (this);
        platformL11.setPosition (new Vec2(5f, 1));

//        Shape groundShape3 = new BoxShape(6, 0.5f);
//        Body ground3 = new StaticBody(this, groundShape3);
//        ground3.setPosition(new Vec2(4, 1));

        //make L1Platform
        for (float i=-10; i<=10;i=i+5){
            platformL11 = new PlatformL1 (this);
            platformL11.setPosition (new Vec2(i, -11.5f));


        }

        //make coin
        Body coin = new Coin(this);
        coin.setPosition(new Vec2(10, -5));
        coin.addCollisionListener(new PickUp (getPlayer ()));

        //make coin
        Body coin1 = new Coin(this);
        coin1.setPosition(new Vec2(0, 2));
        coin1.addCollisionListener(new PickUp (getPlayer ()));

        //make coin
        Body coin2 = new Coin(this);
        coin2.setPosition(new Vec2(-10, -3));
        coin2.addCollisionListener(new PickUp (getPlayer ()));


        //make enemy
        enemy = new Enemy (this);
        enemy.setPosition (new Vec2 (-5,-10));
        enemy.addCollisionListener (new PickUp (getPlayer ()));

        //get Barrel
        barrel = new Barrel (this);
        barrel.setPosition (new Vec2 (3,2.5f));
        barrel.addCollisionListener (new PickUp (getPlayer ()));






    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
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
    public ImageIcon getBackground(){
        ImageIcon icon = new ImageIcon ("data/background.png");
        return icon;
    }




}

