package com.devpgsv.corehacks.tests.core;

import com.devpgsv.corehacks.tests.Warrior;
import com.devpgsv.corehacks.tests.instructions.Instruction;

public class CoreMemoryCell {
	private Instruction instruction;
	private Warrior lastEditedByWarrior;
	private boolean hasInitialWarriorCode;
	
	public CoreMemoryCell(Instruction instruction, Warrior lastEditedByWarrior, boolean hasInitialWarriorCode) {
		this.instruction = instruction;
		this.lastEditedByWarrior = lastEditedByWarrior;
		this.hasInitialWarriorCode = hasInitialWarriorCode;
	}
	
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public void setLastEditedByWarrior(Warrior lastEditedByWarrior) {
		this.lastEditedByWarrior = lastEditedByWarrior;
	}
	
	public void setHasInitialWarriorCode(boolean hasInitialWarriorCode) {
		this.hasInitialWarriorCode = hasInitialWarriorCode;
	}
	
	public Instruction getInstruction() {
		return this.instruction;
	}
	
	public Warrior getLastEditedByWarrior() {
		return this.lastEditedByWarrior;
	}
	
	public boolean getHasInitialWarriorCode() {
		return this.hasInitialWarriorCode;
	}
}
