package uk.co.benflynn.reversi.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uk.co.benflynn.reversi.Reversi;
import uk.co.benflynn.reversi.gui.buttons.BlackButton;
import uk.co.benflynn.reversi.gui.buttons.BoardButton;
import uk.co.benflynn.reversi.gui.buttons.WhiteButton;

public class GenerateBoard {

	public BoardButton[][] whiteBoardButtons = new BoardButton[8][8];
	public BoardButton[][] blackBoardButtons = new BoardButton[8][8];
	private Color backgroundGreen = new Color(0, 255, 0);
	private Color borderColour = new Color(0, 0, 0);
	private Reversi main = new Reversi();

	public void generateBoardSquares(JFrame whiteframe, JFrame blackframe, JPanel whitepanel, JPanel blackpanel) {
		for (int row = 0; row < main.getBoard().length; row++) {
			for (int column = 0; column < main.getBoard()[row].length; column++) {
				generateWhite(blackframe, whiteframe, whitepanel, blackpanel, row, column);
			}
		}

		for (int row = main.getBoard().length - 1; row >= 0; row--) {
			for (int column = main.getBoard()[row].length - 1; column >= 0; column--) {
				generateBlack(blackframe, whiteframe, whitepanel, blackpanel, row, column);
			}
		}

	}

