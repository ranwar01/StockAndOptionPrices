import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

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
	JLabel [] textFields;
	private GetStockPrice gsp;
	TabPanes tp;
	FileMenuBar fileMenuBar;
	
	
	public MainGuiWindow(GetStockPrice gsp){
		

		this.setSize(width, height);
		this.setTitle("Stock And Options Visualization");
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gsp = gsp;
		fileMenuBar = new FileMenuBar();
		menuBarPanel();
		centerBarPanel();
		leftPanel = new leftButtonPanel(gsp, this);
		tp = new TabPanes();
//		this.add(tp.returnsTabbedPane(), BorderLayout.PAGE_START);
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(menuBarPanel, BorderLayout.PAGE_START);
		this.add(centerBarPanel, BorderLayout.CENTER);
		this.setVisible(true);
				
	}
	
	public void menuBarPanel(){
		
		menuBarPanel = new JPanel();
		menuBarPanel.setSize(1000, 25);
		menuBarPanel.add(fileMenuBar.returnMenuBarPanel());
	
	}
	
public void centerBarPanel(){
		
		centerBarPanel = new JPanel();
		centerBarPanel.setSize(800,725);
		centerBarPanel.setBackground(Color.WHITE);
		centerBarPanel.setLayout(new GridLayout(20, 4));
		createLabels();
		
		
	}

public void createLabels() {
	displayLabel = new JLabel[gsp.getFields().size()];
	textFields = new JLabel[gsp.getFields().size()];
	for (int i = 0; i < gsp.getFields().size(); i++){
		displayLabel[i] = new JLabel(gsp.getFields().get(i));
		displayLabel[i].setBackground(Color.LIGHT_GRAY);
		displayLabel[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); 
		displayLabel[i].setOpaque(true);
		textFields[i] = new JLabel(gsp.printValues(gsp.getFields().get(i)));
		textFields[i].setBackground(Color.CYAN);
		textFields[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); 
			

		textFields[i].setOpaque(true);
		centerBarPanel.add(displayLabel[i]);
		centerBarPanel.add(textFields[i]);
	}
	
}

public void updateLabels(){
	for (int i = 0; i < gsp.getFields().size(); i++){
		textFields[i].setText(gsp.printValues(gsp.getFields().get(i)));
//		displayLabel[i] = new JLabel(gsp.getFields().get(i));
//		textFields[i] = new JLabel(gsp.printValues(gsp.getFields().get(i)));
//		centerBarPanel.add(displayLabel[i]);
//		centerBarPanel.add(textFields[i]);
	}
	
}


		
//		JPanel rightPanel = new JPanel();
//		rightPanel.setSize(200, 350);
//		rightPanel.setBackground(Color.orange);
//		leftPanel.add(rightPanel,BorderLayout.LINE_END);
//		leftPanel.setLayout(BorderLayout.WEST);
		

		
	}

