/* Created Wed Jan 11 11:02:42 EST 2017 */
package org.frc5459.robot;

import org.strongback.Strongback;
import org.strongback.SwitchReactor;
import org.strongback.components.Solenoid;
import org.strongback.components.Solenoid.Direction;
import org.strongback.components.ui.FlightStick;
import org.strongback.hardware.Hardware;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	private Solenoid solenoid; 
	private SwitchReactor reactor;
	private FlightStick stick;
	
    @Override
    public void robotInit() {
    	solenoid = Hardware.Solenoids.doubleSolenoid(0, 1, Direction.EXTENDING);
    	reactor = Strongback.switchReactor();
    	stick = Hardware.HumanInterfaceDevices.logitechAttack3D(0);
    }

    @Override
    public void teleopInit() {
        // Start Strongback functions ...
        Strongback.start();
    }

    @Override
    public void teleopPeriodic() {
    	reactor.onTriggered(stick.getThumb(), ()-> Strongback.submit(new TestPistonRetractCommand(solenoid)));
    	reactor.onTriggered(stick.getTrigger(), ()-> Strongback.submit(new TestPistonExtendCommand(solenoid)));
    }

    @Override
    public void disabledInit() {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable();
    }

}
