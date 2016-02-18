package com.devpgsv.corehacks.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.devpgsv.corehacks.tests.addressing_modes.AddressingMode;

public class Field {
	private int num;
	private AddressingMode addressingMode;
	private String fieldString;
	public static final Pattern fieldPattern = Pattern.compile("([#$*@{}<>]?)(-)?([0-9]+)");
	
	public Field(String fieldString) throws Exception {
		this.fieldString = fieldString;
		parse();
	}
	
	private void parse() throws Exception {
		String str = this.fieldString.trim();
		Matcher m = fieldPattern.matcher(str);
		
		if (m.matches()) {
			if (m.group(1).length() == 0) 
				this.addressingMode = AddressingMode.getAddressingModeFromChar('0');
			else if (m.group(1).length() == 1) 
				this.addressingMode = AddressingMode.getAddressingModeFromChar(m.group(1).charAt(0));
			else
				throw new Exception("Invalid format! Error while parsing addressing mode from regex!");
			
			this.num = Integer.parseInt(m.group(3));
			if ((m.group(2) != null) && (m.group(2).equals("-"))) {
				this.num *= -1;
			}
		} else {
			throw new Exception("Invalid format! No matches in regex!");
		}
	}
	
	public void workWithPointerBefore() {
		this.num = addressingMode.workWithPointerBefore(this.num);
	}
	
	public void workWithPointerAfter() {
		this.num = addressingMode.workWithPointerAfter(this.num);
	}
	
	public int getNum() {
		return this.num;
	}
	
	public AddressingMode getAddressingMode() {
		return this.addressingMode;
	}
	
	public String toString() {
		return (this.addressingMode.getClass().getSimpleName() + ", " + num);
	}
}
