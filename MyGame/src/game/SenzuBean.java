package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

//making collectible for health up

/**
 * collectible object class that extends dynamic body
 */
public class SenzuBean extends DynamicBody {

    /**
     * creating the collectible object
     * @param world
     */
    public SenzuBean(World world) {
        super(world);
        
        Shape SenzuBeanShape = new PolygonShape(-0.55f,0.49f, -0.75f,0.12f,
                -0.52f,-0.45f, 0.15f,-0.79f, 0.6f,-0.6f, 0.7f,-0.16f, 0.05f,
                0.55f, -0.47f,0.57f);
        Fixture fixture = new SolidFixture(this, SenzuBeanShape);
        addImage(new BodyImage("data/SenzuBean.png",3.0f));
    }
}