package com.callcenter.entity;

import com.callcenter.CallDispatcher;

public class Director extends AbstractEmployees {
	public Director(CallDispatcher dispatcher, String name){
		super(dispatcher, name);
		this.employeeType = EmployeeType.DIRECTOR;
	}

	@Override
	void addEmployeeAvailable(CallDispatcher dispatcher) {
		dispatcher.addAvailableEmpleoyess(new Director(dispatcher, employeeName));
	}

}
