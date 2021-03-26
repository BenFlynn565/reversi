package uk.co.benflynn.reversi.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.benflynn.reversi.Reversi;
import uk.co.benflynn.reversi.gui.buttons.BlackButton;
import uk.co.benflynn.reversi.gui.buttons.BoardButton;
import uk.co.benflynn.reversi.gui.buttons.WhiteButton;
import uk.co.benflynn.reversi.utils.MoveValidator;

public class GenerateBoard {

	public BoardButton[][] whiteBoardButtons = new BoardButton[8][8];
	public BoardButton[][] blackBoardButtons = new BoardButton[8][8];
	private Color backgroundGreen = new Color(0, 255, 0);
	private Color borderColour = new Color(0, 0, 0);
	private Reversi main = new Reversi();

	public void generateBoardSquares(JFrame whiteframe, JFrame blackframe, JPanel whitepanel, JPanel blackpanel) {
		for (int row = 0; row < main.board.length; row++) {
			for (int column = 0; column < main.board[row].length; column++) {
				generateWhite(blackframe, whiteframe, whitepanel, blackpanel, row, column);
			}
		}

		for (int row = main.board.length - 1; row >= 0; row--) {
			for (int column = main.board[row].length - 1; column >= 0; column--) {
				generateBlack(blackframe, whiteframe, whitepanel, blackpanel, row, column);
			}
		}

	}

