/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * this class detects collisions with my portal extends CollisionListener
 */
public class PortalListener implements CollisionListener {
    private Game game;
    
    /**
     * intitialises the portal CollisionListener
     * @param game
     */
    public PortalListener(Game game) {
        this.game = game;
    }

    /**
     * creates the collision event
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Goku goku = game.getPlayer();
        if (e.getOtherBody() == goku && game.isCurrentLevelCompleted()) {
            System.out.println("Well Done!!! Level Completed");
            game.goNextLevel();
        }
    }
}
