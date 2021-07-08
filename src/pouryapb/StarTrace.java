package pouryapb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StarTrace extends JFrame {

	private static final long serialVersionUID = 2584922697709085713L;
	private DrawCanvas canvas;
	private Star[] stars = new Star[1000];
	public final static int WIDTH = 1250, HEIGHT = 800;
	
	private class DrawCanvas extends JPanel {
		
		private static final long serialVersionUID = -8334656697618326905L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			setBackground(Color.black);
			
			g.translate(StarTrace.WIDTH / 2, StarTrace.HEIGHT / 2);
			
			for (Star s : stars) {
				s.update();
				s.show(g);
			}
			
			repaint();
		}
	}
	
	public StarTrace() {
		canvas = new DrawCanvas();
		setContentPane(canvas);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setFocusable(true);
		requestFocusInWindow();
		setVisible(true);
		
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Star(new Random().nextInt(WIDTH * 2) - WIDTH, new Random().nextInt(HEIGHT * 2) - HEIGHT, new Random().nextInt(WIDTH));
		}
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new StarTrace();
	         }
	      });
	}

}
