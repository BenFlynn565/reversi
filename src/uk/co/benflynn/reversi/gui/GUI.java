package uk.co.benflynn.reversi.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uk.co.benflynn.reversi.Reversi;
import uk.co.benflynn.reversi.gui.buttons.BoardButton;

public class GUI {
	
	private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 550;
	private final Font statusFont = new Font("Arial", Font.BOLD, 20);
	private final Font aiFont = new Font("Arial", Font.BOLD, 15);
	public final String whiteTurn = "White player - click square to play.", blackTurn = "Black player - click square to play.";
	public final String whiteWait = "White player - wait for black's move.", blackWait = "Black player - wait for white's move.";

	public JFrame blackFrame, whiteFrame;
	private JPanel blackBoardPanel = new JPanel(new GridLayout(8, 8)), whiteBoardPanel = new JPanel(new GridLayout(8, 8));
	public JLabel blackStatus = new JLabel(blackWait, SwingConstants.CENTER),
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
		whiteAI.setFont(aiFont);
		
		blackFrame.add(blackStatus, BorderLayout.NORTH);
		blackFrame.add(blackBoardPanel);
		blackFrame.add(blackAI, BorderLayout.SOUTH);
		
		whiteFrame.add(whiteStatus, BorderLayout.NORTH);
		whiteFrame.add(whiteBoardPanel);
		whiteFrame.add(whiteAI, BorderLayout.SOUTH);
		
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
	
	public void setBlackStatus(int status) {
		if(status == 0) {
			blackStatus.setText(blackWait);
		} else {
			blackStatus.setText(blackTurn);
		}
	}
	
	public void setWhiteStatus(int status) {
		if(status == 0) {
			whiteStatus.setText(whiteWait);
		} else {
			whiteStatus.setText(whiteTurn);
		}
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
	
}
