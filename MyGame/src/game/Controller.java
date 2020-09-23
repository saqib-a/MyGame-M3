package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * creating the controller to control the main character 
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 5;
    
    private Goku body;
    
    /**
     * initialises the controller
     * @param body
     */
    public Controller(Goku body) {
        this.body = body;
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // up = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // Left= walk left
            body.addImage(body.getDashLeftImage());
            body.facing = -1;
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // right = walk right
            body.addImage(body.getDashRightImage());
            body.facing = 1;
        }
        if(code == KeyEvent.VK_SPACE){
            if(body.facing == 1){
                body.shootR();
            } else if(body.facing == -1){
                body.shootL();
            }
        }

    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
            body.addImage(body.getStandLeftImage());
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
            body.addImage(body.getStandRightImage());

        }
    }
    
    /**
     * intialises the character
     * @param body
     */
    public void setBody(Goku body){
        this.body = body;
    }
}
