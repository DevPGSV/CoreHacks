package com.devpgsv.corehacks.tests.addressing_modes;

import java.util.Arrays;
import java.util.List;

public abstract class AddressingMode {
	protected AddressingModes addressingMode;
	private static List<AddressingMode> AddressingModesList = Arrays.asList(
		new ImmediateMode(),
		new DirectMode(),
		new IndirectMode(),
		new Indirect_PredecrementMode(),
		new Indirect_PostincrementMode()
	);
	
	public AddressingMode(AddressingModes addressingMode) {
		this.addressingMode = addressingMode;
	}
	
	public char getChar() {
		return this.addressingMode.getChar();
	}
	
	public AddressingModes getMode() {
		return this.addressingMode;
	}
	
	public abstract int workWithPointerBefore(int p);
	public abstract int workWithPointerAfter(int p);
	
	public abstract boolean isValidCharForThisMode(char c);
	/*
	public boolean isValidCharForThisMode(char c) {
		return (c == getChar());
	}
	*/
	
	public AddressingModes getAddressingMode() {
		return this.addressingMode;
	}
	
	public static AddressingMode getAddressingModeFromEnum(AddressingModes addressingMode) throws Exception {
		return AddressingMode.getAddressingModeFromChar(addressingMode.getChar());
	}
	
	public static AddressingMode getAddressingModeFromChar(char c) throws Exception {
		for (AddressingMode mode : AddressingMode.AddressingModesList) {
			if (mode.isValidCharForThisMode(c))
				return mode;
		}
		throw new Exception("No addressing mode found for " + c);
	}
}
