import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

// sdfsdfsdf
public class ObjectCreatorWindow extends JFrame{
	private static JLabel openingFrameLabel;
	private static JFrame windowPane;
	
	public ObjectCreatorWindow(String name) {
			super(name);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
		}
	
	public  void createAndShowGUI() {
        //Create and set up the window.
        windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        this.setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
    }
	
	public void setOpeningFrame(Container pane) {
		// The label panel
		final JPanel panel1 = new JPanel(new GridLayout(1,3));
		// insert blank for formatting
		panel1.add(new javax.swing.Box(0));
		// make the label
		openingFrameLabel = new JLabel("Which would you like to do?");
		// format the label
		openingFrameLabel.setFont(new Font("Arial",1,16));
		// add label to layout
		panel1.add(openingFrameLabel);
		// add blank
		panel1.add(new javax.swing.Box(0));
		
		// put the panel into the display /w a separator
		pane.add(panel1,BorderLayout.NORTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		
		// button panel
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		JLabel selectLabel = new JLabel("Please select an object to add from the list below");
		panel2.add(selectLabel);
		panel2.add(new javax.swing.Box(0));
		Vector v = new Vector();
		v.add(1);
		v.add(2);
		JComboBox comboBox = new JComboBox(v);
		panel2.add(comboBox);
		JButton createButton = new JButton("Back");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createButtonClick(evt);
			}
		});
		panel2.add(createButton);
		panel2.add(new javax.swing.Box(0));
		panel2.add(new javax.swing.Box(0));
		
		pane.add(panel2, BorderLayout.SOUTH);
	}
	
	private void createButtonClick(ActionEvent evt) {
		windowPane.dispose();
		windowPane = new ObjectCreatorAppOpen();
        
		windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        this.setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
	}
}
