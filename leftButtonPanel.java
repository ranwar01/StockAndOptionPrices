import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class leftButtonPanel extends JPanel implements ActionListener {
	
	public final static String [] stockNames = {"amd","snap","fcx", "aapl", "intc"};
	private JButton []buttons;
	
	public leftButtonPanel (){
		buttons = new JButton[5];
		createButtons();
		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(200,900));
//		this.setBackground(new Color(248,248,255));
		this.setVisible(true);
		this.setOpaque(true);
	}

	public void createButtons(){
		
		for (int i=0; i< 5; i++){
			buttons[i] = new JButton(stockNames[i]);
		    this.add(buttons[i]);
		    buttons[i].setOpaque(true);
		    buttons[i].addActionListener(this);
//		    buttons[i].setBackground(Color.BLUE);

		}

}


	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource().equals(buttons[0])){
//			Drawing.setCurrentShape("Line");			
		}
		else if (e.getSource().equals(buttons[1])){
	
		}
		else if (e.getSource().equals(buttons[2])){
	    }
		else if (e.getSource().equals(buttons[3])){
	
		}
		else if (e.getSource().equals(buttons[4])){
	
	    }
		
	}
}
