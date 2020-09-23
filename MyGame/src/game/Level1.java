/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 * this is my Level1 that extends the abstract GameLevel
 */
public class Level1 extends GameLevel {
    /**
     * this is the number of collectables that must be collected before moving on to the next level
     */
    private final static int DragonBall = 7;
 
    /**
     * this method fills my game with shapes and bodies
     * @param game
     */
    @Override
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
        
        //platforms
        Shape boxShape = new BoxShape(8, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-16, -5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(16, -5.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(0, 1));
        
        
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
        dragonball5.setPosition(new Vec2(-15, -2));
        dragonball5.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball6 = new DragonBall(this);
        dragonball6.setPosition(new Vec2(-20, -8.75f));
        dragonball6.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball7 = new DragonBall(this);
        dragonball7.setPosition(new Vec2(20, -8.75f));
        dragonball7.addCollisionListener(new Pickup(getPlayer()));

    }
    
    /**
     * this is the starting position of my main character
     * @return 
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }
    /**
     * this is the starting position of my portal
     * @return 
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(16, -10.7f);
    }
    /**
     * this makes sure that the dragon balls have been collected before allowing you to proceed to the next level
     * @return 
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getDragonBallCount() == DragonBall;
            
                
           
    }
}
