package com.company;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World  {
    /** the player that is in the world*/
    private Player player;






    /**
     * Populate the world of this level.

     * Child classes should this method with additional bodies.
     * @param game the game,the main entry point into the program
     */
    public void populate(Game game) {

        player = new Player (this);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));








    }
    /**
     * methods that returns the player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }


    /** The initial position of the player.
     * @return startPosition
     *  */
    public abstract Vec2 startPosition();

    /** The position of the exit door.
     *
     * @return doorPosition
     */
    public abstract Vec2 doorPosition();

    /**
     * Is this level complete?
     * @return isCompleted
     */
    public abstract boolean isCompleted();

    /**
     * It gets the background of the level
     * @return getBackground
     */
    public abstract ImageIcon getBackground();





}

