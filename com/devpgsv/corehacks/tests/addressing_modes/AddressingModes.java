package com.devpgsv.corehacks.tests.addressing_modes;

public enum AddressingModes {
	IMMEDIATE('#'),
	DIRECT('$'),
	INDIRECT('*'),
	INDIRECT_PREDECREMENT('{'),
	INDIRECT_POSTINCREMENT('}');
	/*
	A_INDIRECT('*'),
	A_INDIRECT_PREDECREMENT('{'),
	A_INDIRECT_POSTINCREMENT('}'),
	B_INDIRECT('@'),
	B_INDIRECT_PREDECREMENT('<'),
	B_INDIRECT_POSTINCREMENT('>'),
	*/
	
	private char addressingCharacter;
	
	AddressingModes(char addressingCharacter) {
		this.addressingCharacter = addressingCharacter;		
	}
	
	public char getChar() {
		return this.addressingCharacter;
	}
}
