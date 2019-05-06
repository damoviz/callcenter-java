package com.callcenter.entity;

import java.util.Random;

public class Call {
	public static final int MIN_DURACION = 5;
	public static final int MAX_DURACION = 10;
	private int duration;
	private String description;

	public Call(String description){
		duration = new Random().nextInt(MAX_DURACION - MIN_DURACION + 1) + MIN_DURACION;
		this.description = description;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
