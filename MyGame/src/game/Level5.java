/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this is my Level5 that extends the abstract GameLevel
 */

public class Level5 extends GameLevel {
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
        Shape boxShape = new BoxShape(6, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(0, -5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(-16, 1));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(16, 1));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(0, 7.5f));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-16, 14));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(16, 14));
        Body platform7 = new StaticBody(this, boxShape);
        platform7.setPosition(new Vec2(0, 20.5f));
        
        //make enemies 
        CellJr enemy1 = new CellJr(this);
        enemy1.setPosition(new Vec2(4, 22f));
        enemy1.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy2 = new CellJr(this);
        enemy2.setPosition(new Vec2(-4f, 22f));
        enemy2.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy3 = new CellJr(this);
        enemy3.setPosition(new Vec2(-15f, 2));
        enemy3.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy4 = new CellJr(this);
        enemy4.setPosition(new Vec2(15f, 2f));
        enemy4.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy5 = new CellJr(this);
        enemy5.setPosition(new Vec2(-15, 15));
        enemy5.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy6 = new CellJr(this);
        enemy6.setPosition(new Vec2(15, 15));
        enemy6.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy7 = new CellJr(this);
        enemy7.setPosition(new Vec2(3, -4));
        enemy7.addCollisionListener(new Pickup(getPlayer()));
        
        CellJr enemy8 = new CellJr(this);
        enemy8.setPosition(new Vec2(-3, -4));
        enemy8.addCollisionListener(new Pickup(getPlayer()));

        
        Buu boss = new Buu(this, game);
        boss.setPosition(new Vec2(0, 10));
        boss.addCollisionListener(new Pickup(getPlayer()));
        
        //make senzu bean for health up
        SenzuBean senzubean = new SenzuBean(this);
        senzubean.setPosition(new Vec2(12,17));
        senzubean.addCollisionListener(new Pickup(getPlayer()));
      
        //making collectible Dragon Balls
        DragonBall dragonball1 = new DragonBall(this);
        dragonball1.setPosition(new Vec2(1.5f, 22f));
        dragonball1.addCollisionListener(new Pickup(getPlayer()));
        
        DragonBall dragonball2 = new DragonBall(this);
        dragonball2.setPosition(new Vec2(-1.5f, 22));
        dragonball2.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball3 = new DragonBall(this);
        dragonball3.setPosition(new Vec2(-18, 2));
        dragonball3.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball4 = new DragonBall(this);
        dragonball4.setPosition(new Vec2(18, 2));
        dragonball4.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball5 = new DragonBall(this);
        dragonball5.setPosition(new Vec2(18, 17f));
        dragonball5.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball6 = new DragonBall(this);
        dragonball6.setPosition(new Vec2(-18, 17));
        dragonball6.addCollisionListener(new Pickup(getPlayer()));

        DragonBall dragonball7 = new DragonBall(this);
        dragonball7.setPosition(new Vec2(0, -4));
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

