import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Question5 {

	private static Scanner in = new Scanner(System.in);

	/*
	 * The LinkedList funtion named getList() throws an exception to check whether
	 * the file is open. It then opens the file and reads the content using string
	 * array and adds the string array to a list. The function then returns the list
	 * to main.
	 */
	private static LinkedList<String> getList() throws Exception {
		Scanner read = new Scanner(new File("testQ5.txt"));

		int fSize = 5;
		String[] word = new String[fSize];
		String[] symbol = new String[fSize];
		String[] meaning = new String[fSize];

		// Declaration of linked list
		LinkedList<String> list = new LinkedList<String>();

		int i = 0;
		while (read.hasNextLine() && i < fSize) {
			word[i] = read.next();
			symbol[i] = read.next().toString();
			meaning[i] = read.next();

			// storing data from file to list
			list.add(word[i]);
			list.add(meaning[i]);

			// to iterate the list
			i++;
		}
		return list;
	}

	/*
	 * chkQuery stands for check query, taked the list as the parameter. checks
	 * whether the query entered by user is in the list and returns the associated
	 * meaning.
	 */
	private void chkQuery(LinkedList<String> list) {

		System.out.print("Query: ");
		String query = in.next();

		if (list.contains(query)) {
			System.out.println("Answer: " + list.get(list.indexOf(query) + 1));
		} else {
			System.out.println("Query Not Found");
		}
	}

	public static void main(String[] args) throws Exception {

		Question5 q = new Question5();

		LinkedList<String> list = q.getList();

		q.chkQuery(list);

	}
}