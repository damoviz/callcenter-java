package com.callcenter;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.callcenter.entity.AbstractEmployees;
import com.callcenter.entity.Call;

/**
 * @author Edgar Mogollon
 * Clase que maneja las llamadas y las envía en hilos de manera concurrente;
 * también se encarga de poner en cola las llamadas que no se pudieron atender
 */

public class CallDispatcher extends Thread{

	BlockingQueue<AbstractEmployees> availableEmployees;
	BlockingQueue<Call> calls;

	public CallDispatcher(){
		availableEmployees = new PriorityBlockingQueue<AbstractEmployees>();
		calls = new LinkedBlockingQueue<Call>();
	}

	public void dispatchCall(Call call) throws InterruptedException{
		System.out.println("Entrando llamada " + call.getDescription());
		this.calls.put(call);
	}

	public void run() {
		Call llamada;
		AbstractEmployees employees;
		try {
			while(true){
				llamada = calls.take();
				System.out.println("Esperando a tomar la llamada " + llamada.getDescription());
				employees = availableEmployees.take();
				System.out.println("Empleado " + employees.getEmployeeName() + " va a tomar la llamda " + llamada.getDescription());
				employees.answerCall(llamada);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAvailableEmpleoyess(AbstractEmployees employee){
		this.availableEmployees.add(employee);
	}

	public Queue<AbstractEmployees> getAvailableEmployees(){
		return availableEmployees;
	}
	
	public Queue<Call> getCalls() {
		return calls;
	}
}
