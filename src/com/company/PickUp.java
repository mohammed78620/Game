package com.company;

import city.cs.engine.*;


public class PickUp implements CollisionListener {
    private Player player;
    private World world;






    public PickUp(Player player) {
        this.player = player;


    }

    @Override
    public void collide(CollisionEvent e)

    {
        if (e.getReportingBody () instanceof Coin && e.getOtherBody () == player)
        { //creates pickup as coin
            player.increaseCoinCounter ();
            e.getReportingBody().destroy();
            ((Coin) e.getReportingBody ()).playSound ();




        }else if((e.getReportingBody () instanceof Enemy || e.getReportingBody () instanceof Enemy2 ) && e.getOtherBody () == player)
        { //creates pickup for enemy
            e.getReportingBody ().destroy ();

            player.decrementLiveCount ();
            if(player.getLiveCount () == 0){
                System.exit (0);
            }
            if (e.getReportingBody () instanceof Enemy && e.getOtherBody ()== player){
                ((Enemy) e.getReportingBody ()).catPlaySound ();
            }else if (e.getReportingBody () instanceof Enemy2 && e.getOtherBody ()== player){
                ((Enemy2) e.getReportingBody ()).dogplaySound ();
            }



        }else if(e.getReportingBody () instanceof Barrel && e.getOtherBody () instanceof Enemy){
            e.getOtherBody ().destroy ();
            System.out.println ("Enemy eliminated");

        }else if(e.getReportingBody () instanceof Sword && e.getOtherBody () == player ){
            System.out.println ("that's what you get for not moving!!");
            player.decrementLiveCount ();
            e.getReportingBody ().destroy ();
        }
    }



}