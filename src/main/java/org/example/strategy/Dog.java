package org.example.strategy;

public class Dog {
	private int weight;
	private int height;
	
	public Dog(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Dog{" + "weight=" + weight + ",height=" + height + "}";
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
}
