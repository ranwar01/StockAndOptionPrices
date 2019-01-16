import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;

public class LeftButtonPanel extends JPanel implements ActionListener {
	
	public final static String [] stockNames = {"AMD","SNAP","FCX", "FEYE", "AFSI", "OCLR", "ACIA", "GE", "MostGained"};
	private JTextField searchField;
	private JButton []buttons;
	private JButton searchButton;
	private JButton specialTestingButton;
	private GetStockPrice gsp;
	private MainGuiWindow mgw;
	
	
	public LeftButtonPanel (GetStockPrice gsp, MainGuiWindow mgw){
		this.gsp = gsp;
		this.mgw = mgw;
		buttons = new JButton[stockNames.length];
		searchField = new JTextField();
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		
		specialTestingButton = new JButton("Special");
		specialTestingButton.addActionListener(this);
		this.add(searchField);
		this.add(searchButton);
	
		createButtons();
		this.add(specialTestingButton);
		this.setLayout(new GridLayout(20, 2));  // left panel layout
		this.setPreferredSize(new Dimension(200,725));
//		this.setBackground(new Color(248,248,255));
//		this.setVisible(true);
//		this.add(TabPanes.returnsTabbedPane());
//		this.setOpaque(true);
	}

	public void createButtons(){
		
		for (int i=0; i< stockNames.length; i++){
			buttons[i] = new JButton(stockNames[i]);
		    this.add(buttons[i]);
		    buttons[i].setOpaque(true);
//		    buttons[i].setForeground(Color.LIGHT_GRAY);
		    buttons[i].addActionListener(this);
//		    buttons[i].setBackground(Color.BLUE);
		}
}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(buttons[0])) {
			gsp.callMyMethod("amd");
			mgw.updateLabels();
		} else if (e.getSource().equals(buttons[1])) {
			gsp.callMyMethod("snap");
			mgw.updateLabels();
		} else if (e.getSource().equals(buttons[2])) {
			gsp.callMyMethod("fcx");
			mgw.updateLabels();
		} else if (e.getSource().equals(buttons[3])) {
			gsp.callMyMethod("feye");
			mgw.updateLabels();
		} else if (e.getSource().equals(buttons[4])) {
			gsp.callMyMethod("afsi");
			mgw.updateLabels();
		} 
		else if (e.getSource().equals(buttons[5])) {
			gsp.callMyMethod("oclr");
			mgw.updateLabels();
		}else if (e.getSource().equals(buttons[6])) {
			gsp.callMyMethod("acia");
			mgw.updateLabels();
		}else if (e.getSource().equals(buttons[7])) {
			gsp.callMyMethod("ge");
			mgw.updateLabels();
		}else if (e.getSource().equals(buttons[8])) {
		
				try {
					gsp.getMostGained();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		

		}else if (e.getSource().equals(searchButton)) {
			gsp.callMyMethod(searchField.getText());
			mgw.updateLabels();

		}else if (e.getSource().equals(specialTestingButton)){
			mgw.centerBarPanel(false);
		}
		

	}
}
