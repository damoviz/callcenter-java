package com.callcenter.entity;

import com.callcenter.CallDispatcher;

public class Supervisor extends AbstractEmployees {
	public Supervisor(CallDispatcher dispatcher, String name){
		super(dispatcher, name);
		super.employeeType = EmployeeType.SUPERVISOR;
	}

	@Override
	void addEmployeeAvailable(CallDispatcher dispatcher) {
		dispatcher.addAvailableEmpleoyess(new Supervisor(dispatcher, employeeName));
	}

}
