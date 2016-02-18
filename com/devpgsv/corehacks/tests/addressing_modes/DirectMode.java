package com.devpgsv.corehacks.tests.addressing_modes;

public class DirectMode extends AddressingMode{

	public DirectMode() {
		super(AddressingModes.DIRECT);
	}
	
	@Override
	public boolean isValidCharForThisMode(char c) {
		return ((c == getChar()) || (c == '0'));
	}

	@Override
	public int workWithPointerBefore(int p) {
		return p;
	}

	@Override
	public int workWithPointerAfter(int p) {
		return p;
	}

}
