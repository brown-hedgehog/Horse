import java.awt.Point;

public class Horse {
	private int boardSize = 8;
	private int[][] board = new int[boardSize][boardSize];
	private final int numberOfMoves = boardSize * boardSize;
	private int tracker;
	private static int counter;
	private static int row;
	private static int col;
	private final Point[] moves = new Point[] { new Point(1, 2),
			new Point(2, 1), new Point(2, -1), new Point(1, -2),
			new Point(-1, -2), new Point(-2, -1), new Point(-2, 1),
			new Point(-1, 2) };

	private void printMatrix(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean canMove(int x, int y) {
		return ((x >= 0 && x < boardSize) && (y >= 0 && y < boardSize)
				&& (board[x][y] == 0) && (tracker <= numberOfMoves)) ? true
				: false;
	}

	private void move(int x, int y) {
		for (int i = 0; i < moves.length; i++) {
			int possibleX = x + moves[i].x;
			int possibleY = y + moves[i].y;
			boolean condition = canMove(possibleX, possibleY);
			if (condition) {
				tracker += 1;
				board[possibleX][possibleY] = tracker;
				move(possibleX, possibleY);
			}
			if (i == moves.length - 1 && board[x][y] != 0) {
				condition = false;
			}
			if (i == moves.length - 1 && !condition) {
				board[x][y] = 0;
				tracker -= 1;
			}
		}
		if (tracker == (numberOfMoves - 1)) {
			System.out.println(counter += 1);
			printMatrix(board);
			return;
		}
	}

	public static void main(String[] args) {
		new Horse().move(row, col);
	}
}