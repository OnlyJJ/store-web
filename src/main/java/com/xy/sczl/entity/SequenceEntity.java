package com.xy.sczl.entity;

public class SequenceEntity {
	private String name;
	private int currentValue; 
	private int increment;
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
