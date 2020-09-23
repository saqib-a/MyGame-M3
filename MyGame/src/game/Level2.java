/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this is my Level2 that extends the abstract GameLevel
 */

public class Level2 extends GameLevel {
    /**
     * this is the number of collectables that must be collected before moving on to the next level
     */
    private final static int DragonBall = 7;
    /**
     * this method fills my game with shapes and bodies
     * @param game
     */
    public void populate(Game game) {
        super.populate(game);
        // add extra bodies
        // make the ground
        Shape groundShape = new BoxShape(25, 0.47f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.25f));
        
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 32, new Vec2(-24.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 32, new Vec2(24.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
         Shape boxShape = new BoxShape(8, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-16, -5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(16, -5.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(0, 1));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-16, 7.5f));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(16, 7.5f));
        
        
        //make enemies 
        Saibaman enemy1 = new Saibaman(this);
        enemy1.setPosition(new Vec2(-5.0f, 4.5f));
        enemy1.addCollisionListener(new Pickup(getPlayer()));
        
        Saibaman enemy2 = new Saibaman(this);
        enemy2.setPosition(new Vec2(12.0f, -2));
        enemy2.addCollisionListener(new Pickup(getPlayer()));
        
        Saibaman enemy3 = new Saibaman(this);
        enemy3.setPosition(new Vec2(-15f, 11));
        enemy3.addCollisionListener(new Pickup(getPlayer()));
        
        Saibaman enemy4 = new Saibaman(this);
        enemy4.setPosition(new Vec2(5f, 4.5f));
        enemy4.addCollisionListener(new Pickup(getPlayer()));
        
        Saibaman enemy5 = new Saibaman(this);
        enemy5.setPosition(new Vec2(11, 11));
        enemy5.addCollisionListener(new Pickup(getPlayer()));
        
        Saibaman enemy6 = new Saibaman(this);
        enemy6.setPosition(new Vec2(-14, -2));
        enemy6.addCollisionListener(new Pickup(getPlayer()));
        
        
      
        //making collectible Dragon Balls
        DragonBall dragonball1 = new DragonBall(this);
        dragonball1.setPosition(new Vec2(-20, -2));
        dragonball1.addCollisionListener(new Pickup(getPlayer()));
        
        DragonBall dragonball2 = new DragonBall(this);
        dragonball2.setPosition(new Vec2(0, 4.5f));
        dragonball2.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball3 = new DragonBall(this);
        dragonball3.setPosition(new Vec2(20, -2));
        dragonball3.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball4 = new DragonBall(this);
        dragonball4.setPosition(new Vec2(15, -2));
        dragonball4.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball5 = new DragonBall(this);
        dragonball5.setPosition(new Vec2(-15, -8.75f));
        dragonball5.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball6 = new DragonBall(this);
        dragonball6.setPosition(new Vec2(-20, 11));
        dragonball6.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball7 = new DragonBall(this);
        dragonball7.setPosition(new Vec2(20, 11));
        dragonball7.addCollisionListener(new Pickup(getPlayer()));

     
    }
    /**
     * this is the starting position of my main character
     * @return 
     */
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }
    /**
     * this is the starting position of my portal
     * @return 
     */
    public Vec2 portalPosition() {
        return new Vec2(20, -10.7f);
    }
    /**
     * this makes sure that the dragon balls have been collected before allowing you to proceed to the next level
     * @return 
     */
    public boolean isCompleted() {
        return getPlayer().getDragonBallCount() == DragonBall;
    }
}
