import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.json.JSONException;

public class leftButtonPanel extends JPanel implements ActionListener {
	
	public final static String [] stockNames = {"AMD","SNAP","FCX", "FEYE", "AFSI"};
	private JButton []buttons;
	private GetStockPrice gsp;
	private MainGuiWindow mgw;
	
	
	public leftButtonPanel (GetStockPrice gsp, MainGuiWindow mgw){
		this.gsp = gsp;
		this.mgw = mgw;
		buttons = new JButton[5];
		createButtons();
		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(200,900));
		this.setBackground(new Color(248,248,255));
		this.setVisible(true);
		this.setOpaque(true);
	}

	public void createButtons(){
		
		for (int i=0; i< 5; i++){
			buttons[i] = new JButton(stockNames[i]);
		    this.add(buttons[i]);
		    buttons[i].setOpaque(true);
		    buttons[i].setForeground(Color.LIGHT_GRAY);
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

	}
}
