package com.devpgsv.corehacks.tests.addressing_modes;

public class IndirectMode extends AddressingMode{

	public IndirectMode() {
		super(AddressingModes.INDIRECT);
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
		return (c == '*' || c == '@');
	}

}
