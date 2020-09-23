package game;

import city.cs.engine.*;

/**
 * this class allows my main character to pick up and collide with objects
 */
public class Pickup implements CollisionListener {
    private Goku goku;
    
    /**
     * initialises the pickup of the character
     * @param MainCharacter
     */
    public Pickup(Goku MainCharacter) {
        this.goku = MainCharacter;
    }

    /**
     * allows all the collisions to take place s
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == goku) {
            if(e.getReportingBody() instanceof DragonBall) {
                goku.incrementDragonBallCount();
                e.getReportingBody().destroy();  
            }
            if(e.getReportingBody() instanceof Saibaman) {
                goku.decrecreaseLifeCount();
                e.getReportingBody().destroy();
            }
            if(e.getReportingBody() instanceof CellJr) {
                goku.decrecreaseLifeCount();
                e.getReportingBody().destroy();
            }
            if(e.getReportingBody() instanceof Buu) {
                goku.decrecreaseLifeCount();
            }
            if(e.getReportingBody() instanceof SenzuBean) {
                goku.increaseLifeCount();
                e.getReportingBody().destroy();
            }
        }
    }
    
}
