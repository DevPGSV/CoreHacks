package com.devpgsv.corehacks.tests.addressing_modes;

public class B_IndirectMode extends AddressingMode{

	public B_IndirectMode() {
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
		return false;
	}

}
