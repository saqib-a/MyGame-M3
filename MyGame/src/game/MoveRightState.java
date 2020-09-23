package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 *this is the for the FSM for my boss that makes him move right which extends the FSMState<Buu>
 */
public class MoveRightState extends FSMState<Buu> {

    
    protected void update() {
        Buu buu = getContext();
        if (buu.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (!buu.inRange()) {
            gotoState(new StandStillState());
        } else {
            buu.setLinearVelocity(new Vec2(1.5f,0));
        }
    }

    protected void enter() {
        Buu buu = getContext();
        buu.setLinearVelocity(new Vec2(1.5f,0));
    }
    
    protected void exit() {}
}
