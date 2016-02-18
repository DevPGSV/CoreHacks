package com.devpgsv.corehacks.tests.addressing_modes;

public class A_IndirectMode extends AddressingMode{

	public A_IndirectMode() {
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
