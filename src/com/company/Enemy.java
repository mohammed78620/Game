package com.company;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Enemy extends Walker   {
    private static final Shape shape = new PolygonShape (
            -0.828f,1.0f, 0.708f,1.0f, 0.708f,-0.996f, -0.868f,-0.996f);
    private static SoundClip catSound;

    private static final BodyImage image =
            new BodyImage("data/cat.png", 2f);

    static {
        try {
            catSound = new SoundClip ("data/catScream.wav");
            System.out.println ("Loading cat sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println (e);
        }
    }

    public Enemy( World world ){
        super(world, shape);
        addImage (image);

    }
    public void catPlaySound(){
        catSound.play ();
    }
}
