/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.jbox2d.common.Vec2;
import city.cs.engine.*;

/**
 * this class is for the bullet of my enemy boss
 */
public class BuuShot extends DynamicBody{
    
    private static final Shape shape = new PolygonShape(0.982f,-0.023f, 0.538f,0.663f, -1.252f,-0.033f, 0.522f,-0.7f, 0.972f,-0.063f);
    private static final BodyImage image = new BodyImage("data/KiRight.gif", 2.0f);
    private static final BodyImage image2 = new BodyImage("data/KiLeft.gif", 2.0f);
    
    /**
     * intialises the shooting of the boss
     * @param world
     * @param boss
     */
    public BuuShot(World world, Buu boss) {
        super(world, shape);
        addImage(image);
        this.setGravityScale(0.0f);
        this.setLinearVelocity(new Vec2(boss.direction * 15f, 0));
        this.addCollisionListener(new BuuShotHit(this));
    }
    
    /**
     * returns image for shooting left
     * @return
     */
    public BodyImage getLeftAttack(){
        this.removeAllImages();
        return image2;
    }
    
    /**
     * returns image for shooting right
     * @return
     */
    public BodyImage getRightAttack(){
        this.removeAllImages();
        return image;
    }
    
    
}
