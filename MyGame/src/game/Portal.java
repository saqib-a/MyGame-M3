/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;

/**
 * this class creates the portal for my game which allows players to advance to the next level, extends StaticBody
 */
public class Portal extends StaticBody{
    
    private static final Shape shape = new PolygonShape
    (-0.24f,1.035f, -0.714f,0.624f, -0.912f,-0.903f, -0.081f,-1.113f, 0.834f,
    -0.909f, 0.63f,0.621f, 0.177f,1.038f, -0.21f,1.038f);
    
    private static final BodyImage image = new BodyImage("data/portal.gif", 2.25f);

    /**
     * intialises the portal
     * @param w
     */
    public Portal(World w) {
        super(w, shape);
        addImage(image);
    }

    /**
     * returns the image of the portal
     * @return
     */
    public BodyImage getImage() {
        this.removeAllImages();
        return image;
}
    
}
