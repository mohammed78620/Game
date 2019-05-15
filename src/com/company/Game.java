package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    /** A value that represent the level the character is in */
    private  int level;


    /** A variable that controls the movement of the player */
    private  Controller controller;



    public int i = 0;






    /** Initialise a new Game. */
    public Game() {



        // make the world
        i =1;
        level= 1;
        world = new Level1();
        world.populate (this );

        view = new MyView (world, world.getBackground().getImage (),world.getPlayer (),500, 500);






//         view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Game");




        Container buttons = new ControlPanel(this);
        frame.add(((ControlPanel) buttons).getMainPanel (),BorderLayout.WEST);




        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        frame.requestFocus ();
        view.addMouseListener (new GiveFocus (frame));

        controller = new Controller (world.getPlayer ());
        frame.addKeyListener(controller);

        // start!
        world.start();

        level=level + 1;
    }
    /**
     * the methods return the player from the current world
     * @return world.getPlayer
     */
    public Player getPlayer() {
        return world.getPlayer();
    }
    /**
     * the method converts player position into string and returns it
     * @return pos.
     */
    public String getPlayerPosition(){
        String pos = getPlayer ().getPosition ().toString ();

        return pos;
    }








    /**
     * Short description.
     * the methods returns the world
     * @return world.
     */
    public GameLevel getWorld(){
        return world;
    }

    /** Is the current level of the game finished?
     *
     * @return world.isCompleted
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }


    /** Method that pauses the game */
    public void pause(){
        world.stop();
    }
    /** Method that Starts the game */
    public void start(){
        world.start();
    }
    /** Method that restarts the game */
    public void restart(){
        world = new Level1 ( );


        // fill it with bodies
        world.populate (this);

        MyView.background = world.getBackground ( ).getImage ( );
        // switch the keyboard control to the new player
        controller.setBody (world.getPlayer ( ));
        view.player1 = world.getPlayer ( );



        // show the new world in the view
        view.setWorld (world);

        world.start ( );

    }
    /**
     * methods that goes to Level 1
     */
    public void goLevel1(){
        world = new Level1 ( );


        // fill it with bodies
        world.populate (this);

        MyView.background = world.getBackground ( ).getImage ( );
        // switch the keyboard control to the new player
        controller.setBody (world.getPlayer ( ));
        view.player1 = world.getPlayer ( );

        // show the new world in the view
        view.setWorld (world);

        world.start ( );
    }
    /**
     * methods that goes to Level 2
     */
    public void goLevel2(){
        world = new Level2 ( );

        // fill it with bodies
        world.populate (this);

        MyView.background = world.getBackground ( ).getImage ( );
        // switch the keyboard control to the new player
        controller.setBody (world.getPlayer ( ));
        view.player1 = world.getPlayer ( );

        // show the new world in the view
        view.setWorld (world);

        world.start ( );
    }
    /**
     * methods that goes to Level 3
     */
    public void goLevel3(){
        world = new Level3 ( );


        // fill it with bodies
        world.populate (this);

        MyView.background = world.getBackground ( ).getImage ( );
        // switch the keyboard control to the new player
        controller.setBody (world.getPlayer ( ));
        view.player1 = world.getPlayer ( );

        // show the new world in the view
        view.setWorld (world);

        world.start ( );
    }


    /**
     * methods that returns the player level
     * @return i
     */
    public int getPlayerLevel(){
        return i;

    }






    /** Advance to the next level of the game. */
    public void goNextLevel() {

        world.stop ( );
//        try{
//            String str = Integer.toString (getPlayer ().getCoinCounter ());
//            SaveGame writer = new SaveGame ("data/save.txt");
//            writer.writeHighScore (str);
//
//        }
//        catch (IOException e){
//            e.printStackTrace ();
//
//        }

        Player oldMain = world.getPlayer ( );

        if (level == 4) {
            System.exit (0);

        } else if (level == 2) {

            i= 2;

            level++;


            // get a new world
            world = new Level2 ( );



            // fill it with bodies
            world.populate (this);


            MyView.background = world.getBackground ( ).getImage ( );
            // switch the keyboard control to the new player
            controller.setBody (world.getPlayer ( ));
            view.player1 = world.getPlayer ( );
            world.getPlayer ( ).setCoinCounter (oldMain.getCoinCounter ( ));
            world.getPlayer ( ).setLiveCount (oldMain.getLiveCount ( ));


            // show the new world in the view
            view.setWorld (world);

            world.start ( );


        } else if (level == 3) {
            i=3;
            level++;


            System.out.print (level);

            // get a new world
            world = new Level3 ( );

            // fill it with bodies
            world.populate (this);

            MyView.background = world.getBackground ( ).getImage ( );

            // switch the keyboard control to the new player
            controller.setBody (world.getPlayer ( ));
            view.player1 = world.getPlayer ( );
            world.getPlayer ( ).setCoinCounter (oldMain.getCoinCounter ( ));
            world.getPlayer ( ).setLiveCount (oldMain.getLiveCount ( ));


            // show the new world in the view
            view.setWorld (world);


            world.start ( );

        }

    }


    /** Run the game.
     * @param args start the game
     */
    public static void main(String[] args) {
        new Game();



    }
}