package uk.co.benflynn.reversi;

import uk.co.benflynn.reversi.gui.GUI;

public class Reversi {

	// State 0 = off, 1 = black turn, 2 = white turn
	public int gameState = 2;
	public static int turn = 1;
	private int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, 
							 {0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0}, 
							 {0, 0, 0, 1, 2, 0, 0, 0},
							 {0, 0, 0, 2, 1, 0, 0, 0}, 
						   	 {0, 0, 0, 0, 0, 0, 0, 0},
						 	 {0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0}};
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.createFrame();
	}
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		Reversi.turn = turn;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

}
