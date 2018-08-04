import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class FileMenuBar extends JPanel implements ActionListener{

	private JFileChooser fileChooser;
	private JMenuBar topBar;
	private JMenu file, edit, tools, shapes;
	private JMenuItem exit, open, save, copy, crop;


	public FileMenuBar(){

		fileChooser = new JFileChooser();		
		topBar = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");
		tools = new JMenu("Tools");
		shapes = new JMenu("Shapes");

		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		copy = new JMenuItem("Copy");
		crop = new JMenuItem("Crop");


		exit.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);

		file.add(open);
		file.add(save);
		file.add(exit);

		tools.add(copy);
		tools.add(crop);


		topBar.add(file);
		topBar.add(edit);
		topBar.add(tools);
		topBar.add(shapes);
		topBar.setPreferredSize(new Dimension(1000, 25));
		topBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.setLayout(new BorderLayout());
		this.add(topBar,BorderLayout.PAGE_START);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));



	}

	// return JPanel to be added to the mainGui Window
	public JPanel returnMenuBarPanel() {
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(exit)){
			System.exit(0);
		}
		else if(e.getSource().equals(open)){
			fileChooser.showOpenDialog(open);

		}
		else if (e.getSource().equals(save)){

		}

	}







}
