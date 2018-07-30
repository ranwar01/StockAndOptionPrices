import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
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
	public final String [] displayFields = {"Company Name", "52WeekLow", "52WeekHigh", "Actual Price",
			"Average Volume:", "Industry", "Price Earning Ratio", "Symbol", "Previous Close", "Delayed Price" };

	leftButtonPanel leftPanel;
	JPanel menuBarPanel;
	JPanel centerBarPanel;
	JLabel [] displayLabel;
	
	
	public MainGuiWindow(){
		
//		this.requestFocus();
		this.setSize(width, height);
		this.setTitle("Stock And Options Visualization");
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		menuBarPanel();
		centerBarPanel();
		leftPanel = new leftButtonPanel();
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(menuBarPanel, BorderLayout.PAGE_START);
		this.add(centerBarPanel, BorderLayout.CENTER);
		this.setVisible(true);
				
	}
	
	public void menuBarPanel(){
		
		menuBarPanel = new JPanel();
		menuBarPanel.setSize(750, 100);
		menuBarPanel.setBackground(Color.BLUE);
		JLabel label = new JLabel("File");
		menuBarPanel.add(label);
		
		
		
	}
public void centerBarPanel(){
		
		centerBarPanel = new JPanel();
		centerBarPanel.setSize(550, 900);
		centerBarPanel.setBackground(Color.LIGHT_GRAY);
		centerBarPanel.setLayout(new GridLayout(3, 3));
		createLabels();
		
		
	}

public void createLabels(){
	displayLabel = new JLabel[10];
	for (int i = 0; i < 10; i++){
		displayLabel[i] = new JLabel(displayFields[i]);
		centerBarPanel.add(displayLabel[i]);
	}
	
}
	

		
//		JPanel rightPanel = new JPanel();
//		rightPanel.setSize(200, 350);
//		rightPanel.setBackground(Color.orange);
//		leftPanel.add(rightPanel,BorderLayout.LINE_END);
//		leftPanel.setLayout(BorderLayout.WEST);
		

		
	}

