package TicTacToe;
import TicTacToe.Model.*;
import java.util.*;


public class TicTacToeGame {
	Deque<Player> players;
	Board gameBoard;
	public TicTacToeGame(int playerSize, int boardSize) {
		initializeGame(playerSize, boardSize);
	}
	public void initializeGame(int playerSize, int boardSize) {
//		create for 2 players
		players = new LinkedList<>();
		PlayingPiece pieceX = new PlayingPieceX();
		Player playerX = new Player("Player1", pieceX);
		System.out.println("Player Added "+ playerX.name);
		players.add(playerX);
		PlayingPiece pieceO = new PlayingPieceO();
		Player playerO = new Player("Player2", pieceO);
		System.out.println("Player Added "+ playerO.name);
		players.add(playerO);
		gameBoard = new Board(boardSize);
	}
	@SuppressWarnings("resource")
	public String StartGame() {
		boolean noWinner = true;
		while(noWinner) {
//			take out the player whose turn is and also put the player in the list back
			Player playerTurn = players.removeFirst();
			//get the free space from the board
			gameBoard.printBoard();
			List <Pair<Integer, Integer>> freeSpace = gameBoard.getFreeCells();
			if(freeSpace.isEmpty()) {
				noWinner=false;
				continue;
			}
			
//			read the user input
			System.out.println("Player: "+ playerTurn.name + " Enter row, col: ");
			Scanner inputScanner = new Scanner(System.in);
			String s = inputScanner.nextLine();
			String[] values = s.split(",");
			int inputRow = Integer.valueOf(values[0]);
			int inputCol = Integer.valueOf(values[1]);
			
			//place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputCol, playerTurn.piece);
            if(!pieceAddedSuccessfully) {
            	//player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorret possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
                
            }
            players.addLast(playerTurn);
            boolean winner = this.isThereWinner(inputRow, inputCol, playerTurn.piece.pieceType);
            if(winner) {
                return playerTurn.name;
            }			
			
		}
		return "tie";
	}

	public boolean isThereWinner(int inputRow, int inputCol, PieceType pieceType ) {
		boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        int n = this.gameBoard.size;
        
      //need to check in row
        for (int i=0; i<n; i++) {
        	if(gameBoard.board[inputRow][i]==null || gameBoard.board[inputRow][i].pieceType!=pieceType) {
        		rowMatch = false;
        	}
        }
        
      //need to check in column
        for (int i=0; i<n; i++) {
        	if(gameBoard.board[i][inputCol]==null || gameBoard.board[i][inputCol].pieceType!=pieceType) {
        		columnMatch = false;
        	}
        }
        
      //need to check diagonals
        for (int i=0; i<n; i++) {
        	if(gameBoard.board[i][i]==null || gameBoard.board[i][i].pieceType!=pieceType) {
        		diagonalMatch = false;
        	}
        }
        
      //need to check anti-diagonals
        for (int i=0; i<n; i++) {
        	if(gameBoard.board[i][n-1-i]==null || gameBoard.board[i][n-1-i].pieceType!=pieceType) {
        		antiDiagonalMatch = false;
        	}
        }
        
		return rowMatch||columnMatch||diagonalMatch||antiDiagonalMatch;
	}
}
