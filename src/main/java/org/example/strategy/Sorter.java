package org.example.strategy;


public class Sorter {
	public static void quicksort(Dog[] dogs, int l, int r) {
		int i = l;
		int j = r;
		int mid = (r - l >>> 1) + l;
		mid = dogs[mid].height;
		do {
			while(dogs[i].height < mid) {
				i += 1;
			}
			while(dogs[j].height > mid) {
				j -= 1;
			}
			if(i <= j) {
				swap(dogs, i, j);
				i += 1;
				j -= 1;
			}
		}while(i <= j);
		if(i < r) quicksort(dogs, i, r);
		if(j > l) quicksort(dogs, l, j);
	}
	public static void swap(Dog[] dogs, int i, int j) {
		Dog dog = dogs[i];
		dogs[i] = dogs[j];
		dogs[j] = dog;
	}
	public static void sort(Dog[] dogs) {
		int n = dogs.length;
		quicksort(dogs, 0, n - 1);
	}
}
