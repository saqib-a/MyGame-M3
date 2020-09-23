package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


// making main character Goku

/**
 * class that creates the main character and extends walker
 */

public class Goku extends Walker {
World world;

    private static final Shape shape = new PolygonShape(-0.844f,-0.99f, 0.7f,
            -0.99f, 0.816f,0.458f, 0.467f,0.714f, -0.45f,0.169f);

    private static final BodyImage standRightImage =
        new BodyImage("data/GokuStanding.gif~c200.gif", 2.25f);

    private static final BodyImage standLeftImage =
        new BodyImage("data/StandLeft.gif", 2.25f);
    
    private static final BodyImage dashRightImage =
        new BodyImage("data/GokuDash.gif", 2.25f);
    
    private static final BodyImage dashLeftImage =
        new BodyImage("data/GokuDashLeft.gif", 2.25f);
    
    private int DragonBallCount;
    private int lifeCount;

    /**
     * the direction the character is facing
     */
    public int facing;
    
    /**
     * initialises the character
     * @param world
     */
    public Goku(World world) {
        super(world, shape);
        addImage(standRightImage);
        this.setGravityScale(1.5f);
        DragonBallCount = 0;
        lifeCount = 3;
        facing = 1;
        this.addCollisionListener(new GokuHit(this));
    }

    /**
     * returns the image of the character when standing still and facing right
     * @return
     */
    public BodyImage getStandRightImage() {
        this.removeAllImages();
        return standRightImage;
    }
        
    /**
     * returns the image of the character when standing still and facing left
     * @return
     */
    public BodyImage getStandLeftImage() {
    this.removeAllImages();
    return standLeftImage;
    }
    
    /**
     * returns the image of the character when moving right
     * @return
     */
    public BodyImage getDashRightImage() {
        this.removeAllImages();
        return dashRightImage;
    }

    /**
     * returns the image of the character when moving left
     * @return
     */
    public BodyImage getDashLeftImage() {
        this.removeAllImages();
        return dashLeftImage;
    }

    /**
     * returns the number of dragon balls collected
     * @return
     */
    public int getDragonBallCount() {
        return DragonBallCount;
    }
    
    /**
     * returns the number of lives remaining
     * @return
     */
    public int getLifeCount() {
        return lifeCount;
    }

    /**
     * increases the dragon ball count
     */
    public void incrementDragonBallCount() {
        DragonBallCount++;
        System.out.println("Dragon Ball Collected!!! = " + DragonBallCount);
    }
    
    /**
     * reduces number of lives when hit
     */
    public void decrecreaseLifeCount() {
        lifeCount --;
        System.out.println("You lost a life! Lives remaining = " + lifeCount);
        if(lifeCount == 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
    
    /**
     * increases life when life up collectable is collected
     */
    public void increaseLifeCount() {
        lifeCount ++;
        System.out.println("Life up!!! Lives remaining = " + lifeCount);
    }
    
    /**
     * shoots right
     */
    public void shootR(){
        Shoot shoot = new Shoot(this.getWorld(), this);
        shoot.setPosition(new Vec2(this.getPosition().x + 0.5f * this.facing, this.getPosition().y));
        shoot.getRightAttack();
        shoot.addImage(shoot.getRightAttack());
    }
    
    /**
     * shoots left
     */
    public void shootL(){
        Shoot shoot = new Shoot(this.getWorld(), this);
        shoot.setPosition(new Vec2(this.getPosition().x + 0.5f * this.facing, this.getPosition().y));
        shoot.getLeftAttack();
        shoot.addImage(shoot.getLeftAttack());
    }
    
    
}
    

