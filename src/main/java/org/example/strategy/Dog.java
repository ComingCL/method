package org.example.strategy;

public class Dog {
	int weight;
	int height;
	
	public Dog(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	public int compareTo(Dog d) {
		if(d.weight > weight) return -1;
		if(d.weight < weight) return 1;
		return 0;
	}
	@Override
	public String toString() {
		return "Dog{" + "weight=" + weight + ",height=" + height + "}";
	}
}
