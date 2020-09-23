/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.Walker;
import city.cs.engine.World;
import fsm.FSM;
import org.jbox2d.common.Vec2;

/**
 * this is the enemy boss class that extends walker and implements StepListener
 */
    public class Buu extends Walker implements StepListener {
        
    private FSM<Buu> fsm;
    World world;
    Game game;

    /**
     * initialise the direction of movement
     */
    public int direction = -1; 
    private int timer = 0;

    /**
     * set the range the main character must be within for the boss to move
     */
    public static final float RANGE = 20;
    
    private static final Shape shape = new PolygonShape(-0.88f,2.06f, -1.28f,
            0.77f, -1.02f,-2.44f, 0.77f,-2.37f, 0.47f,1.64f, -0.47f,2.06f);
    
    private static final BodyImage Buu = new BodyImage("data/Buu.gif", 5);
    
    /**
     * initialise the boss 
     * @param world
     * @param game
     */
    public Buu(World world, Game game) {
        super(world, shape);
        this.world = world;
        this.game = game;
        this.setGravityScale(0.0f);
        addImage(Buu);
        fsm = new FSM<Buu>(this, new StandStillState());
        getWorld().addStepListener(this);
    }
    
    /**
     * this is the method that allows my boss to shoot in the direction that he is moving in
     */
    public void shootBuu() {
        if(direction == 1){
            BuuShot shot = new BuuShot(this.getWorld(), this);
            shot.setPosition(new Vec2((this.getPosition().x + 0.5f * this.direction), this.getPosition().y));
        } else if(direction == -1) {
            BuuShot shot = new BuuShot(this.getWorld(), this);
            shot.setPosition(new Vec2((this.getPosition().x + 0.5f * this.direction), this.getPosition().y));
            shot.getLeftAttack();
            shot.addImage(shot.getLeftAttack());
        }
    }
    
    /**
     * returns image of boss
     * @return
     */
    public BodyImage getBuu(){
    this.removeAllImages();
    return Buu;
    }

    /**
     * detects if character is in range from the left
     * @return
     */
    public boolean inRangeLeft() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        direction = -1;
        return gap < RANGE && gap > 0;
    }
    
    /**
     * detects if character is in range from the right
     * @return
     */
    public boolean inRangeRight() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        direction = 1;
        return gap > -RANGE && gap < 0;
    }
    
    /**
     * detects if character is in range from the left or right
     * @return
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }
    
    /**
     * things that are done before the boss starts moving 
     * @param e
     */
    public void preStep(StepEvent e) {
        fsm.update();
    }
    
    /**
     * things that are done once the boss starts moving
     * @param e
     */
    public void postStep(StepEvent e) {
        if(timer >= 120){
            shootBuu();
            timer = 0;
        }
        if(timer < 0){
            timer = 0;
        }
        timer += 1;
    }
}

   
