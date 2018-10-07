import java.io.*;
import java.util.*;
import java.lang.Math.*;

/**
 * Class QuadEqtn stands for Quadratic Equation. The class creates a method to
 * calculate the roots of the quadratic equation. integers 'a', 'b', 'c' are the
 * coefficient of the quadratic equation. 'p' and 'q' are the roots of the
 * equation. The math equation to find the roots of quadratic function is broken
 * down as dicriminant, 'x' and 'y'. Discriminant solves for b^2 - 4ac, while
 * 'x' saves the solution for (-b/2a) and 'y' stores the result of the (square
 * root of discriminant/2a).
 * 
 */
class QuadEqtn {
	int a, b, c;
	double p, q;
	double x, y;
	double discriminant;

	/*
	 * CalculateRoots() solves for the roots of the quadratic function
	 */
	void CalculateRoots() {

		discriminant = (b * b) - (4 * a * c);

		x = Math.round((-b / (2.0 * a)) * 100.0) / 100.0;

		if (discriminant > 0) {

			y = ((Math.sqrt(discriminant)) / (2 * a));

			p = Math.round((x + y) * 100.0) / 100.0;

			System.out.println("p = " + p);

			q = Math.round((x - y) * 100.0) / 100.0;

			System.out.println("q = " + q);

			System.out.print("\n");

		} else if (discriminant < 0) {

			y = Math.round((((Math.sqrt(Math.abs(discriminant))) / (2 * a))) * 100.0) / 100.0;

			System.out.println("p = " + x + " + " + y + "i");

			System.out.println("q = " + x + " - " + y + "i");

			System.out.print("\n");

		} else if (discriminant == 0) {

			y = ((Math.sqrt(discriminant)) / (2 * a));

			p = x + y;

			System.out.println("p = " + p);

			System.out.print("\n");
		}
	}
}

public class Question1 {

	/*
	 * main reads the coefficient of the quadratic equation from an input text file
	 * which is thrown as exception
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Solving Quadric Equations");

		QuadEqtn qE = new QuadEqtn();

		Scanner x = new Scanner(new File("testQ1.txt"));

		while (x.hasNext()) {
			qE.a = x.nextInt();
			qE.b = x.nextInt();
			qE.c = x.nextInt();

			System.out.println("Value of a: " + qE.a);

			System.out.println("Value of b: " + qE.b);

			System.out.println("Value of  c: " + qE.c);

			System.out.println("Roots of quadratic equation " + qE.a + "x\u00B2 + " + qE.b + "x + " + qE.c + ": ");

			qE.CalculateRoots();

			System.out.print("\n");
		}
	}
}