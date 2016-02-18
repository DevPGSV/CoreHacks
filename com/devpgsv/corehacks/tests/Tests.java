package com.devpgsv.corehacks.tests;

import java.io.File;

import com.devpgsv.corehacks.tests.addressing_modes.AddressingMode;
import com.devpgsv.corehacks.tests.core.Core;
import com.devpgsv.corehacks.tests.core.CoreMemoryCell;
import com.devpgsv.corehacks.tests.instructions.Instruction;

public class Tests {

	public static void main(String[] args) throws Exception {
		/*
		AddressingMode a = AddressingMode.getAddressingModeFromChar('{');
		System.out.println(a.getClass().getSimpleName());
		
		int i = 0;
		i = a.workWithPointerBefore(i);
		System.out.println(i);
		*/
		
		/*
		Field f = new Field("10");
		System.out.println(f.getAddressingMode().getClass().getSimpleName());
		*/
		
		/*
		Instruction i = new Instruction("MOV 4, #5");
		System.out.println(i.toString());
		*/
		
		Warrior imp1 = new Warrior(new File("imp.red")); imp1.setColor("\u001B[32m");
		Warrior imp2 = new Warrior(new File("imp.red")); imp2.setColor("\u001B[34m");
		
		/*
		Core core = new Core(4000);
		core.loadWarrior(imp1, 0);
		core.loadWarrior(imp2, 2050);
		*/
		
		Core core = new Core(400);
		core.loadWarrior(imp1, 0);
		core.loadWarrior(imp2, 205);
		
		
		while (true) {
			System.out.println("\n");
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println(core);
			core.simulationStep();
			Thread.sleep(100);
		}
		
		
	}

}
