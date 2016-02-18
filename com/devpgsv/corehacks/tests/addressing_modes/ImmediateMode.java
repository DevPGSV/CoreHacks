package com.devpgsv.corehacks.tests.addressing_modes;

public class ImmediateMode extends AddressingMode{

	public ImmediateMode() {
		super(AddressingModes.IMMEDIATE);
	}

	@Override
	public int workWithPointerBefore(int p) {
		return p;
	}

	@Override
	public int workWithPointerAfter(int p) {
		return p;
	}
	
	@Override
	public boolean isValidCharForThisMode(char c) {
		return (c == getChar());
	}
	
}
