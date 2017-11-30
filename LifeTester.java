import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LifeTester {
	public static void main(String[] args) throws InterruptedException {
		Scanner read;
		Scanner in = new Scanner(System.in);
		String filename;

		System.out.println("Please enter the name of the data file you would like to read.");
		filename = in.nextLine();

		try {
			read = new Scanner(new File(filename));
			int rows = read.nextInt();
			int cols = read.nextInt();
			Life newGame = new Life(rows, cols);
			newGame.fillBoard(read);
			in.close();
			newGame.playgame();

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}