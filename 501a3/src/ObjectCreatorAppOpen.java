import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class ObjectCreatorAppOpen extends JFrame{
	private static JLabel openingFrameLabel;
	private static JFrame windowPane;
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        windowPane = new JFrame("CPSC 501 A3 - Adam Karst - 0");
        
        windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
    }
	
	public static void setOpeningFrame(Container pane) {
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
		panel2.setLayout(new GridLayout(1,3));
		
		JButton createButton = new JButton("Create and Send Objects");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createButtonClick(evt);
			}
		});
		panel2.add(createButton);
		panel2.add(new javax.swing.Box(0));
		JButton receiveButton = new JButton("Recieve and Show Objects");
		receiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				receiveButtonClick(evt);
			}
		});
		panel2.add(receiveButton);
		
		pane.add(panel2, BorderLayout.SOUTH);
	}
    
	private static void createButtonClick(ActionEvent evt) {
		windowPane.dispose();
		windowPane = new JFrame("CPSC 501 A3 - Adam Karst - Create Window");
        
		windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
		setObjectCreatorPane(windowPane.getContentPane());
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
	}
	
	private static void receiveButtonClick(ActionEvent evt) {
		windowPane.dispose();
		windowPane = new ObjectReceiveWindow("CPSC 501 A3 - Adam Karst - Receive Window");
        
		windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
	}
	
    private static void setObjectCreatorPane(Container pane) {
		// The label panel
		final JPanel panel1 = new JPanel(new GridLayout(1,3));
		// insert blank for formatting
		panel1.add(new javax.swing.Box(0));
		// make the label
		openingFrameLabel = new JLabel("Object Creation");
		// format the label
		openingFrameLabel.setFont(new Font("Arial",1,24));
		// add label to layout
		panel1.add(openingFrameLabel);
		// add blank
		panel1.add(new javax.swing.Box(0));
		
		// put the panel into the display /w a separator
		pane.add(panel1,BorderLayout.NORTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		
		// button panel
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1,25,25));
		JLabel selectLabel = new JLabel("Please select an object to add from the list below");
		panel2.add(selectLabel);
		Vector<String> v = new Vector<String>();
		v.add("Objects");
		v.add("More Objects");
		JComboBox<String> comboBox = new JComboBox<String>(v);
		panel2.add(comboBox);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createBackButtonClickEvent(evt);
			}
		});
		panel2.add(backButton);
		pane.add(panel2);
		
	}
	
	private static void createBackButtonClickEvent(ActionEvent evt) {
		windowPane.dispose();
		windowPane = new ObjectCreatorAppOpen();
       
		windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
	}
	
}
