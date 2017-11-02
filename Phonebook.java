/*
 * Name: Austin Cottrill
 * Instructor: Entrekin
 * Date: 2 November 2017 -WIP
 * Assignment: Assignment11
 * Purpose: Creates a phonebook
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Phonebook {
	private Entry[] entries;
	private int count;

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

	public void saveAs(String filename) throws IOException {
		FileWriter out = new FileWriter(new File(filename));
		for (Entry x : entries) {
			out.write(x.toCSV());
		}
	}

	public boolean isSorted() {
		for (int i = 1; i < entries.length - 1; i++) {
			if (entries[i].compareTo(entries[i + 1]) == -1)
				return false;
			else if (entries[i].compareTo(entries[i - 1]) == 1)
				return false;
		}
		return true;
	}

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

	private boolean isFull() {

	}

	private void reallocate() {

	}
}
