import javax.swing.JFrame;

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

}
