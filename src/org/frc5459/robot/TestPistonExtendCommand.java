package org.frc5459.robot;

import org.strongback.command.Command;
import org.strongback.components.Solenoid;

public class TestPistonExtendCommand extends Command {
	private Solenoid solenoid;
	
	public TestPistonExtendCommand(Solenoid solenoid) {
		this.solenoid = solenoid;
	}
	
	@Override
	public boolean execute() {
		solenoid.extend();
		return true;
	}

}
