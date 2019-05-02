package engine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Launcher {
	private static JFrame frame;
	private static Scoreboard sb;

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

}
