import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ObjectCreatorAppOpen{
	private static JLabel openingFrameLabel;
	private static JFrame windowPane;
	private static JList<ObjectToAdd> objectArea;
	private static DefaultListModel<ObjectToAdd> objectList;
	private static JComboBox<String> comboBox;
	
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
		JPanel displayFrame = new JPanel(new GridLayout(1,3,30,10));
		panel2.setLayout(new GridLayout(4,1,25,25));
		JLabel selectLabel = new JLabel("Please select an object to add from the list below");
		panel2.add(selectLabel);
		Vector<String> v = new Vector<String>();
		v.add("Object - (primitives only)");
		v.add("Object - (obj references)");
		v.add("Object - Primitive's Array");
		v.add("Object - Object Array");
		v.add("List - Object List");
		comboBox = new JComboBox<String>(v);
		panel2.add(comboBox);
		JButton createObjButton = new JButton("Create");
		createObjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createObjCreateButtonClickEvent(evt);
			}
		});
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createBackButtonClickEvent(evt);
			}
		});
		panel2.add(createObjButton);
		panel2.add(backButton);
		displayFrame.add(panel2);
		objectList = new DefaultListModel<ObjectToAdd>();
		objectArea = new JList<ObjectToAdd>(objectList);
		objectArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		objectArea.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	ObjectToAdd theObj = (ObjectToAdd) objectList.get(objectArea.locationToIndex(evt.getPoint()));
		    	JFrame editClickedObject;
		        if (evt.getClickCount() == 2) {
		        	if (theObj.getType() == 4) {
		        		editClickedObject = new EditListObject(theObj, objectList, "Editing SubObject" + theObj.toString());
		        	}
		        	else if (theObj.getType() == 3) {
		        		editClickedObject = new EditObjectArray(theObj, objectList, "Editing SubObject" + theObj.toString());
		        	}
		        	else if (theObj.getType() == 2) {
		        		editClickedObject = new EditPrimativeArray(theObj, objectList, "Editing SubObject" + theObj.toString());
		        	}
		        	else if (theObj.getType() == 1) {
		        		editClickedObject = new EditSubEObject(theObj, objectList, "Editing SubObject" + theObj.toString());
		        	
		        	}
		        	else{
		        		editClickedObject = new EditObjectWindow(theObj, "Editing SubObject" + theObj.toString());
		        	}
		        		 editClickedObject.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	
		            //Display the window.
		            editClickedObject.pack();
		            editClickedObject.setVisible(true);
		            
		        } else if (evt.getClickCount() == 3) {   // Triple-click

		        }
		    }
		});

		JPanel editPanel = new JPanel(new GridLayout(6,2));
		JButton editButton = new JButton("Edit Object");
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButtonClickEvent(e);
			}
		});
		
		JButton removeButton = new JButton("Remove Object");
		
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objectList.removeElementAt(objectArea.getSelectedIndex());
			}
		});
		
		editPanel.add(editButton);
		editPanel.add(new javax.swing.Box(0));
		editPanel.add(removeButton);
		editPanel.add(new javax.swing.Box(0));
		editPanel.add(new javax.swing.Box(0));
		editPanel.add(new javax.swing.Box(0));
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendButtonClickEvent(e);
			}
		});
		
		editPanel.add(sendButton);

		editPanel.add(new javax.swing.Box(0));
		JButton printButton = new JButton("Print");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintButtonClickEvent(e);
			}
		});
		editPanel.add(printButton);

		editPanel.add(new javax.swing.Box(0));
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveButtonClickEvent(e);
			}
		});
		
		editPanel.add(saveButton);
		displayFrame.add(objectArea);
		displayFrame.add(editPanel);
		pane.add(displayFrame);
		
	}
	
	private static void createBackButtonClickEvent(ActionEvent evt) {

		windowPane.dispose();
		windowPane = new JFrame();
       
		windowPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        setOpeningFrame(windowPane.getContentPane());
 
        //Display the window.
        windowPane.pack();
        windowPane.setVisible(true);
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
	
	private static void createObjCreateButtonClickEvent(ActionEvent evt) {
		ObjectToAdd newObj = new ObjectToAdd(comboBox.getSelectedIndex());
		objectList.addElement(newObj);
	}
	
	private static void SendButtonClickEvent(ActionEvent evt) {
		
	}
	private static void PrintButtonClickEvent(ActionEvent evt) {
		
	}
	private static void SaveButtonClickEvent(ActionEvent evt) {
		
	}
	
	private static void editButtonClickEvent(ActionEvent evt) {
		
		ObjectToAdd objectTBEdited = objectList.getElementAt(objectArea.getSelectedIndex());
		if (objectTBEdited.getType() == 0) {
			JFrame fieldWindow = new EditObjectWindow(objectTBEdited,"Edit Fields for " + objectTBEdited);
			
			fieldWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	        //Display the window.
	        fieldWindow.pack();
	        fieldWindow.setVisible(true);
		}
		else if(objectTBEdited.getType() == 1) {
			JFrame fieldWindow = new EditSubEObject(objectTBEdited,objectList,"Edit Fields for 2" + objectTBEdited);
			
			fieldWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	        //Display the window.
	        fieldWindow.pack();
	        fieldWindow.setVisible(true);
		
		}
		else if(objectTBEdited.getType() == 2) {
			JFrame fieldWindow = new EditPrimativeArray(objectTBEdited,objectList,"Edit Fields for " + objectTBEdited);
			
			fieldWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	        //Display the window.
	        fieldWindow.pack();
	        fieldWindow.setVisible(true);
		
		}
		else if(objectTBEdited.getType() == 3) {
			JFrame fieldWindow = new EditObjectArray(objectTBEdited,objectList,"Edit Fields for 3 " + objectTBEdited);
			
			fieldWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	        //Display the window.
	        fieldWindow.pack();
	        fieldWindow.setVisible(true);
		
		}
		else if(objectTBEdited.getType() == 4) {
			JFrame fieldWindow = new EditListObject(objectTBEdited,objectList,"Edit Fields for 3 " + objectTBEdited);
			
			fieldWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	        //Display the window.
	        fieldWindow.pack();
	        fieldWindow.setVisible(true);
		
		}
		
	}

	
	
}
