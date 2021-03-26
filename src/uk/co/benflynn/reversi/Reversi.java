package uk.co.benflynn.reversi;

import uk.co.benflynn.reversi.gui.GUI;

public class Reversi {

	// State 0 = off, 1 = black turn, 2 = white turn
	public int gameState = 0;
	public boolean whitePlayed = false, blackPlayed = true;
	public int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, 
							 {0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0}, 
							 {0, 0, 0, 1, 2, 0, 0, 0},
							 {0, 0, 0, 2, 1, 0, 0, 0}, 
						   	 {0, 0, 0, 0, 0, 0, 0, 0},
						 	 {0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0}};
	
	public static void main(String[] args) {
		// On start
		GUI gui = new GUI();
		gui.createFrame();
	}

}
