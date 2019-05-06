package com.callcenter.entity;

public enum EmployeeType {
	OPERATOR(1),
	SUPERVISOR(2),
	DIRECTOR(3);
	private int priorityAttention;
	
	EmployeeType(int priorityAttention){
		this.priorityAttention = priorityAttention;
	}
	
	public int getPriorityAttention(){
		return priorityAttention;
	}
}
