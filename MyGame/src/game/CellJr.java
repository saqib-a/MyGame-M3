package game;

import city.cs.engine.*;

//making enemies

/**
 * making enemy that extends walker
 */
public class CellJr extends Walker {
    
    private static final Shape shape = new PolygonShape(-0.18f,0.89f, 0.36f,
            0.88f, 0.75f,-0.01f, 0.52f,-0.8f, -0.56f,-0.84f, -0.8f,-0.26f,
            -0.22f,0.83f);
    
    private static final BodyImage CellJrRight = new BodyImage("data/CellJrRight.png", 3.0f);
    private static final BodyImage CellJrLeft = new BodyImage("data/CellJrLeft.png", 3.0f);
    
    /**
     * initialises the enemy
     * @param world
     */
    public CellJr(World world) {
        super(world, shape);
        addImage(CellJrRight);
        this.addCollisionListener(new CellJrHit(this));
    }
    
    /**
     * returns image of enemy to the right
     * @return
     */
    public BodyImage getCellJrRight(){
    this.removeAllImages();
    return CellJrRight;
    }
    
    /**
     * returns image of enemy to the left
     * @return
     */
    public BodyImage getCellJrLeft(){
    this.removeAllImages();
    return CellJrLeft;
    }   
}
