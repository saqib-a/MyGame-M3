/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

//making enemies

/**
 * making enemy that extends walker
 */
public class Saibaman extends Walker {
    
    private static final Shape shape = new PolygonShape(-0.22f,1.49f, -1.12f,
            -0.36f, -1.0f,-1.29f, -0.68f,-1.43f, 1.09f,-1.02f, 0.36f,1.49f);
    
    private static final BodyImage SaibamanRight = new BodyImage("data/Saibaman.png", 3);
    //private static final BodyImage SaibamanLeft = new BodyImage("data/Saibaman.png", 3.0f);
    
    /**
     * initialises the enemy
     * @param world
     */
    public Saibaman(World world) {
        super(world, shape);
        addImage(SaibamanRight);
        this.addCollisionListener(new SaibamanHit(this));
    }
    
    /**
     * returns image of enemy to the right
     * @return
     */
    public BodyImage getSaibamanRight(){
    this.removeAllImages();
    return SaibamanRight;
    }
    
    /*public BodyImage getSaibamanLeft(){
    this.removeAllImages();
    return SaibamanLeft;
    } */
    
    
    
    
}

