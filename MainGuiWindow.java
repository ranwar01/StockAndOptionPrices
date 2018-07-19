import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGuiWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 1000;
	private final int height = 750;
	
	
	public MainGuiWindow(){
		
//		this.requestFocus();
		this.setSize(width, height);
		this.setTitle("Stock And Options Visualization");
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
				
	}
	
	public void leftPanel(){
		JPanel leftPanel = new JPanel();
//		leftPanel.setLayout(BorderLayout.WEST);
		
		
	}

}
