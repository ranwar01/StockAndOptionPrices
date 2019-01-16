import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabPanes implements ChangeListener {
	
	static JTabbedPane jtp;
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	MainGuiWindow mgw;
	
	public TabPanes(MainGuiWindow mgw) {
		this.mgw = mgw;
		jtp = new JTabbedPane();
		
		jp1 = new JPanel();
		JButton jb = new JButton("hlel");
		JButton jb1 = new JButton("jfdkafjl");
		JButton jb2 = new JButton("fdafldsfjl");
	
	
	
		jp2 = new JPanel();
		jp2.add(jb);
		jp2.add(jb1);
		jp2.add(jb2);

		jp3 = new JPanel();

		jtp.add("tab1", jp1);
		jtp.add("tab2", jp2);
		jtp.add("tab3", jp3);
		jtp.addChangeListener(this);
		
	}
	
	public static JTabbedPane returnsTabbedPane(){
		return jtp;	
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		  JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
		    int index = sourceTabbedPane.getSelectedIndex();
		    System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
		    if (index == 1) {
//		    	mgw.remove(mgw.mainJPanel());
//		    	mgw.hide();
		    	mgw.returningMainFrame().add(jp2, BorderLayout.CENTER);
		    }
//		    if (index == 0) {
//		    	mgw.remove(mgw.mainJPanel());
//		    	mgw.returningMainFrame().add(jp1, BorderLayout.CENTER);
//		    }
//		    else {
//		    	mgw.add(mgw.mainJPanel(), BorderLayout.CENTER);
//		    
//		    
//		    }
		    jtp.setVisible(true);
	}

}
