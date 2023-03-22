package org.example.state;

public class Person {
	String name;
	private PersonState state;
	public Person(String name, PersonState state) {
		this.name = name;
		this.state = state;
	}
	public void smile() {
		state.smile();
	}
	public void say() {
		state.say();
	}
	public void cry() {
		state.cry();
	}
}
