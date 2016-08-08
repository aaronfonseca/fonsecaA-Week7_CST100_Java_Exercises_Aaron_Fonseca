/** Program: Exercise 12.19
* 
* File: Exercise_12_19.java
* Summary: Chapter 12, Exercise 19. 
* 
* (Count words) Write a program that counts the number 
* of words in President Abraham Lincoln’s Gettysburg 
* address from http://cs.armstrong.edu/liang/data/Lincoln.txt.
* For 12.19, use the the Gettysburg Address or choose a larger file. 
* There are several large, free text files of novels and the like 
* on the Internet. In addition to counting the words in the text file, 
* convert the words to lower case, remove any punctuation and store 
* the words with length <= 3 in an ArrayList.
* 
* Author: Aaron Fonseca
* Date: August 7, 2016
**/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_12_19 {
	private static ArrayList<String> lessThanThree = new ArrayList<String>();
	private static int wordCounter = 0;
	private static int charCounter = 0;
	
	public static void main(String[] args) throws IOException {
		
		// Create input file from URL	
		java.net.URL url = new java.net.URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");

		// Open an input stream and create a Scanner object
		Scanner input = new Scanner(url.openStream());
	
		// While file has next
		while (input.hasNext()) {
			String address = input.next();
			
			// Convert all words to lowercase
			address = address.toLowerCase();
			
			// Remove all punctuation in file
			address = address.replaceAll("[^A-Za-z0-9]", "");
			
			// Add to the total character/word counts
			wordCounter += address.length();
			charCounter++;
			
			// If word is smaller or equal to 3 characters, add it to the arraylist
			if (address.length() <= 3 && address.length() >= 1)
				lessThanThree.add(address);
		}
		
		input.close();
		
		// Print out some results
		System.out.println("Word Count: " + wordCounter + "\nTotal Characters: " + charCounter + "\nWords with length <= 3: " + lessThanThree.size());
	}
}