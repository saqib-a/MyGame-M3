/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * this detects when the enemy is hit by the main characters shot
 */
public class CellJrHit implements CollisionListener{
    
    private CellJr cj;
    
    /**
     * initialises enemy being hit
     * @param cj
     */
    public CellJrHit(CellJr cj){
        this.cj = cj;
    }

    /**
     * detects collision with shot and destroys both the shot and the enemy
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
       if(e.getOtherBody() instanceof Shoot){
           if(e.getReportingBody() instanceof CellJr){
               e.getReportingBody().destroy();
               e.getOtherBody().destroy();
           }
        }
    }
    
}
