
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * this detects when the enemy is hit by the main characters shot
 */
public class SaibamanHit implements CollisionListener{
    
    private Saibaman saibaman;
    
    /**
     * initialises enemy being hit
     * @param saibaman
     */
    public SaibamanHit(Saibaman saibaman){
        this.saibaman = saibaman;
    
    }

    /**
     * detects collision with shot and destroys both the shot and the enemy
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Shoot){
            if(e.getReportingBody() instanceof Saibaman){
                e.getReportingBody().destroy();
                e.getOtherBody().destroy();
                
        }
    }
    }
}
