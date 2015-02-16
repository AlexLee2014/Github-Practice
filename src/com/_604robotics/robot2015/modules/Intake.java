package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.module.Module;
import edu.wpi.first.wpilibj.Talon;

// TODO: Auto-generated Javadoc
/**
 * The Class Intake.
 */
public class Intake extends Module {
    
    /** The motor. */
    private final Talon motor = new Talon(9); //Placeholder Talon position

    /**
     * Instantiates a new intake.
     */
    public Intake() {
        this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run(ActionData data) {
                    motor.stopMotor();
                }
            });

            add("In", new Action() {
                public void run(ActionData data) {
                    motor.set(-1D);
                }

                public void end(ActionData data) {
                    motor.stopMotor();
                }
            });
            add("Out", new Action() {
                public void run(ActionData data) {
                    motor.set(1D);
                }
                public void end(ActionData data){
                    motor.stopMotor();
                }
            });
        }});
    }
}
