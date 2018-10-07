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
			x = new Scanner(new File("testQ4.txt"));
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	/*
	 * readFile() funtion reads the value from file and returns the values as an
	 * array of integers
	 */
	public int[] readFile() {
		int[] n = new int[4];
		int i = 0;
		while (x.hasNext()) {
			n[i] = x.nextInt();
			i++;
		}
		return n;
	}

	public void closeFile() {
		x.close();
	}
}

public class Question4 {
	/*
	 * @param number - current value, x - current digit, k - number of digits
	 */
	private void printNumber(int number, int x, int k) {
		if (k == 0) {
			System.out.print(number + " ");
			return;
		}
		// Try all possible greater digits
		for (int i = (x + 1); i < 10; i++)
			printNumber(number * 10 + i, i, k - 1);
	}

	/*
	 * @param k - length of ordered numbers
	 */
	private void generateNum(int k) {
		printNumber(0, 0, k);
	}

	/*
	 * @param k is the size of the string
	 */
	private void binary(int k) {
		String a;
		/*
		 * loops to form possible number of combinations of size k string
		 */
		for (int i = 0; i < Math.pow(2, k); i++) {
			a = "";
			/*
			 * temp holds the alternate position of the characters in string
			 */
			int temp = i;
			/*
			 * loops to add the number of characters in a string
			 */
			for (int j = 0; j < k; j++) {
				if (temp % 2 == 1)
					a = '1' + a;
				else
					a = '0' + a;
				temp = temp / 2;
			}
			if (!a.contains("11")) {
				System.out.print(a + " ");
			}
		}
	}

	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		Question4 q = new Question4();
		read.openFile();
		int[] n = read.readFile();
		for (int i = 0; i < n.length; i++) {
			if (n[i] == 1) {
				System.out.println("n = " + n[i]);
				System.out.print(0 + " ");
				q.generateNum(n[i]);
				System.out.println();
			}
			if (n[i] == 2) {
				System.out.println("n = " + n[i]);
				for (int j = 1; j < 10; j++) {
					System.out.print("0" + j + " ");
				}
				q.generateNum(n[i]);
				System.out.println();
			}
			if (n[i] == 3) {
				System.out.println("k = " + n[i]);
				q.binary(n[i]);
				System.out.println();
			}
			if (n[i] == 4) {
				System.out.println("k = " + n[i]);
				q.binary(n[i]);
				System.out.println();
			}
		}
		System.out.println();
		read.closeFile();
	}
}