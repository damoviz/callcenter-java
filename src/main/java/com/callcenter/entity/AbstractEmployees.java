package com.callcenter.entity;

import com.callcenter.CallDispatcher;

public abstract class AbstractEmployees extends Thread implements Comparable<AbstractEmployees>{

	//Referencia al dispatcher
	private CallDispatcher dispatcher;
	//Datos del empeado
	protected EmployeeType employeeType;
	protected String employeeName;
	//Llamada que esta atendiendo
	private Call callAttended;
	
	public AbstractEmployees(CallDispatcher dispatcher, String employeeName){
		this.dispatcher = dispatcher;
		this.employeeName = employeeName;
	}
	
	public int getPriorityAttention(){
		return this.employeeType.getPriorityAttention();
	}
	
	public int compareTo(AbstractEmployees aE) {
		if (this.getPriorityAttention() < aE.getPriorityAttention()){
			return -1;
		}
		if (this.getPriorityAttention() > aE.getPriorityAttention()){
			return 1;
		}
		return 0;	
	}

	public void answerCall(Call call) throws InterruptedException {
		this.callAttended = call;
		this.start();
	}

	//Cuando se ejecuta el hilo, significa que esta atendiendo la llamada. El hilo que en espera (sleep) la duracion de la llamada.
	public void run() {
        try {
		Thread.sleep(1000 * callAttended.getDuration());
        System.out.println("Llamada " + callAttended.getDescription() + " finalizada. Duracion :" + callAttended.getDuration());
        this.addEmployeeAvailable(dispatcher);
        System.out.println("Empleado " + this.getEmployeeName() + " disponible");
		} catch (InterruptedException e) {
			System.out.println("Error atendiendo llamada " + callAttended.getDescription());
			e.printStackTrace();
		} 
	}

	//Este metodo tiene que ser implementado por los hijos porque tiene que agregar a la cola una nueva instancia de empleado
	abstract void addEmployeeAvailable(CallDispatcher dispatcher);

	public String getEmployeeName() {
		return employeeName;
	}

}
