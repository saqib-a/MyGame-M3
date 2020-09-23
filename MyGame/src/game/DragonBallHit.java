/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * class for detecting if the dragon ball is hit by the characters shot 
 */
public class DragonBallHit implements CollisionListener {
    private DragonBall dragonball;
    
    /**
     *initalises the dragon ball
     * @param dragonball
     */
    public DragonBallHit(DragonBall dragonball){
        this.dragonball = dragonball;
    }
    
    /**
     * detects the collision and destroys the shot
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
       if(e.getOtherBody() instanceof Shoot){
           if(e.getReportingBody() instanceof DragonBall){
               e.getOtherBody().destroy();
           }
        }
    }
    
}

