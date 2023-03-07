package com.example;

public class Greeter{
	public Greeter(){
	}
	
	public final String greet(final String name){
		 return String.format("Hello, %s!", name);
	}
}