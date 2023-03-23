package org.example.strategy;

public class StrategyDemo {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[3];
		for(int i=0;i<3;i++) {
			dogs[i] = new Dog(i, 3 - i);
		}
		Sorter.sort(dogs);
		for(int i=0;i<3;i++) {
			System.out.println(dogs[i]);
		}
	}
}
