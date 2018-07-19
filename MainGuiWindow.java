import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGuiWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 1000;
	private final int height = 750;
	JPanel leftPanel;
	JPanel menuBarPanel;
	JPanel centerBarPanel;
	
	
	public MainGuiWindow(){
		
//		this.requestFocus();
		this.setSize(width, height);
		this.setTitle("Stock And Options Visualization");
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leftPanel();
		menuBarPanel();
		centerBarPanel();
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(menuBarPanel, BorderLayout.PAGE_START);
		this.add(centerBarPanel, BorderLayout.CENTER);
		this.setVisible(true);
				
	}
	
	public void menuBarPanel(){
		
		menuBarPanel = new JPanel();
		menuBarPanel.setSize(40, 650);
		menuBarPanel.setBackground(Color.BLUE);
		JLabel label = new JLabel("File");
		menuBarPanel.add(label);
		
		
		
	}
public void centerBarPanel(){
		
		centerBarPanel = new JPanel();
		centerBarPanel.setSize(250, 650);
		centerBarPanel.setBackground(Color.PINK);
		JLabel label = new JLabel("jafkfjals");
		centerBarPanel.add(label);
		
		
	}
	
	public void leftPanel(){
		leftPanel = new JPanel();
		leftPanel.setSize(new Dimension(750, 100));
		leftPanel.setBackground(Color.red);
		JLabel label = new JLabel("Quotejljlljljjii");
		leftPanel.add(label);
		
//		JPanel rightPanel = new JPanel();
//		rightPanel.setSize(200, 350);
//		rightPanel.setBackground(Color.orange);
//		leftPanel.add(rightPanel,BorderLayout.LINE_END);
//		leftPanel.setLayout(BorderLayout.WEST);
		

		
	}

}
