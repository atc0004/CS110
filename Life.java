import java.util.Scanner;

public class Life {

	private char[][] theBoard;
	private int rows, columns;
	
	public Life() {
		this.rows = 10;
		this.columns = 10;
		theBoard = new char[10][10];
		for (int x = 0; x < theBoard.length; x++) {
			for (int y = 0; y < theBoard[x].length; y++) {
				theBoard[x][y] = 'f';
			}
		}
	}

	public Life(int r, int c) {
		this.rows = r;
		this.columns = c;
		theBoard = new char[r][c];
	}

	public boolean isFree(int r, int c) {
		if (theBoard[r][c] == 'f')
			return true;
		return false;
	}

	public boolean isOccupied(int r, int c) {
		if (theBoard[r][c] == 'o')
			return true;
		return false;
	}

	public boolean isDying(int r, int c) {
		if (theBoard[r][c] == 'd')
			return true;
		return false;
	}

	public boolean isBorn(int r, int c) {
		if (theBoard[r][c] == 'b')
			return true;
		return false;
	}

	private int countNeighbors(int r, int c) {
		// System.out.println("Neighbors");
		// TODO Accessor for cell at r, c to determine the number of neighbors
		// That are either occupied or dying in the current generation
		// Any cell has potential to have 8 neighbors
		// Determine how r and c need to change to identify a neighboring cell
		// Before accessing, determine if the cell is within the bounds or you will
		// ArrayIndexOutOfBounds exception. used only inside the class to count
		// neighbors
		int neighbors = 0;
		int right = c + 1;
		int left = c - 1;
		int up = r - 1;
		int down = r + 1;
		// Above, left
		//System.out.println("Counting");
		if ((up) >= 0 && (left) >= 0 && isOccupied(up, left) || (up) >= 0 && (left) >= 0 && isDying(up, left))
			neighbors++;
		// Above
		if (up >= 0 && isOccupied(up, c) || up >= 0 && isDying(up, c))
			neighbors++;
		// Above, right
		if (up >= 0 && right < columns && isOccupied(up, right) || up >= 0 && right < columns && isDying(up, right))
			neighbors++;
		// Right
		if (right < columns && isOccupied(r, right) || right < columns && isDying(r, right))
			neighbors++;
		// Down, right
		if (down < rows && right < columns && isOccupied(down, (right))
				|| (down) < rows && (right) < columns && isDying((down), (right)))
			neighbors++;
		// Down
		if ((down) < rows && isOccupied((down), c) || (down) < rows && isDying((down), c))
			neighbors++;
		// Down, left
		if ((down) < rows && (left) >= 0 && isOccupied((down), (left))
				|| (down) < rows && (left) >= 0 && isDying((down), (left)))
			neighbors++;
		// Left
		if ((left) >= 0 && isOccupied(r, left) || (left) >= 0 && isDying(r, left))
			neighbors++;
		return neighbors;
	}

	public void setBorn(int r, int c) {
		theBoard[r][c] = 'b';
	}

	public void setOccupied(int r, int c) {
		theBoard[r][c] = 'o';
	}

	public void setDying(int r, int c) {
		theBoard[r][c] = 'd';
	}

	public void setFree(int r, int c) {
		theBoard[r][c] = 'f';
	}

	public void clearBoard() {
		for (int y = 0; y < theBoard.length; y++) {
			for (int x = 0; x < theBoard.length; x++) {
				theBoard[x][y] = 'f';
			}
		}
	}

	public void fillBoard(Scanner inputFile) {
		// TODO reads the data file, marking some cells in theBoard as occupied
		// Until file is empty, it reads two files at a time, which represent
		// the row/column pair which names a cell whose state should be "occupied"
		// Calls setCanvas method at the end then drawBoard to draw the board
		while (inputFile.hasNext()) {
			setOccupied(inputFile.nextInt(), inputFile.nextInt());
		}
		setCanvas();
		drawBoard();
	}

	public void playgame() throws InterruptedException {
		private boolean flag = false;
		for (int generation = 0; generation < 100; generation++) {//Change to a While loop while loop to check if any changes were made
		
			int neighbors = 0;
			for (int row = 0; row < theBoard.length - 1; row++) {
				//System.out.println("First for");
				for (int col = 0; col < theBoard[row].length; col++) {
					neighbors = countNeighbors(row, col);
					if (neighbors == 3 && !isOccupied(row, col)) {
						setBorn(row, col);
					} else if (neighbors >= 4 && isOccupied(row, col)) {
						setDying(row, col);
					} else if (neighbors <= 1 && isOccupied(row, col)) {
						setDying(row, col);
					}
				}
			}
			System.out.println("Generation:" + (generation+1));
			nextGeneration();
			drawBoard();
		}
	}

	private void nextGeneration() {
		//System.out.println("Generating");
		StdDraw.show(100);
		StdDraw.clear();
		for (int y = 0; y < theBoard.length; y++) {
			for (int x = 0; x < theBoard[y].length; x++) {
				if (isBorn(y, x)) {
					setOccupied(y, x);
				} else if (isDying(y, x)) {
					setFree(y, x);
				}
			} // End inner for
		} // End outer for
	}

	private void setCanvas() {
		StdDraw.setYscale(0, 10 * this.rows);
		StdDraw.setXscale(0, 10 * this.columns);
	}

	private void drawBoard() {
		int x, y;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				// use the isOccupied method to see if a cell
				// is occupied
				if (this.isOccupied(i, j))
					StdDraw.setPenColor(StdDraw.BLUE);
				else
					StdDraw.setPenColor(StdDraw.WHITE);

				x = j * 10 + 5;
				y = (10 * (this.rows - i)) - 5;

				StdDraw.filledSquare(x, y, 5);
			} // inner
		}
	}// end drawBoard

}
