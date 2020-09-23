/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * class for when the main character is hit by the boss bullet which implements CollisionListener
 */
public class GokuHit implements CollisionListener{
    
    private Goku goku;
    
    /**
     * returns character being hit
     * @param goku
     */
    public GokuHit(Goku goku){
        this.goku = goku;
    }

    /**
     * detects collision with boss shot. shot is destroyed and life count is decreased
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
       if(e.getOtherBody() instanceof BuuShot){
           if(e.getReportingBody() instanceof Goku){
               e.getOtherBody().destroy();
               goku.decrecreaseLifeCount();
           }
        }
    }
    
}