package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * this is the for the FSM for my boss that makes him stand still which extends the FSMState<Buu>
 */
public class StandStillState extends FSMState<Buu> {

     

    protected void update() {
        Buu buu = getContext();
        if (buu.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (buu.inRangeRight()) {
            gotoState(new MoveRightState());
        }
    }

    protected void enter() {
        Buu buu = getContext();
        buu.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
}