	private int northSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int north = 0;
		for (int x = buttonRow - 1; x >= 0; x--) {
			if (main.getBoard()[x][buttonCol] == opposite) {
				north++;
			} else if (main.getBoard()[x][buttonCol] == col) {
				return north;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintNorth(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow - 1; x >= 0; x--) {
			if (main.getBoard()[x][buttonCol] == opposite) {
				main.getBoard()[x][buttonCol] = col;
			} else if (main.getBoard()[x][buttonCol] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int northEastSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int northE = 0;
		for (int x = buttonRow - 1, y = buttonCol + 1; y <= 7 && x >= 0; y++, x--) {
			if (main.getBoard()[x][y] == opposite) {
				northE++;
			} else if (main.getBoard()[x][y] == col) {
				return northE;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintNorthEast(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow - 1, y = buttonCol + 1; y <= 7 && x >= 0; y++, x--) {
			if (main.getBoard()[x][y] == opposite) {
				main.getBoard()[x][y] = col;
			} else if (main.getBoard()[x][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int eastSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int east = 0;
		for (int y = buttonCol + 1; y <= 7; y++) {
			if (main.getBoard()[buttonRow][y] == opposite) {
				east++;
			} else if (main.getBoard()[buttonRow][y] == col) {
				return east;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintEast(int buttonRow, int buttonCol, int opposite, int col) {
		for (int y = buttonCol + 1; y <= 7; y++) {
			if (main.getBoard()[buttonRow][y] == opposite) {
				main.getBoard()[buttonRow][y] = col;
			} else if (main.getBoard()[buttonRow][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int southEastSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int southE = 0;
		for (int x = buttonRow + 1, y = buttonCol + 1; y <= 7 && x <= 7; y++, x++) {
			if (main.getBoard()[x][y] == opposite) {
				southE++;
			} else if (main.getBoard()[x][y] == col) {
				return southE;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintSouthEast(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow + 1, y = buttonCol + 1; y <= 7 && x <= 7; y++, x++) {
			if (main.getBoard()[x][y] == opposite) {
				main.getBoard()[x][y] = col;
			} else if (main.getBoard()[x][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int southSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int south = 0;
		for (int x = buttonRow + 1; x <= 7; x++) {
			if (main.getBoard()[x][buttonCol] == opposite) {
				south++;
			} else if (main.getBoard()[x][buttonCol] == col) {
				return south;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintSouth(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow + 1; x <= 7; x++) {
			if (main.getBoard()[x][buttonCol] == opposite) {
				main.getBoard()[x][buttonCol] = col;
			} else if (main.getBoard()[x][buttonCol] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int southWestSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int southW = 0;
		for (int x = buttonRow + 1, y = buttonCol - 1; y >= 0 && x <= 7; y--, x++) {
			if (main.getBoard()[x][y] == opposite) {
				southW++;
			} else if (main.getBoard()[x][y] == col) {
				return southW;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintSouthWest(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow + 1, y = buttonCol - 1; y >= 0 && x <= 7; y--, x++) {
			if (main.getBoard()[x][y] == opposite) {
				main.getBoard()[x][y] = col;
			} else if (main.getBoard()[x][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int westSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int west = 0;
		for (int y = buttonCol - 1; y >= 0; y--) {
			if (main.getBoard()[buttonRow][y] == opposite) {
				west++;
			} else if (main.getBoard()[buttonRow][y] == col) {
				return west;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintWest(int buttonRow, int buttonCol, int opposite, int col) {
		for (int y = buttonCol - 1; y >= 0; y--) {
			if (main.getBoard()[buttonRow][y] == opposite) {
				main.getBoard()[buttonRow][y] = col;
			} else if (main.getBoard()[buttonRow][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	private int northWestSearch(int buttonRow, int buttonCol, int opposite, int col) {
		int northW = 0;
		for (int x = buttonRow - 1, y = buttonCol - 1; y >= 0 && x >= 0; y--, x--) {
			if (main.getBoard()[x][y] == opposite) {
				northW++;
			} else if (main.getBoard()[x][y] == col) {
				return northW;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void paintNorthWest(int buttonRow, int buttonCol, int opposite, int col) {
		for (int x = buttonRow - 1, y = buttonCol - 1; y >= 0 && x >= 0; y--, x--) {
			if (main.getBoard()[x][y] == opposite) {
				main.getBoard()[x][y] = col;
			} else if (main.getBoard()[x][y] == col) {
				break;
			} else {
				break;
			}
		}
		main.getBoard()[buttonRow][buttonCol] = col;
	}

	public int movePossible(int col) {
		int maxWhite = 0, maxBlack = 0;
		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				int runWhite = valid(x, y, 1);
				int runBlack = valid(x, y, 2);
				if (maxWhite < runWhite) {
					maxWhite = runWhite;
				}
				if (maxBlack < runBlack) {
					maxBlack = runBlack;
				}
			}
		}

		if (maxWhite == 0 && maxBlack == 0) {
			int whiteSpaces = 0, blackSpaces = 0;

			for (int x = 0; x <= 7; x++) {
				for (int y = 0; y <= 7; y++) {
					if (main.getBoard()[x][y] == 1) {
						whiteSpaces++;
					} else if (main.getBoard()[x][y] == 2) {
						blackSpaces++;
					}
				}
			}
			if (blackSpaces > whiteSpaces) {
				JOptionPane.showMessageDialog(null, "Black Wins: " + whiteSpaces + ":" + blackSpaces);

			} else if (whiteSpaces > blackSpaces) {
				JOptionPane.showMessageDialog(null, "White Wins: " + whiteSpaces + ":" + blackSpaces);
			} else {
				JOptionPane.showMessageDialog(null, "Draw: " + whiteSpaces + ":" + blackSpaces);
			}
			regenerateBoard();
		}

		if (col == 1) {
			if (maxWhite == 0) {
				return 1;
			} else {
				return 2;
			}
		} else if (col == 2) {
			if (maxBlack == 0) {
				return 1;
			} else {
				return 2;
			}
		}
		return 1;
	}

	public int valid(int buttonRow, int buttonCol, int col) {
		int opposite;
		int north = 0, northE = 0, east = 0, southE = 0, south = 0, southW = 0, west = 0, northW = 0;

		// Opposite colour to one being placed.
		if (col == 1) {
			opposite = 2;
		} else {
			opposite = 1;
		}

		// If the square given is empty
		if (main.getBoard()[buttonRow][buttonCol] == 0) {
			// North
			north = northSearch(buttonRow, buttonCol, opposite, col);

			// North East
			northE = northEastSearch(buttonRow, buttonCol, opposite, col);

			// East
			east = eastSearch(buttonRow, buttonCol, opposite, col);

			// South East
			southE = southEastSearch(buttonRow, buttonCol, opposite, col);

			// South
			south = southSearch(buttonRow, buttonCol, opposite, col);

			// South West
			southW = southWestSearch(buttonRow, buttonCol, opposite, col);

			// West
			west = westSearch(buttonRow, buttonCol, opposite, col);

			// North West
			northW = northWestSearch(buttonRow, buttonCol, opposite, col);

			int max = Math.max(north, Math.max(northE,
					Math.max(east, Math.max(southE, Math.max(south, Math.max(southW, Math.max(west, northW)))))));

			if (max == 0) {
				return -1;
			} else if (north == max) {
				return 0;
			} else if (northE == max) {
				return 1;
			} else if (east == max) {
				return 2;
			} else if (southE == max) {
				return 3;
			} else if (south == max) {
				return 4;
			} else if (southW == max) {
				return 5;
			} else if (west == max) {
				return 6;
			} else if (northW == max) {
				return 7;
			} else {
				return -1;
			}
		}
		return -1;
	}

	void regenerateBoard() {
		Reversi main = new Reversi();
		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				main.getBoard()[x][y] = 0;
			}
		}
		main.getBoard()[3][3] = 1;
		main.getBoard()[4][3] = 2;
		main.getBoard()[4][4] = 1;
		main.getBoard()[3][4] = 2;
		main.setTurn(1);
	}

	private void generateWhite(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel, int x,
			int y) {
		if (main.getBoard()[x][y] == 0) {
			whiteBoardButtons[x][y] = new BoardButton(1, 1, backgroundGreen, 1, borderColour);
			whiteBoardButtons[x][y].setName("" + x + y);
			whiteBoardButtons[x][y].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// If it's white turn
					if (main.getTurn() == 1) {
						// Get the pressed button and the index of it
						BoardButton button = (BoardButton) e.getSource();
						String buttonRowStr = button.getName().substring(0, 1);
						String buttonColStr = button.getName().substring(1, 2);
						int buttonRow = Integer.parseInt(buttonRowStr);
						int buttonCol = Integer.parseInt(buttonColStr);
						int spacesRemaining = 0, whiteSpaces = 0, blackSpaces = 0;

						if (valid(buttonRow, buttonCol, 1) == -1) {

						} else {
							int direction = valid(buttonRow, buttonCol, 1);
							if (direction == 0) {
								paintNorth(buttonRow, buttonCol, 2, 1);
							} else if (direction == 1) {
								paintNorthEast(buttonRow, buttonCol, 2, 1);
							} else if (direction == 2) {
								paintEast(buttonRow, buttonCol, 2, 1);
							} else if (direction == 3) {
								paintSouthEast(buttonRow, buttonCol, 2, 1);
							} else if (direction == 4) {
								paintSouth(buttonRow, buttonCol, 2, 1);
							} else if (direction == 5) {
								paintSouthWest(buttonRow, buttonCol, 2, 1);
							} else if (direction == 6) {
								paintWest(buttonRow, buttonCol, 2, 1);
							} else if (direction == 7) {
								paintNorthWest(buttonRow, buttonCol, 2, 1);
							}
							if (movePossible(2) == 2) {
								main.setTurn(2);
								GUI.setBlackStatus(GUI.blackTurn);
								GUI.setWhiteStatus(GUI.whiteWait);
							}
						}

						for (int x = 0; x <= 7; x++) {
							for (int y = 0; y <= 7; y++) {
								if (main.getBoard()[x][y] == 0) {
									spacesRemaining++;
								} else if (main.getBoard()[x][y] == 1) {
									whiteSpaces++;
								} else if (main.getBoard()[x][y] == 2) {
									blackSpaces++;
								}
							}
						}
						if (spacesRemaining == 0) {
							if (blackSpaces > whiteSpaces) {
								JOptionPane.showMessageDialog(null, "Black Wins: " + whiteSpaces + ":" + blackSpaces);

							} else if (whiteSpaces > blackSpaces) {
								JOptionPane.showMessageDialog(null, "White Wins: " + whiteSpaces + ":" + blackSpaces);
							} else {
								JOptionPane.showMessageDialog(null, "Draw: " + whiteSpaces + ":" + blackSpaces);
							}
							regenerateBoard();
						}
						repaint(blackframe, whiteframe, whitepanel, blackpanel);
					}
				}
			});
			whitepanel.add(whiteBoardButtons[x][y]);
		} else if (main.getBoard()[x][y] == 1) {
			WhiteButton wbutton = new WhiteButton(1, 1, Color.white, 1, borderColour);
			whitepanel.add(wbutton);
		} else {
			BlackButton bbutton = new BlackButton(1, 1, Color.black, 1, borderColour);
			whitepanel.add(bbutton);
		}
	}

	private void generateBlack(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel, int x,
			int y) {
		if (main.getBoard()[x][y] == 0) {
			blackBoardButtons[x][y] = new BoardButton(1, 1, backgroundGreen, 1, borderColour);
			blackBoardButtons[x][y].setName("" + x + y);
			blackBoardButtons[x][y].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (main.getTurn() == 2) {
						BoardButton button = (BoardButton) e.getSource();
						String buttonRowStr = button.getName().substring(0, 1);
						String buttonColStr = button.getName().substring(1, 2);
						int buttonRow = Integer.parseInt(buttonRowStr);
						int buttonCol = Integer.parseInt(buttonColStr);
						int spacesRemaining = 0, whiteSpaces = 0, blackSpaces = 0;

						if (valid(buttonRow, buttonCol, 2) == -1) {

						} else {
							int direction = valid(buttonRow, buttonCol, 2);
							if (direction == 0) {
								paintNorth(buttonRow, buttonCol, 1, 2);
							} else if (direction == 1) {
								paintNorthEast(buttonRow, buttonCol, 1, 2);
							} else if (direction == 2) {
								paintEast(buttonRow, buttonCol, 1, 2);
							} else if (direction == 3) {
								paintSouthEast(buttonRow, buttonCol, 1, 2);
							} else if (direction == 4) {
								paintSouth(buttonRow, buttonCol, 1, 2);
							} else if (direction == 5) {
								paintSouthWest(buttonRow, buttonCol, 1, 2);
							} else if (direction == 6) {
								paintWest(buttonRow, buttonCol, 1, 2);
							} else if (direction == 7) {
								paintNorthWest(buttonRow, buttonCol, 1, 2);
							}
							if (movePossible(1) == 2) {
								main.setTurn(1);
								GUI.setBlackStatus(GUI.blackWait);
								GUI.setWhiteStatus(GUI.whiteTurn);
							}
						}
						for (int x = 0; x <= 7; x++) {
							for (int y = 0; y <= 7; y++) {
								if (main.getBoard()[x][y] == 0) {
									spacesRemaining++;
								} else if (main.getBoard()[x][y] == 1) {
									whiteSpaces++;
								} else if (main.getBoard()[x][y] == 2) {
									blackSpaces++;
								}
							}
						}
						if (spacesRemaining == 0) {
							if (blackSpaces > whiteSpaces) {
								JOptionPane.showMessageDialog(null, "Black Wins: " + whiteSpaces + ":" + blackSpaces);
							} else if (whiteSpaces > blackSpaces) {
								JOptionPane.showMessageDialog(null, "White Wins: " + whiteSpaces + ":" + blackSpaces);
							} else {
								JOptionPane.showMessageDialog(null, "Draw: " + whiteSpaces + ":" + blackSpaces);
							}
							regenerateBoard();
						}
						repaint(blackframe, whiteframe, whitepanel, blackpanel);
					}
				}
			});
			blackpanel.add(blackBoardButtons[x][y]);
		} else if (main.getBoard()[x][y] == 1) {
			WhiteButton wbutton = new WhiteButton(1, 1, Color.white, 1, borderColour);
			blackpanel.add(wbutton);
		} else {
			BlackButton bbutton = new BlackButton(1, 1, Color.black, 1, borderColour);
			blackpanel.add(bbutton);
		}
	}

	public void repaint(JFrame blackframe, JFrame whiteframe, JPanel whitepanel, JPanel blackpanel) {
		whitepanel.removeAll();
		blackpanel.removeAll();
		generateBoardSquares(whiteframe, blackframe, whitepanel, blackpanel);
		blackpanel.revalidate();
		whitepanel.revalidate();
		blackpanel.repaint();
		whitepanel.repaint();
	}
}