/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * this is for the collision for the shooting of the boss
 */
public class BuuShotHit implements CollisionListener{
    
    private BuuShot shot;
    
    /**
     * initialises the shot
     * @param shot
     */
    public BuuShotHit(BuuShot shot){
        this.shot = shot;
    }

    /**
     * detects collisions with shots
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof StaticBody){
            if(e.getReportingBody() instanceof BuuShot){
                e.getReportingBody().destroy();
            }
        
        }
    }
    
}
