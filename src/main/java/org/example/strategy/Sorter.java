package org.example.strategy;


public class Sorter<T> {
	private Comparator<T> comparator;
	
	private void quicksort(T[] t0, int l, int r) {
		int i = l;
		int j = r;
		int mid = (r - l >>> 1) + l;
		do {
			while(comparator.compare(t0[i], t0[mid]) == -1) {
				i += 1;
			}
			while(comparator.compare(t0[j], t0[mid]) == 1) {
				j -= 1;
			}
			if(i <= j) {
				swap(t0, i, j);
				i += 1;
				j -= 1;
			}
		}while(i <= j);
		if(i < r) quicksort(t0, i, r);
		if(j > l) quicksort(t0, l, j);
	}
	private void swap(T[] t0, int i, int j) {
		T t1 = t0[i];
		t0[i] = t0[j];
		t0[j] = t1;
	}
	public void sort(T[] t0, Comparator<T> comparator) {
		int n = t0.length;
		this.comparator = comparator;
		quicksort(t0, 0, n - 1);
	}
}