	private void generateWhite(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel, int x, int y) {
		if (main.board[x][y] == 0) {
			whiteBoardButtons[x][y] = new BoardButton(1, 1, backgroundGreen, 1, borderColour);
			whiteBoardButtons[x][y].setName("" + x + y);
			whiteBoardButtons[x][y].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// If it's white turn
					if (main.blackPlayed == true && main.whitePlayed == false) {
						
						// Get the pressed button and the index of it
						BoardButton button = (BoardButton) e.getSource();

						String buttonRowStr = button.getName().substring(0, 1);
						String buttonColStr = button.getName().substring(1, 2);
						int buttonRow = Integer.parseInt(buttonRowStr);
						int buttonCol = Integer.parseInt(buttonColStr);
						// Set the green to white
						System.out.println("Row: " + buttonRow + ", Column: " + buttonCol);
						int direction = -1;
						MoveValidator mv = new MoveValidator();
						direction = mv.isValidWhite(buttonRow, buttonCol);
						if(direction == 2) {
							for(int i = buttonRow-1; i >= 0; i--) {
								if(main.board[i][buttonCol] == 0 || main.board[i][buttonCol] == 1) {
									break;
								}
								main.board[i][buttonCol] = 1;
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 3) {
							for(int x = buttonRow-1; x >= 0; x--) {
								for(int y = buttonCol+1; y >= 7; y++) {
									if(main.board[x][y] == 0 || main.board[x][y] == 1) {
										break;
									}
									main.board[x][y] = 1;
								}
								main.board[buttonRow][buttonCol] = 1;
							}
						} else if(direction == 4) {
							for(int i = buttonCol+1; i >= 7; i++) {
								if(main.board[buttonRow][i] == 0 || main.board[buttonRow][i] == 1) {
									break;
								}
								
								main.board[buttonRow][i] = 1;
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 5) {
							for(int x = buttonRow+1; x >= 7; x++) {
								for(int y = buttonCol+1; y >= 7; y++) {
									if(main.board[x][y] == 0 || main.board[x][y] == 1) {
										break;
									}
									main.board[x][y] = 1;
								}
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 6) {
							for(int i = buttonRow+1; i >= 7; i++) {
								if(main.board[i][buttonCol] == 0 || main.board[i][buttonCol] == 1) {
									break;
								}
								main.board[i][buttonCol] = 1;
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 7) {
							for(int x = buttonRow+1; x >= 7; x++) {
								for(int y = buttonCol-1; y >= 0; y--) {
									if(main.board[x][y] == 0 || main.board[x][y] == 1) {
										break;
									}
									main.board[x][y] = 1;
								}
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 8) {
							for(int i = buttonCol-1; i >= 0; i--) {
								if(main.board[buttonRow][i] == 0 || main.board[buttonRow][i] == 1) {
									break;
								}
								main.board[buttonRow][i] = 1;
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 1) {
							for(int x = buttonRow-1; x >= 0; x--) {
								for(int y = buttonCol-1; y >= 0; y--) {
									if(main.board[x][y] == 0 || main.board[x][y] == 1) {
										break;
									}
									main.board[x][y] = 1;
								}
							}
							main.board[buttonRow][buttonCol] = 1;
						}
						repaint(blackframe, whiteframe, whitepanel, blackpanel);
						
						main.whitePlayed = true;
						main.blackPlayed = false;
					}
				}
			});
			whitepanel.add(whiteBoardButtons[x][y]);
		} else if (main.board[x][y] == 1) {
			WhiteButton wbutton = new WhiteButton(1, 1, Color.white, 1, borderColour);
			whitepanel.add(wbutton);
		} else {
			BlackButton bbutton = new BlackButton(1, 1, Color.black, 1, borderColour);
			whitepanel.add(bbutton);
		}
	}

	private void generateBlack(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel, int x, int y) {
		if (main.board[x][y] == 0) {
			blackBoardButtons[x][y] = new BoardButton(1, 1, backgroundGreen, 1, borderColour);
			blackBoardButtons[x][y].setName("" + x + y);
			blackBoardButtons[x][y].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (main.blackPlayed == false && main.whitePlayed == true) {
						BoardButton button = (BoardButton) e.getSource();
						String buttonRowStr = button.getName().substring(0, 1);
						String buttonColStr = button.getName().substring(1, 2);
						int buttonRow = Integer.parseInt(buttonRowStr);
						int buttonCol = Integer.parseInt(buttonColStr);
						// Set the green to black
						int direction = -1;
						MoveValidator mv = new MoveValidator();
						direction = mv.isValidBlack(buttonRow, buttonCol);
						if(direction == 2) {
							for(int i = buttonRow-1; i >= 0; i--) {
								if(main.board[i][buttonCol] == 0 || main.board[i][buttonCol] == 2) {
									break;
								}
								main.board[i][buttonCol] = 2;
							}
							main.board[buttonRow][buttonCol] = 1;
						} else if(direction == 3) {
							for(int x = buttonRow-1; x >= 0; x--) {
								for(int y = buttonCol+1; y >= 7; y++) {
									if(main.board[x][y] == 0 || main.board[x][y] == 2) {
										break;
									}
									main.board[x][y] = 2;
								}
								main.board[buttonRow][buttonCol] = 2;
							}
						} else if(direction == 4) {
							for(int i = buttonCol+1; i >= 7; i++) {
								if(main.board[buttonRow][i] == 0 || main.board[buttonRow][i] == 2) {
									break;
								}
								main.board[buttonRow][i] = 2;
							}
							main.board[buttonRow][buttonCol] = 2;
						} else if(direction == 5) {
							for(int x = buttonRow+1; x >= 7; x++) {
								for(int y = buttonCol+1; y >= 7; y++) {
									if(main.board[x][y] == 0 || main.board[x][y] == 2) {
										break;
									}
									main.board[x][y] = 2;
								}
							}
							main.board[buttonRow][buttonCol] = 2;
						} else if(direction == 6) {
							for(int i = buttonRow+1; i >= 7; i++) {
								if(main.board[i][buttonCol] == 0 || main.board[i][buttonCol] == 2) {
									break;
								}
								main.board[i][buttonCol] = 2;
							}
							main.board[buttonRow][buttonCol] = 2;
						} else if(direction == 7) {
							for(int x = buttonRow+1; x >= 7; x++) {
								for(int y = buttonCol-1; y >= 0; y--) {
									if(main.board[x][y] == 0 || main.board[x][y] == 2) {
										break;
									}
									main.board[x][y] = 2;
								}
							}
							main.board[buttonRow][buttonCol] = 2;
						} else if(direction == 8) {
							for(int i = buttonCol-1; i >= 0; i--) {
								if(main.board[buttonRow][i] == 0 || main.board[buttonRow][i] == 2) {
									break;
								}
								main.board[buttonRow][i] = 2;
							}
							main.board[buttonRow][buttonCol] = 2;
						} else if(direction == 1) {
							for(int x = buttonRow-1; x >= 0; x--) {
								for(int y = buttonCol-1; y >= 0; y--) {
									if(main.board[x][y] == 0 || main.board[x][y] == 2) {
										break;
									}
									main.board[x][y] = 2;
								}
							}
							main.board[buttonRow][buttonCol] = 2;
						}
						repaint(blackframe, whiteframe, whitepanel, blackpanel);

						main.whitePlayed = false;
						main.blackPlayed = true;
					}
				}

			});
			blackpanel.add(blackBoardButtons[x][y]);
		} else if (main.board[x][y] == 1) {
			WhiteButton wbutton = new WhiteButton(1, 1, Color.white, 1, borderColour);
			blackpanel.add(wbutton);
		} else {
			BlackButton bbutton = new BlackButton(1, 1, Color.black, 1, borderColour);
			blackpanel.add(bbutton);
		}
	}
	
	private void repaint(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel) {
		whitepanel.removeAll();
		blackpanel.removeAll();
		generateBoardSquares(whiteframe, blackframe, whitepanel, blackpanel);
		blackpanel.revalidate();
		whitepanel.revalidate();
		blackpanel.repaint();
		whitepanel.repaint();
	}
}