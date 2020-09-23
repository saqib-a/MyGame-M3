/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this creates the general GameLevel that is shared by all the other levels
 */
public abstract class GameLevel extends World {
    private Goku goku;

    /**
     * returns the main character
     * @return
     */
    public Goku getPlayer() {
        return goku;
    }

    /**
     * populates each level with my portal and main character
     * @param game
     */
    public void populate(Game game) {
        goku = new Goku(this);
        goku.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));
    }

    /**
     * allows you to select the starting position of the main character
     * @return
     */
    public abstract Vec2 startPosition();

    /**
     * allows you to select the position of the portal
     * @return
     */
    public abstract Vec2 portalPosition();

    /**
     * determines if the level has been completed
     * @return
     */
    public abstract boolean isCompleted();
}