/** Program: Exercise 12.15
* 
* File: Exercise_12_15.java
* Summary: Chapter 12, Exercise 15. 
* 
* (Write/read data) Write a program to create a file named Exercise12_15.txt 
* if it does not exist. Write 100 integers created randomly into the file using 
* text I/O. Integers are separated by spaces in the file. Read the data back 
* from the file and display the data in increasing order.
* 
* Author: Aaron Fonseca
* Date: August 7, 2016
**/

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Exercise_12_15 {
	public static void main(String[] args) throws Exception {
		
		Random rand = new Random();

		// Check if file Exercise12_15.txt exists
		File file = new File("Exercise12_15.txt");
		if (file.exists()) {
			System.out.println("File exists");
			System.exit(0);
		}

		try (
			// Create new file
			PrintWriter newFile = new PrintWriter(file);
		) {
			// Write 100 integers created randomly to file
			for (int i = 0; i < 100; i++) {
				int randomNumber = rand.nextInt(100) + 1;
				newFile.print(randomNumber + " "); // Print numbers to file
			}
		}

		// Crate an ArrayList
		ArrayList<Integer> list = new ArrayList<>();

		try(
			// Create input file
			Scanner input = new Scanner(file);
		) {
			// Read the data from the file
			while (input.hasNext()) {
				list.add(input.nextInt());
			}
		}

		// Sort the new list
		Collections.sort(list);

		// Display data in increasing order
		System.out.print(list.toString());
		System.out.println();
	}
}