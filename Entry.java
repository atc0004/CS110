import java.util.*;

public class Entry {
	private final String FIRST_NAME;
	private final String LAST_NAME;
	private final String PHONE_NUMBER;

	/**
	 * Constructor that creates an entry in the phone book.
	 * @param fName First name of the entry
	 * @param lName Last name of the entry
	 * @param num Phone number of the entry
	 */
	public Entry(String fName, String lName, String num) {
		this.FIRST_NAME = fName;
		this.LAST_NAME = lName;
		this.PHONE_NUMBER = num;
	}

	/**
	 * 
	 * @param otherEntry The entry that this entry will be compared to
	 * @return -1 if this needs to come before other, 1 if it needs to come after other
	 */
	public int compareTo(Entry otherEntry) {
		int value = new String(LAST_NAME).compareTo(otherEntry.LAST_NAME);
		switch (value) {
		case -1:
			return value;
		case 0:
			return new String(FIRST_NAME).compareTo(otherEntry.FIRST_NAME);
		case 1:
			return value;
		default:
			return value;
		}
	}

	/**
	 * Creates a string of the entry
	 * @return The entry as a string
	 */
	public String toCSV() {
		String entry;
		entry = (LAST_NAME + "," + FIRST_NAME + "," + PHONE_NUMBER);
		return entry;
	}
}
