package com.devpgsv.corehacks.tests.instructions;

public enum Instructions {
	DAT("DAT"),
	MOV("MOV"),
	ADD("ADD"),
	SUB("SUB"),
	MUL("MUL"),
	DIV("DIV"),
	MOD("MOD"),
	JMP("JMP"),
	DJN("DJN"),
	SPL("SPL"),
	CMP("CMP"),
	SEQ("SEQ"),
	SNE("SNE"),
	SLT("SLT"),
	LDP("LDP"),
	STP("STP"),
	NOP("NOP");
	
	private String instAsStr;
	
	Instructions(String str) {
		this.instAsStr = str;
	}
	
	public String toString() {
		return this.instAsStr;
	}
}
