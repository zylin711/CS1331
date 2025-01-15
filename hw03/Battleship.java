import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");

		// Initializes boards
		char[][] playerOneBoard = initializeBoard();
		char[][] playerTwoBoard = initializeBoard();
		char[][] playerOneShots = initializeBoard();
		char[][] playerTwoShots = initializeBoard();

		// Player 1 places ships
		System.out.println("\nPLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		placeShips(scanner, playerOneBoard);
		printBattleShip(playerOneBoard);
		clearScreen();

		// Player 2 places ships
		System.out.println("\nPLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		placeShips(scanner, playerTwoBoard);
		printBattleShip(playerTwoBoard);
		clearScreen();

		// Game loop
		boolean gameWon = false;
		boolean isPlayerOneTurn = true;

		while (!gameWon) {
			if (isPlayerOneTurn) {
				System.out.println("\nPlayer 1, enter hit row/column:");
				gameWon = takeTurn(scanner, playerOneShots, playerTwoBoard, 1, 2);
			} else {
				System.out.println("\nPlayer 2, enter hit row/column:");
				gameWon = takeTurn(scanner, playerTwoShots, playerOneBoard, 2, 1);
			}
			isPlayerOneTurn = !isPlayerOneTurn;
		}

		// Print final boards
		System.out.println("\nFinal boards:\n");
		printBattleShip(playerOneBoard);
		System.out.println();
		printBattleShip(playerTwoBoard);
		scanner.close();
	}

	// Initializes an empty board
	private static char[][] initializeBoard(){
		char[][] board = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = '-';
			}
		}
		return board;
	}

	// Places ships （using do-while loop）
	private static void placeShips(Scanner scanner, char[][] board){
		for (int shipsPlaced = 0; shipsPlaced < 5; shipsPlaced++) {
			boolean validInput = false;
			int row, col;

			do {
				System.out.println("Enter ship " + (shipsPlaced + 1) + " location:");
				try {
					row = scanner.nextInt();
					col = scanner.nextInt();

					if (!isValidCoordinate(row, col)) {
						System.out.println("Invalid coordinates. Choose different coordinates.");
					} else if (board[row][col] == '@') {
						System.out.println("You already have a ship there. Choose different coordinates.");
					} else {
						board[row][col] = '@';
						validInput = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid coordinates. Choose different coordinates.");
				}
			} while (!validInput);
		}
	}

	// Validates coordinates
	private static boolean isValidCoordinate(int row, int col){
		return row >= 0 && row < 5 && col >= 0 && col < 5;
	}

	// Clears the screen by printing 100 new lines
	private static void clearScreen() {
		for (int i = 0; i < 99; i++) {
			System.out.println();
		}
	}

	// Take player's turn
	private static boolean takeTurn(Scanner scanner, char[][] shotsBoard, char[][] opponentBoard, int player, int opponent) {
		int row = 0;
		int col = 0;
		boolean validShot = false;

		while (!validShot) {
			try {
				row = scanner.nextInt();
				col = scanner.nextInt();

				// Validate the coordinates
				if (!isValidCoordinate(row, col)) {
					System.out.println("Invalid coordinates. Choose different coordinates.");
					System.out.printf("Player %s, enter hit row/column:\n", player);
					continue;
				}

				// Check if the spot has already been fired at
				if (shotsBoard[row][col] != '-') {
					System.out.println("You already fired on this spot. Choose different coordinates.");
					System.out.printf("Player %s, enter hit row/column:\n", player);
					continue;
				}
				validShot = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				System.out.printf("Player %s, enter hit row/column:\n", player);
			}
		}

		// Check if the shot hit or missed
		if (opponentBoard[row][col] == '@') {
			System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", player, opponent);
			opponentBoard[row][col] = 'X';
			shotsBoard[row][col] = 'X';
		} else {
			System.out.printf("PLAYER %d MISSED!\n", player);
			shotsBoard[row][col] = 'O';
			if (opponentBoard[row][col] == '-') {
				opponentBoard[row][col] = 'O';
			}
		}
		printBattleShip(shotsBoard);
		return checkWin(opponentBoard, player);
	}


	// Checks if a player has won
	private static boolean checkWin(char[][] board, int player) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == '@') {
					return false;
				}
			}
		}
		System.out.println("PLAYER " + player + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
		return true;
	}

	// Print game boards to the console
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}