import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectReceiveWindow extends JFrame{
	
	private static JLabel openingFrameLabel;
	private static JFrame windowPane;
	
	public ObjectReceiveWindow(String name) {
		super(name);
		setResizable(false);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	private static void createAndShowGUI() {
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
		
		panel2.add(createButton);
		panel2.add(new javax.swing.Box(0));
		JButton receiveButton = new JButton("Recieve and Show Objects");
		
		panel2.add(receiveButton);
		
		pane.add(panel2, BorderLayout.SOUTH);
	}
}
