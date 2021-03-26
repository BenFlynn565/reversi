package uk.co.benflynn.reversi.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class BoardButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	Color borderColor;
	Color buttonColor;
	int borderSize;
	
	public BoardButton(int width, int height, Color color, int borderWidth, Color borderCol) {
		setMinimumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		setBorderPainted(false);
		borderSize = borderWidth;
		buttonColor = color;
		borderColor = borderCol;
	}
	
	public BoardButton(int width, int height, Color color) {
		this(width, height, color, 0, null);
	}
	
	protected void paintComponent(Graphics graphics) {
		if (borderColor != null) {
			graphics.setColor(borderColor);
			graphics.fillRect(0, 0, getWidth(), getHeight());
		}
		if (buttonColor != null) {
			graphics.setColor(buttonColor);
			graphics.fillRect( borderSize, borderSize,
				getWidth()-borderSize*2,
				getHeight()-borderSize*2 );
		}

	}
}
