package com.devpgsv.corehacks.tests.instructions;

import com.devpgsv.corehacks.tests.Field;
import com.devpgsv.corehacks.tests.Warrior;
import com.devpgsv.corehacks.tests.addressing_modes.AddressingModes;
import com.devpgsv.corehacks.tests.core.Core;
import com.devpgsv.corehacks.tests.core.CoreMemoryCell;

public class Instruction {
	protected String instructionString;
	protected Instructions enumInstruction;
	protected Field A = null;
	protected Field B = null;
	
	
	public Instruction(String instructionString) throws Exception {
		this.instructionString = instructionString;
		parse();
	}
	
	public void parse() throws Exception {
		String str[] = this.instructionString.trim().split(" ", 2);
		this.enumInstruction = Instruction.getAddressingModeFromString(str[0]);
		
		String fields[] = str[1].trim().split(",", 2);
		if (fields.length == 0) {
			throw new Exception("No fields?");
		}
		A = new Field(fields[0]);
		if (fields.length >= 2) {
			B = new Field(fields[1]);
		}
		if (fields.length >= 3) {
			throw new Exception(fields.length + " fields?");
		}
	}
	
	public static Instructions getAddressingModeFromString(String c) throws Exception {
		for (Instructions ins : Instructions.values()) {
			if (ins.toString().equalsIgnoreCase(c))
				return ins;
		}
		throw new Exception("No instruction found for " + c);
	}
	
	public String toString() {
		if (B != null) {
			return (this.enumInstruction.toString() + " A:("+this.A.toString()+") B:("+this.B.toString()+")");
		} else {
			return (this.enumInstruction.toString() + " A:("+this.A.toString()+")");
		}
	}
	
	public int getValue() {
		return A.getNum();
	}
	
	public void execute(Core core, Warrior warrior, int currentPos) throws Exception {
		if (this.enumInstruction == Instructions.MOV) {
			A.workWithPointerBefore();
			B.workWithPointerBefore();
			
			CoreMemoryCell origin;
			int destinationPos;
			if (A.getAddressingMode().getAddressingMode() == AddressingModes.DIRECT) {
				origin = core.getMemoryCell(currentPos + A.getNum());
			} else if (A.getAddressingMode().getAddressingMode() == AddressingModes.INDIRECT) {
				origin = core.getMemoryCell(currentPos + core.getMemoryCell(currentPos + A.getNum()).getInstruction().getValue());
			} else {
				System.out.println(A.getAddressingMode().getAddressingMode().getChar());
				throw new Exception("WTF? 1");
			}
			
			
			if (B.getAddressingMode().getAddressingMode() == AddressingModes.DIRECT) {
				destinationPos = currentPos + B.getNum();
			} else if (B.getAddressingMode().getAddressingMode() == AddressingModes.INDIRECT) {
				destinationPos = currentPos + core.getMemoryCell(currentPos + B.getNum()).getInstruction().getValue();
			} else {
				throw new Exception("WTF? 1");
			}
			
			core.setMemoryCell(destinationPos, origin.getInstruction(), warrior, false);
			
			A.workWithPointerAfter();
			B.workWithPointerAfter();
			warrior.addInstructionPos(currentPos + 1);
		}
	}
}
