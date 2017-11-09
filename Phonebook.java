/*
 * Name: Austin Cottrill
 * Instructor: Entrekin
 * Date: 2 November 2017 -WIP
 * Assignment: Assignment11
 * Purpose: Creates a phonebook full of the entries entered by 
 * the user, stores and reads from a file
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Phonebook {
	private Entry[] entries;
	private int count;

	/**
	 * Constructor for phone book.
	 * @param csvFileName The filename that the user wants to read from
	 * @throws FileNotFoundException
	 */
	public Phonebook(String csvFileName) throws FileNotFoundException {
		count = 0;
		Scanner reader = new Scanner(new File(csvFileName));
		entries = new Entry[1000];
		while (reader.hasNext()) {
			String[] entry = reader.next().split(",");
			entries[count] = new Entry(entry[1], entry[0], entry[2]);
			count++;
		}
	}

	/**
	 * Saves the phonebook to a file
	 * @param filename The filename that the user wants to save the phonebook as
	 * @throws IOException
	 */
	public void saveAs(String filename) throws IOException {
		FileWriter out = new FileWriter(new File(filename));
		for (Entry x : entries) {
			out.write(x.toCSV());
		}
	}

	/**
	 * Checks if the phone boook is sorted
	 * @return Whether or not the phonebook is sorted.
	 */
	public boolean isSorted() {
		for (int i = 1; i < entries.length - 1; i++) {
			if (entries[i].compareTo(entries[i + 1]) == -1)
				return false;
			else if (entries[i].compareTo(entries[i - 1]) == 1)
				return false;
		}
		return true;
	}

	/**
	 * Sorts the phone book with a bubble sort
	 */
	public void bubbleSort() {
		for (Entry x : entries) {
			for (int i = 0; i < entries.length - 1; i++) {
				Entry temp;
				if (entries[i].compareTo(entries[i + 1]) == 1) {
					temp = entries[i];
					entries[i] = entries[i+1];
					entries[i+1] = temp;
				}
			}
		}
	}
	/*
	 * wasSwapped = true;
	 * for(int i=0; i < array.length; i++){
	 * 		for(int j = 0; j < array.length-1-i;j++){
	 * 			if(array[j] > array[j+1]{
	 * 				wasSwapped = true;
	 * 				temp = array[j];
	 * 				array[j] = array[j+1];
	 * 			}
	 * 			else
	 * 				wasSwapped = false;
	 * 		}
	 * 80,17,100,-5,3,25,34,40
	 * }
	 */

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Please Enter arguments for source and target files");
			return;
		}
		String sourceFile = args[0];
		String targetFile = args[1];
		try {
			Phonebook pBook = new Phonebook(sourceFile);
			if(pBook.isSorted()){
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		
	}

	/**
	 * Checks if the phone book is full
	 * @return True if the phonebook is full, false otherwise
	 */
	private boolean isFull() {
		if()
	}

	/**
	 * Changes the size of the array to allow for more entries
	 */
	private void reallocate() {

	}
}
