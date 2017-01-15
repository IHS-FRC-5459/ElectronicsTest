package org.frc5459.robot;

import org.strongback.command.Command;
import org.strongback.components.Solenoid;

public class TestPistonRetractCommand extends Command {
	private Solenoid solenoid;
	
	
	public TestPistonRetractCommand(Solenoid solenoid) {
		this.solenoid = solenoid;
	}
	
	@Override
	public boolean execute() {
		solenoid.retract();
		return true;
	}

}
