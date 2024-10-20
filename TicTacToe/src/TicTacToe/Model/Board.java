package TicTacToe.Model;
import TicTacToe.Pair;
import java.util.*;

public class Board {
	
	
	public int size;
	public PlayingPiece[][] board;
	public Board(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		board = new PlayingPiece[size][size];
	}
	
	public List<Pair<Integer, Integer>> getFreeCells() {
		List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
		for(int i=0; i<size;i++) {
			for (int j=0;j<size;j++) {
				Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
				freeCells.add(rowColumn);
			}
		}
		return freeCells;
	}

	public boolean addPiece(int inputRow, int inputCol, PlayingPiece playingPiece) {
		if(this.board[inputRow][inputCol]==null) {
			this.board[inputRow][inputCol] = playingPiece;
			return true;
		}
		return false;
		
	}
	public void printBoard() {
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }

	}
}
