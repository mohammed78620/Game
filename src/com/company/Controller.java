package com.company;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 10;
    private static final float WALKING_SPEED = 5;

    private Walker body;

    public Controller(Walker body) {
        this.body = body;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // D = walk right
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }
    public void setBody(Walker body) {
        this.body = body;
    }

}