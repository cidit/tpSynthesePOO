package engine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Launcher {
	
	private static JFrame frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				initJFrame();
				
			}
		});
	}
	
	public static void initJFrame() {
		frame = new JFrame("Space Invader 0.1");
		frame.setSize(512, 512);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static class Panel extends JPanel {
		
		URL invaderURL;
		BufferedImage invaderIMG;
		
		public Panel() throws IOException {
			invaderURL = getClass().getResource("/sprites.monstre1_1.png");
			invaderIMG = ImageIO.read(invaderURL);
		}
	}

}
