package com.devpgsv.corehacks.tests.addressing_modes;

public class Indirect_PostincrementMode extends AddressingMode{

	public Indirect_PostincrementMode() {
		super(AddressingModes.INDIRECT_POSTINCREMENT);
	}

	@Override
	public int workWithPointerBefore(int p) {
		return p;
	}

	@Override
	public int workWithPointerAfter(int p) {
		return p + 1;
	}

	@Override
	public boolean isValidCharForThisMode(char c) {
		return (c == '}' | c == '>');
	}

}
