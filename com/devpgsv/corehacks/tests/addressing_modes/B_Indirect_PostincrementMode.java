package com.devpgsv.corehacks.tests.addressing_modes;

public class B_Indirect_PostincrementMode extends AddressingMode{

	public B_Indirect_PostincrementMode() {
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
		return false;
	}
	
	

}
