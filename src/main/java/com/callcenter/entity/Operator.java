package com.callcenter.entity;

import com.callcenter.CallDispatcher;

public class Operator extends AbstractEmployees {
	public Operator(CallDispatcher dispatcher, String name){
		super(dispatcher, name);
		super.employeeType = EmployeeType.OPERATOR;
	}

	@Override
	void addEmployeeAvailable(CallDispatcher dispatcher) {
		dispatcher.addAvailableEmpleoyess(new Operator(dispatcher, employeeName));
	}

}
