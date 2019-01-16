import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MainGuiWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1000;
	private final int HEIGHT = 750;
	public final String [] displayFields = {"Company Name", "52WeekLow", "52WeekHigh", "Actual Price",
			"Average Volume:", "Industry", "Price Earning Ratio", "Symbol", "Previous Close", "Delayed Price" };

	private LeftButtonPanel leftPanel;
	private JPanel menuBarPanel;
	JPanel centerBarPanel;
	private JLabel [] displayLabel;
	private JLabel [] textFields;
	private GetStockPrice gsp;
	//TabbedPanes design not being used at the moment
	private TabPanes tp;
	private FileMenuBar fileMenuBar;
	
	
	public MainGuiWindow(GetStockPrice gsp){
		
		// Main window size, title
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Stock And Options Visualization "  + GetCurrentDateAndTime.getTimeAndDate());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.gsp = gsp;
		fileMenuBar = new FileMenuBar();
		menuBarPanel();
		centerBarPanel(true);
		// not being used at the moment
		tp = new TabPanes(this);
		
		leftPanel = new LeftButtonPanel(gsp, this);

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
	
public void centerBarPanel(boolean createLabel){
		
		if (createLabel){
		centerBarPanel = new JPanel();
		centerBarPanel.setSize(800,725);
		centerBarPanel.setBackground(Color.WHITE);
		centerBarPanel.setLayout(new GridLayout(20, 4));
		createLabels();
		}
		else {
			System.out.println("specialButtons");
			centerBarPanel.removeAll();
			
			
//			JButton b = new JButton("hellosls");
//			centerBarPanel.add(b);
			
//			centerBarPanel.revalidate();
//			this.remove(centerBarPanel);
//			centerBarPanel = new JPanel();
//			centerBarPanel.setOpaque(true);
//			this.getContentPane().remove(centerBarPanel);
//			centerBarPanel = new JPanel();
//			centerBarPanel.setSize(800,725);
//			centerBarPanel
//			centerBarPanel.setBackground(Color.BLUE);
//			centerBarPanel.setSize(800,725);
//			this.add(centerBarPanel, BorderLayout.CENTER);
//			this.revalidate();
			this.repaint();
//			centerBarPanel.setLayout(new GridLayout(20, 4));
			createLabels();

//			this.add(centerBarPanel);
//			super.paintComponents(g);
		}
		
	}

public void createLabels() {
	displayLabel = new JLabel[gsp.getFields().size()];
	textFields = new JLabel[gsp.getFields().size()];
//	displayLabel = new JLabel[100];
//	textFields = new JLabel[100];
	for (int i = 0; i < gsp.getFields().size(); i++){
		displayLabel[i] = new JLabel(gsp.getFields().get(i));
		displayLabel[i].setBackground(Color.LIGHT_GRAY);
		

		displayLabel[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); 
		displayLabel[i].setOpaque(true);
		textFields[i] = new JLabel(gsp.printValues(gsp.getFields().get(i)));

		textFields[i].setBackground(Color.CYAN);
		if (displayLabel[i].getText().equals("iexRealtimePrice") || displayLabel[i].getText().equals("close") || displayLabel[i].getText().equals("open")
				|| displayLabel[i].getText().equals("high") || displayLabel[i].getText().equals("low") || displayLabel[i].getText().equals("previousClose")){
			displayLabel[i].setBackground(Color.GREEN);
			textFields[i].setBackground(Color.GREEN);
		}
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

public JFrame returningMainFrame() { 
	return this;
}

public JPanel mainJPanel(){
	return centerBarPanel;
}


		

		
	}

