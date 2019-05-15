package com.company;

import city.cs.engine.*;


public class Player extends Walker {


    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    /** the shape of the player is defined here*/
    private static final Shape shape = new PolygonShape(
            -0.36f,1.43f, -0.73f,0.71f, -0.73f,-0.4f, -0.36f,-1.48f, 0.37f,-1.48f, 0.72f,-0.38f, 0.72f,0.7f, 0.41f,1.42f);
    /** the image of the player is defined here*/
    private static final BodyImage image =
            new BodyImage("data/player.png", 3f);
    /** the the number of coins the player collect is stored here*/
    private int coinCounter;
    /** the the number of lives the player collect is stored here*/
    private int liveCount;

//    private  World world;


    /**
     * this method defines the players attributes
     * @param world takes in parameter that allows player to exist in world
     */
    public Player(World world) {
        super(world, shape);
        addImage(image);
        coinCounter = 0;
        liveCount = 2;


    }
    /**
     * returns the field coinCounter
     * @return coinCounter
     */
    public int getCoinCounter(){
        return coinCounter;
    }
    /**
     * sets a new value
     * returns the field coinCounter
     * @param coinCounter is set
     */
    public void setCoinCounter(int coinCounter){
        this.coinCounter = coinCounter;
    }

    /**
     * method increments coinCounter
     */
    public void increaseCoinCounter(){
        coinCounter++;
        System.out.println ("The number of coins collected is " + getCoinCounter ());
    }
    /**
     * returns the field liveCount
     * @return liveCount
     */
    public int getLiveCount(){
        return liveCount;
    }
    /**
     * changes the field
     * @param liveCount is set
     */
    public void setLiveCount(int liveCount){
        this.liveCount = liveCount;
    }
    /**
     * decrements liveCount field
     */
    public void decrementLiveCount(){
        liveCount--;
        System.out.println ("The number of lives " + getLiveCount ());
    }











}
