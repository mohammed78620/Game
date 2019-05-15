package com.company;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyView extends UserView {
    Player player1;
    static Image background;
    Image heart1;
    Image heart2;








    public MyView ( World world, Image background,Player player1, int width, int height ) {
        super (world, width, height);
        this.player1 = player1;
        MyView.background = background;




        heart1 = new ImageIcon ("data/heart.png").getImage ().getScaledInstance (30,30, Image.SCALE_DEFAULT);
        heart2 = new ImageIcon ("data/heart.png").getImage ().getScaledInstance (30,30, Image.SCALE_DEFAULT);





    }

    @Override
    protected void paintBackground ( Graphics2D g ) {

        g.drawImage (background, 0, 0, this);


    }

    @Override
    protected void paintForeground ( Graphics2D g ) {
        g.drawString ("Score " + player1.getCoinCounter (),5,50);
        g.drawString ("Health " + player1.getLiveCount (), 5,35 );

        List<Image> heart = new ArrayList <> ();
        heart.add (heart1);
        heart.add (heart2);

        for(int i =0 ; i<2; i++) {
            g.drawImage (heart.get (i),i*23,50,this);
        }

//        g.drawImage (heart1, 100, 100, this);
//        g.drawImage (heart2, 150, 100, this);



        if(player1.getLiveCount () == 1) {
            heart1.flush ();
        }else if(player1.getLiveCount () == 0){
            heart1.flush ();
            heart2.flush ();

        }




    }


}
