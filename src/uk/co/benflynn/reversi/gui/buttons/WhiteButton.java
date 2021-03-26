package uk.co.benflynn.reversi.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;


public class WhiteButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	Color borderColor;
	Color buttonColor;
	int borderSize;
	
	public WhiteButton(int width, int height, Color color, int borderWidth, Color borderCol) {
		setMinimumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		setBorderPainted(false);
		borderSize = borderWidth;
		buttonColor = color;
		borderColor = borderCol;
	}
	

	protected void paintComponent(Graphics graphics) {
		if (borderColor != null) {
			graphics.setColor(borderColor);
			graphics.fillRect(0, 0, getWidth(), getHeight());
		}
		if (buttonColor != null) {
			graphics.setColor(new Color(0, 255, 0));
			graphics.fillRect( borderSize, borderSize,
				getWidth()-borderSize*2,
				getHeight()-borderSize*2 );
			graphics.setColor(Color.WHITE);
			graphics.fillOval(5, 3, 50, 50);
			graphics.setColor(Color.BLACK);
			graphics.drawOval(4, 2, 51, 51);
		}
	}

}
