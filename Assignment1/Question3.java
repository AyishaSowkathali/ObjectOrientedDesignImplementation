import java.io.*;
import java.util.*;
import java.lang.Math.*;

/**
 * class ReadFile reads the input file and stores the values in an int array
 */
class ReadFile {

	private Scanner x;

	/*
	 * openFile - checks and handles the exception of whether the file is found or
	 * not.
	 */
	public void openFile() {
		try {
			x = new Scanner(new File("testQ3.txt"));
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	/*
	 * readFile() funtion reads the value from file and returns the values as an
	 * array of integers
	 */
	public int[] readFile() {
		int[] arr = new int[10];
		int i = 0;
		while (x.hasNext()) {
			arr[i] = x.nextInt();
			i++;
		}
		return arr;
	}

	public void closeFile() {
		x.close();
	}
}

/**
 * Quick sort class via multiple methods, sorts the input values
 */
class QuickSort {

	/*
	 * arr[] - array of integers from input file; left - first half of the array
	 * right - second half of the array
	 */
	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int pivot = arr[(left + right) / 2];
		int tmp;

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	/*
	 * arr[] - array of integers from input file; left - first half of the array
	 * right - second half of the array
	 */
	void sort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			sort(arr, left, index - 1);
		if (index < right)
			sort(arr, index, right);
	}

	/*
	 * arr[] - array of integers from input file;
	 */
	void showList(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}

public class Question3 {
	public static void main(String[] args) {
		ReadFile read = new ReadFile();

		QuickSort qS = new QuickSort();
		// Open file
		read.openFile();
		// Read file
		int[] arr = read.readFile();

		qS.showList(arr);
		qS.partition(arr, 0, arr.length - 1);
		qS.sort(arr, 0, arr.length - 1);
		qS.showList(arr);

		read.closeFile();
	}
}
