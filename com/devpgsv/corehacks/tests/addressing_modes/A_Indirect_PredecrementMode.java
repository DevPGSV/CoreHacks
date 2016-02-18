package com.devpgsv.corehacks.tests.addressing_modes;

public class A_Indirect_PredecrementMode extends AddressingMode{

	public A_Indirect_PredecrementMode() {
		super(AddressingModes.INDIRECT_PREDECREMENT);
	}

	@Override
	public int workWithPointerBefore(int p) {
		return p - 1;
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
