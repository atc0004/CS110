import java.util.*;

public class Entry {
	private final String FIRST_NAME;
	private final String LAST_NAME;
	private final String PHONE_NUMBER;

	public Entry(String fName, String lName, String num) {
		this.FIRST_NAME = fName;
		this.LAST_NAME = lName;
		this.PHONE_NUMBER = num;
	}

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

	public String toCSV() {
		String entry;
		entry = (LAST_NAME + "," + FIRST_NAME + "," + PHONE_NUMBER);
		return entry;
	}
}
