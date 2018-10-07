import java.io.*;
import java.util.*;
import java.lang.Math.*;

/**
 * Matrix class creates two methods to perform matrix addition and
 * multiplication
 * 
 */
class Matrix {

	String header = "Matrix Operations";

	Random random = new Random();

	/*
	 * matrixAddition takes the size of row and column of the matrix as arguments.
	 * It initializes two 2D arrays and fills them with randomly generated elements,
	 * using which it performs addition and returns the sum matrix.
	 */
	int[][] matrixAddition(int m, int n) {
		Matrix M = new Matrix();

		int[][] A = new int[m][n];
		int[][] B = new int[m][n];
		int[][] Sum = new int[m][n];

		System.out.println("\nElements of Matrix A: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = random.nextInt(100);
			}
		}
		M.showMatrix(A, m, n);

		System.out.println("\nElements of Matrix B: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = random.nextInt(100);
			}
		}
		M.showMatrix(B, m, n);

		System.out.println("\nSum of matrix A and B: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Sum[i][j] = A[i][j] + B[i][j];
			}
		}
		M.showMatrix(Sum, m, n);
		return Sum;
	}

	/*
	 * matrixAddition takes the size of row and column of the matrix as arguments.
	 * It initializes two 2D arrays and fills them with randomly generated elements,
	 * using which it performs multiplication and returns the product matrix.
	 */
	int[][] matrixMultiplation(int m, int n) {
		Matrix M = new Matrix();

		int[][] A = new int[m][n];
		int[][] B = new int[m][n];
		int[][] Product = new int[m][n];

		System.out.println("\nElements of Matrix A: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = random.nextInt(100);
			}
		}
		M.showMatrix(A, m, n);

		System.out.println("\nElements of Matrix B: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = random.nextInt(100);
			}
		}
		M.showMatrix(B, m, n);

		System.out.println("\nProduct of matrix A and B: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Product[i][j] = A[i][j] * B[i][j];
			}
		}
		M.showMatrix(Product, m, n);
		return Product;
	}

	/*
	 * showMatrix takes integer array, row size and column size as parameters and
	 * outputs the matrix to the console
	 */
	private void showMatrix(int[][] arr, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

/**
 * public class includes the main method, main takes the size of row and column
 * from user
 */
public class Question2 {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Matrix m = new Matrix();
		System.out.println(m.header);
		int M, N;

		System.out.print("Enter the row size of the matrix: ");
		N = in.nextInt();

		System.out.print("Enter the column size of the matrix: ");
		M = in.nextInt();

		m.matrixAddition(N, M);
		m.matrixMultiplation(N, M);
		System.out.print("\n");
	}
}