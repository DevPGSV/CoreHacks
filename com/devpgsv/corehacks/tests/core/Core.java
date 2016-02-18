package com.devpgsv.corehacks.tests.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.devpgsv.corehacks.tests.Warrior;
import com.devpgsv.corehacks.tests.instructions.Instruction;

public class Core {
	private CoreMemoryCell coreBoard[];
	int size;
	private List<Warrior> warriors;
	
	public Core(int size) throws Exception {
		coreBoard = new CoreMemoryCell[size];
		this.size = size;
		
		warriors = new ArrayList<Warrior>();
		clear();
	}
	
	public void clear() throws Exception {
		Instruction datZero = new Instruction("DAT 0");
		for (int i = 0; i < size; i++) {
			this.coreBoard[i] = new CoreMemoryCell(datZero, null, false);
		}
	}
	
	public void loadWarrior(Warrior warrior, int initPos) throws Exception {
		List<Instruction> instructions = warrior.getInstructions();
		for (int i = 0; i < instructions.size(); i++) {
			if (this.coreBoard[(initPos + i) % this.size].getHasInitialWarriorCode()) {
				throw new Exception("Can't overwrite warrior!");
			}
			setMemoryCell((initPos + i) % this.size, instructions.get(i), warrior, true);
		}
		warriors.add(warrior);
		warrior.addInstructionPos(initPos);
	}
	
	public void setMemoryCell(int pos, Instruction instruction, Warrior lastEditedByWarrior, boolean hasInitialWarriorCode) {
		this.coreBoard[pos % this.size].setInstruction(instruction);
		this.coreBoard[pos % this.size].setHasInitialWarriorCode(hasInitialWarriorCode);
		this.coreBoard[pos % this.size].setLastEditedByWarrior(lastEditedByWarrior);
	}
	
	public CoreMemoryCell getMemoryCell(int pos) {
		return this.coreBoard[pos % this.size];
	}
	
	public void simulationStep() throws Exception {
		int instructionPos;
		int warriorsAlive = 0;
		for (Warrior warrior : this.warriors) {
			if (!warrior.isDead()) {
				warriorsAlive++;
				instructionPos = warrior.nextInstructionPos();
				this.coreBoard[instructionPos].getInstruction().execute(this, warrior, instructionPos);
			}
			
		}
		if (warriorsAlive == 0) {
			// All warriors are dead!
		}
	}
	
	public String toString() {
		int cols = 40;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.size / cols; i++) {
			for (int j = 0; j < cols; j++) {
				//System.out.println(i + "*10+" + j + "=" + (i*10+j));
				//this.coreBoard[i*10 + j].getInstruction();
				if (this.coreBoard[i*cols + j].getLastEditedByWarrior() != null) {
					if (this.coreBoard[i*cols + j].getHasInitialWarriorCode()) {
						s.append("\u001B[1m");
					}
					s.append(this.coreBoard[i*cols + j].getLastEditedByWarrior().getColor() + "X\u001B[0m");
				} else {
					s.append("·");
				}
			}
			s.append(System.lineSeparator());
		}
		return s.toString();
		
	}
}
