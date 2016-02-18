package com.devpgsv.corehacks.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.devpgsv.corehacks.tests.instructions.Instruction;

public class Warrior {
	private String name;
	private String author;
	private String date;
	private String color;
	private LinkedList<Integer> instructionQueue;
	private boolean dead;
	
	private List<Instruction> instructions = new ArrayList<Instruction>();
	
	
	public Warrior(File file) throws Exception {
		parse(new Scanner(file));
		this.color = "\u001B[0m";
		instructionQueue = new LinkedList<Integer>();
		dead = false;
	}
	
	private void parse(Scanner scanner) throws Exception {
		// First comments...
		
		Instruction tmpInstruction;
		String nextLine = "";
		while (scanner.hasNextLine()) {
			nextLine= scanner.nextLine().split(";", 2)[0].trim();
			if (!nextLine.isEmpty()) {
				tmpInstruction = new Instruction(nextLine);
				instructions.add(tmpInstruction);
			}
			
		}
	}
	
	public boolean isDead() {
		return this.dead;
	}
	
	public void setDead() {
		this.dead = true;
	}
	
	public int nextInstructionPos() {
		return this.instructionQueue.removeFirst().intValue();
	}
	
	public void addInstructionPos(int pos) {
		this.instructionQueue.add(new Integer(pos));
	}
	
	public List<Instruction> getInstructions() {
		return this.instructions;
	}
	
	public void print() {
		for (Instruction i : instructions) {
			System.out.println(i);
		}
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
}
