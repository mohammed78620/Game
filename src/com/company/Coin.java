package com.company;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Coin extends DynamicBody  {



    private static final Shape shape = new CircleShape(0.8f);
    private static SoundClip orangeSound;
    private Coin coin;

    static {
        try {
            orangeSound = new SoundClip("data/coinPickup.wav");
            System.out.println("Loading orange sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }



    }


    public Coin (World world) {
        super(world, shape);
        addImage (new BodyImage ("data/coin.png",2));


    }

    public void playSound(){
        orangeSound.play ();
    }
    public SoundClip getOrangeSound(){
        return orangeSound;
    }






}
