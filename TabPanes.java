import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPanes {
	
	JTabbedPane jtp;
	JPanel jp1;
	
	public TabPanes() {
		jtp = new JTabbedPane();
		jp1 = new JPanel();
		jtp.add("tab1", jp1);
	}
	
	public JTabbedPane returnsTabbedPane(){
		return jtp;	
	}

}
