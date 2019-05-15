package com.company;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Enemy2 extends Walker   {
    private static final Shape shape = new PolygonShape (
            -0.394f,0.592f, -0.138f,0.852f, 0.07f,0.852f, 0.322f,0.6f, 0.398f,-0.636f, -0.478f,-0.632f);

    private static final BodyImage image =
            new BodyImage("data/dog.png", 2.5f);
    private static SoundClip dogSound;
    static {
        try {
            dogSound = new SoundClip ("data/dogBark.wav");
            System.out.println ("Loading cat sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println (e);
        }
    }
    public Enemy2( World world ){
        super(world, shape);
        addImage (image);

    }
    public void dogplaySound(){
        dogSound.play ();
    }

}
