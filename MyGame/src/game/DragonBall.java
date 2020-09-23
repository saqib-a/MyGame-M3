package game;

import city.cs.engine.*;

//making collectible item

/**
 * collectible object class that extends dynamic body
 */
public class DragonBall extends DynamicBody {

    /**
     * creating the collectible objects 
     * @param world
     */
    public DragonBall(World world) {
        super(world);
        this.addCollisionListener(new DragonBallHit(this));
        
        Shape DragonBallShape = new PolygonShape(-0.114f,0.711f, -0.636f,0.306f,
                -0.656f,-0.281f, -0.045f,-0.662f, 0.696f,-0.197f, 0.623f,0.326f,
                0.356f,0.6f, -0.049f,0.698f);
        Fixture fixture = new SolidFixture(this, DragonBallShape);
        addImage(new BodyImage("data/DragonBall.png",1.5f));
        
        
    }
}
    

