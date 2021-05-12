package uk.co.benflynn.reversi.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uk.co.benflynn.reversi.Reversi;
import uk.co.benflynn.reversi.gui.buttons.BoardButton;

public class GUI {

	private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 550;
	private final Font statusFont = new Font("Arial", Font.BOLD, 20);
	private final Font aiFont = new Font("Arial", Font.BOLD, 15);
	public static final String whiteTurn = "White player - click square to play.";
	public static final String blackTurn = "Black player - click square to play.";
	public static final String whiteWait = "White player - wait for black's move.";
	public static final String blackWait = "Black player - wait for white's move.";

	public JFrame blackFrame, whiteFrame;
	private JPanel blackBoardPanel = new JPanel(new GridLayout(8, 8)),
			whiteBoardPanel = new JPanel(new GridLayout(8, 8));
	public static JLabel blackStatus = new JLabel(blackWait, SwingConstants.CENTER),
			whiteStatus = new JLabel(whiteTurn, SwingConstants.CENTER);

	private JButton whiteAI = new JButton("Greedy AI (play white)"), blackAI = new JButton("Greedy AI (play black)");

	public BoardButton[] whiteBoardButtons, blackBoardButtons;

	private Reversi reversi = new Reversi();

	public void createFrame() {
		blackFrame = setupFrame(blackFrame);
		whiteFrame = setupFrame(whiteFrame);
		blackFrame.setTitle("Reversi - black player");
		whiteFrame.setTitle("Reversi - white player");

		// Weird positioning but that's okay
		blackFrame.setLocation(1000, 200);
		whiteFrame.setLocation(300, 200);

		blackBoardPanel.setName("black");
		whiteBoardPanel.setName("white");

		GenerateBoard generateBoard = new GenerateBoard();
		generateBoard.generateBoardSquares(whiteFrame, blackFrame, whiteBoardPanel, blackBoardPanel);

		blackStatus.setFont(statusFont);
		whiteStatus.setFont(statusFont);

		blackAI.setFont(aiFont);
		blackAI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (reversi.getTurn() == 2) {
					int max = 0, bestx = 0, besty = 0;
					int spacesRemaining = 0, whiteSpaces = 0, blackSpaces = 0;
					for (int x = 0; x <= 7; x++) {
						for (int y = 0; y <= 7; y++) {
							int turn = generateBoard.valid(x, y, 2);
							if (turn > max) {
								max = turn;
								bestx = x;
								besty = y;
							}
						}
					}
					if (generateBoard.valid(bestx, besty, 2) == -1) {

					} else {
						if (max == 0) {
							generateBoard.paintNorth(bestx, besty, 1, 2);
						} else if (max == 1) {
							generateBoard.paintNorthEast(bestx, besty, 1, 2);
						} else if (max == 2) {
							generateBoard.paintEast(bestx, besty, 1, 2);
						} else if (max == 3) {
							generateBoard.paintSouthEast(bestx, besty, 1, 2);
						} else if (max == 4) {
							generateBoard.paintSouth(bestx, besty, 1, 2);
						} else if (max == 5) {
							generateBoard.paintSouthWest(bestx, besty, 1, 2);
						} else if (max == 6) {
							generateBoard.paintWest(bestx, besty, 1, 2);
						} else if (max == 7) {
							generateBoard.paintNorthWest(bestx, besty, 1, 2);
						}
						generateBoard.repaint(blackFrame, whiteFrame, whiteBoardPanel, blackBoardPanel);
						if (generateBoard.movePossible(1) == 2) {
							reversi.setTurn(1);
							setBlackStatus(blackWait);
							setWhiteStatus(whiteTurn);
						}
					}
					for (int x = 0; x <= 7; x++) {
						for (int y = 0; y <= 7; y++) {
							if (reversi.getBoard()[x][y] == 0) {
								spacesRemaining++;
							} else if (reversi.getBoard()[x][y] == 1) {
								whiteSpaces++;
							} else if (reversi.getBoard()[x][y] == 2) {
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
						generateBoard.regenerateBoard();
					}
				}
			}
		});
		whiteAI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (reversi.getTurn() == 1) {
					int max = 0, bestx = 0, besty = 0;
					int spacesRemaining = 0, whiteSpaces = 0, blackSpaces = 0;
					for (int x = 0; x <= 7; x++) {
						for (int y = 0; y <= 7; y++) {
							int turn = generateBoard.valid(x, y, 1);
							if (turn > max) {
								max = turn;
								bestx = x;
								besty = y;
							}
						}
					}
					if (generateBoard.valid(bestx, besty, 1) == -1) {

					} else {
						if (max == 0) {
							generateBoard.paintNorth(bestx, besty, 2, 1);
						} else if (max == 1) {
							generateBoard.paintNorthEast(bestx, besty, 2, 1);
						} else if (max == 2) {
							generateBoard.paintEast(bestx, besty, 2, 1);
						} else if (max == 3) {
							generateBoard.paintSouthEast(bestx, besty, 2, 1);
						} else if (max == 4) {
							generateBoard.paintSouth(bestx, besty, 2, 1);
						} else if (max == 5) {
							generateBoard.paintSouthWest(bestx, besty, 2, 1);
						} else if (max == 6) {
							generateBoard.paintWest(bestx, besty, 2, 1);
						} else if (max == 7) {
							generateBoard.paintNorthWest(bestx, besty, 2, 1);
						}
						generateBoard.repaint(blackFrame, whiteFrame, whiteBoardPanel, blackBoardPanel);
						if (generateBoard.movePossible(2) == 2) {
							reversi.setTurn(2);
							GUI.setBlackStatus(GUI.blackTurn);
							GUI.setWhiteStatus(GUI.whiteWait);
						}
					}
					for (int x = 0; x <= 7; x++) {
						for (int y = 0; y <= 7; y++) {
							if (reversi.getBoard()[x][y] == 0) {
								spacesRemaining++;
							} else if (reversi.getBoard()[x][y] == 1) {
								whiteSpaces++;
							} else if (reversi.getBoard()[x][y] == 2) {
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
						generateBoard.regenerateBoard();
					}
				}
			}
		});
		whiteAI.setFont(aiFont);

		blackFrame.add(blackStatus, BorderLayout.NORTH);
		blackFrame.add(blackBoardPanel);
		blackFrame.add(blackAI, BorderLayout.SOUTH);

		whiteFrame.add(whiteStatus, BorderLayout.NORTH);
		whiteFrame.add(whiteBoardPanel);
		whiteFrame.add(whiteAI, BorderLayout.SOUTH);
		
		blackFrame.setIconImage(new ImageIcon("res/icon.png").getImage());
		whiteFrame.setIconImage(new ImageIcon("res/icon.png").getImage());
		blackFrame.setVisible(true);
		whiteFrame.setVisible(true);
		reversi.gameState = 1;
	}

	/** Set defaults for frames **/
	private JFrame setupFrame(JFrame frame) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setResizable(false);
		return frame;
	}

	/** Getters/Setters **/
	public void restart() {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 0, 2, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
		reversi.setBoard(board);
		blackFrame.dispose();
		whiteFrame.dispose();
		createFrame();
	}

	public JLabel getBlackStatus() {
		return blackStatus;
	}

	public JLabel getWhiteStatus() {
		return whiteStatus;
	}

	public JPanel getBlackPanel() {
		return blackBoardPanel;
	}

	public JPanel getWhitePanel() {
		return whiteBoardPanel;
	}

	public JFrame getBlackFrame() {
		return blackFrame;
	}

	public JFrame getWhiteFrame() {
		return whiteFrame;
	}

	public static void setBlackStatus(String textBlack) {
		GUI.blackStatus.setText(textBlack);
	}

	public static void setWhiteStatus(String textWhite) {
		GUI.whiteStatus.setText(textWhite);
	}
}
