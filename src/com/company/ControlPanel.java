package com.company;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel extends Container implements ActionListener {

    private JButton quitButton;
    private JButton pauseButton;
    private JButton restartButton;
    private JPanel mainPanel;
    private JButton startButton;
    private JButton moveLevel2Button;
    private JButton moveToLevel1Button;
    private JButton moveToLevel3Button;
    private JButton saveButton;
    private JButton loadButton;
    private JButton hintButton;



    Game game;
    Player player;
    GameLevel gameLevel;



    public ControlPanel (Game game) {
        this.game = game;



        //quit game
        quitButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                System.exit (0);
            }
        });
        //pause game
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();

            }
        });
        //start game
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });
        // restart game
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                game.restart();
            }
        });
        // go to level1
        moveToLevel1Button.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                game.goLevel1 ();
            }
        });
        // go to level2
        moveLevel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goLevel2();
            }
        });
        moveToLevel3Button.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                game.goLevel3 ();
            }
        });
        saveButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String str = Integer.toString (game.getPlayerLevel ());
                int score = game.getPlayer ().getCoinCounter ();
                String pos = game.getPlayerPosition ();
                int health = game.getPlayer().getLiveCount ();
                try{
                    SaveGame writer = new SaveGame ("data/save.txt");
                    writer.writeLevel (str,score,pos,health);
                }
                catch (IOException e1){
                    e1.printStackTrace ();
                }

            }
        });
        hintButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                JPanel panel2 = new JPanel ();
                JTextPane instructions = new JTextPane ();
                instructions.setText ("Throw the barrel at the cat to destroy him");


                panel2.add(instructions);


                JOptionPane.showMessageDialog(null, panel2);
            }
        });
        loadButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                try{

                    LoadGame reader = new LoadGame ("data/save.txt");
                    reader.readLevel ();
                    if(reader.getLevel () == 1){
                        game.goLevel1 ();
                        game.getPlayer ().setCoinCounter (reader.getScore ());
                        game.getPlayer ().setPosition (new Vec2 (reader.getFirstValue (),reader.getSecondValue ()));
                        game.getPlayer ().setLiveCount (reader.getHealth ());
                    }else if(reader.getLevel () == 2){
                        game.goLevel2 ();
                        game.getPlayer ().setCoinCounter (reader.getScore ());
                        game.getPlayer ().setPosition (new Vec2 (reader.getFirstValue (),reader.getSecondValue ()));
                        game.getPlayer ().setLiveCount (reader.getHealth ());
                    }else if(reader.getLevel () == 3){
                        game.goLevel3 ();
                        game.getPlayer ().setCoinCounter (reader.getScore ());
                        game.getPlayer ().setPosition (new Vec2 (reader.getFirstValue (),reader.getSecondValue ()));
                        game.getPlayer ().setLiveCount (reader.getHealth ());
                    }


                }
                catch (IOException e2){
                    e2.printStackTrace ();
                }

            }
        });



    }


    public JPanel getMainPanel () {
        return mainPanel;

    }



    @Override
    public void actionPerformed ( ActionEvent e ) {


    }
}




