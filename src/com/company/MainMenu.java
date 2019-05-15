package com.company;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu  implements ActionListener {
    private JPanel mainPanel2;
    private JButton startGameButton;
    private JButton usernameButton;
    private JTextPane textPane2;
    private JButton instructionButton;
    private JRadioButton summerRadioButton;
    private JRadioButton nightRadioButton;
    private JRadioButton springRadioButton;
    private JRadioButton highVolumeRadioButton;
    private JRadioButton mediumVolumeRadioButton;
    private JRadioButton lowVolumeRadioButton;
    private Game game;
    JTextPane textPane;
    public JFrame frame2;
    MainMenu menu;
    JRadioButton summer;
    JRadioButton night;
    JRadioButton spring;
    String str;

    public SoundClip gameMusic;



    public MainMenu () {
        try{
            gameMusic = new SoundClip ("data/gameMusic.wav");
            gameMusic.loop ();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println (e);
        }


        frame2 = new JFrame ("Main menu");

        frame2.add (mainPanel2);

        frame2.setSize (500,500);
        frame2.setVisible (true);

        startGameButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                frame2.setVisible (false);
                new Game ();


            }
        });
        usernameButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                str = JOptionPane.showInputDialog(null, "Enter some text : ",
                        "username", 1);
                textPane2.setText (str);;
                if(str != null)
                    JOptionPane.showMessageDialog(null, "You entered the text : " + str,
                            "username", 1);
                else
                    JOptionPane.showMessageDialog(null, "You pressed cancel button.",
                            "username", 1);
            }
        });
        ButtonGroup group = new ButtonGroup ();
        group.add (summerRadioButton);
        group.add (nightRadioButton);
        group.add (springRadioButton);

        summerRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                mainPanel2.setBackground (Color.YELLOW);
            }
        });
        springRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                mainPanel2.setBackground (Color.GREEN);
            }
        });
        nightRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                mainPanel2.setBackground (Color.BLUE);
            }
        });



        instructionButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                JPanel panel1 = new JPanel ();
                textPane = new JTextPane ();
                textPane.setText ("a-left , d-right, w-up , q-quit , avoid the cat and dog at all costs ");
                panel1.add (textPane);
                JOptionPane.showMessageDialog (null,panel1);
            }
        });

        ButtonGroup group2 = new ButtonGroup();
        group.add (highVolumeRadioButton);
        group.add (mediumVolumeRadioButton);
        group.add (lowVolumeRadioButton);
        highVolumeRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                gameMusic.setVolume (2d);
            }
        });
        mediumVolumeRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                gameMusic.setVolume (0.2d);
            }
        });
        lowVolumeRadioButton.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                gameMusic.setVolume (0.02d);
            }
        });



    }
    public JFrame getFrame2(){
        return frame2;
    }



    public JPanel getMainPanel2 () {
        return mainPanel2;

    }
    public  static void main (String [] args){
        MainMenu mainMenu = new MainMenu ();

    }

    @Override
    public void actionPerformed ( ActionEvent e ) {

    }
}
