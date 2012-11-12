import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import javax.swing.*;

import Networking.Client;

public class ReceiveWindow extends JFrame {
	private static Client theClient;
	private static String theLocation = "C:\\Users\\Alpha1\\";
	private static String theServerIP = "10.0.1.54";
	private static int thePort = 1236;
	private final static JLabel receiveLabel = new JLabel();
	final static JTextField theDestinationTextField = new JTextField();
	final static JTextField theHostIPTextField = new JTextField();
	final static JTextField thePortTextField = new JTextField();
	static JButton setDestinationButton = new JButton("Set Save Location");
	static JButton setHostIPButton = new JButton("Set ServerIP");
	static JButton setPortButton = new JButton("Set Port");
	final static JLabel locationConfirm = new JLabel();
	final static JLabel serverIPConfirm = new JLabel();
	final static JLabel portLabel = new JLabel();

	private final static JButton receiveButton = new JButton("Receive");
	
	public ReceiveWindow(String Name) {
		super(Name);
		Container windowPane = getContentPane();
		
		JPanel returnPanel = setupReceivePanel();
		JPanel bodyPanel = new JPanel(new GridLayout(1,2));
		JPanel receivePanel = new JPanel(new GridLayout(2,2));
		receiveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receiveButtonClickEvent(e);
				
			}
		});
		
		setHostIPButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setHostIPClick(e);
				
			}
		});
		
		receivePanel.add(receiveButton);
		receivePanel.add(receiveLabel);
		
		bodyPanel.add(returnPanel,BorderLayout.NORTH);
		bodyPanel.add(receivePanel, BorderLayout.SOUTH);
		
	    windowPane.setLayout(new GridLayout(2,1));
	    
		windowPane.add(bodyPanel);
		

		windowPane.setVisible(true);

        //Display the window.
        pack();
        setVisible(true);
	}
	
	private static JPanel setupReceivePanel() {
		
		JPanel leftPanel = new JPanel(new GridLayout(4,3));
		
		
		setDestinationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				File f = new File(theDestinationTextField.getText());
				if (f.isDirectory() || f.isFile()) {
					theLocation = theDestinationTextField.getText();
					locationConfirm.setText("Success");
				}
				else {
					locationConfirm.setText("No Success");
				}
			}
		});
		
		setHostIPButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (InetAddress.getByName(theHostIPTextField.getText()).isReachable(2000)) {
						serverIPConfirm.setText("IP set to: " + theHostIPTextField.getText());
						theServerIP = theHostIPTextField.getText();
					}
					else {
						serverIPConfirm.setText("IP not available");
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		setPortButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String thePort1 = thePortTextField.getText();
				try {
					int thePortInt = Integer.parseInt(thePort1);
					thePort = thePortInt;

					portLabel.setText("Success");
					
				} catch (Exception e1) {
					thePort = -1;
					portLabel.setText("Not an integer");
				}
			
				
			}
		});
		leftPanel.add(new JLabel("Please set the following:"));

		leftPanel.add(new javax.swing.Box(0));
		leftPanel.add(new javax.swing.Box(0));
		leftPanel.add(theDestinationTextField);
		leftPanel.add(setDestinationButton);
		leftPanel.add(locationConfirm);
		leftPanel.add(theHostIPTextField);
		leftPanel.add(setHostIPButton);
		leftPanel.add(serverIPConfirm);
		leftPanel.add(thePortTextField);
		leftPanel.add(setPortButton);
		leftPanel.add(portLabel);
		leftPanel.setSize(400,300);
		return leftPanel;
	}
	
	private static void receiveButtonClickEvent(ActionEvent e) {
		if (theLocation == "" || theServerIP == "" || thePort == -1) {
			receiveLabel.setText("Please set all the fields");
		}
		else {
			receiveLabel.setText(theLocation + " " + theServerIP + " " + thePort);
			theClient = new Client(thePort, theServerIP);
			try {
				theClient.receiveFile(theLocation + "\\sendFileXML.xml");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}

	private static void setHostIPClick(ActionEvent e) {
				theServerIP = theHostIPTextField.getText();
			
	}
}
