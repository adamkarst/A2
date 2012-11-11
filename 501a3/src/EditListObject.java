import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class EditListObject extends JFrame {
	private static ObjectToAdd myObject;
	private static final String[] primativeList = {"char","byte","short","int","long", "float","double","boolean","void"};
	private static DefaultListModel preExistingObj;
	private static DefaultListModel fieldList;
	private static DefaultListModel fieldValueList;
	private static JList<String> fieldType = new JList<String>();
	private static JList<String> valueList = new JList<String>();
	private static Container thePane;
	private static JPanel theBottom;
	private static JTextField textFieldValue;
	private static int counter = 0;
	private static int MAX_OBJ;
	private static JPanel fieldValuePanel;
	
	public EditListObject(ObjectToAdd obj,DefaultListModel list, String name) {
		super(name);
		preExistingObj = list;

        fieldList = new DefaultListModel<String>();
        fieldValueList = new DefaultListModel<String>();
		myObject = obj;
		Container windowPane = getContentPane();
		thePane = windowPane;
		JPanel returnPanel = new JPanel();
		if (myObject.getType()==4) {
	
			returnPanel = giveArraylength();
		}
		
	    windowPane.setLayout(new GridLayout(2,1));
		windowPane.add(returnPanel);
		JPanel displayPanel = displayPanel();
		windowPane.add(displayPanel);
		windowPane.setVisible(true);

        //Display the window.
        pack();
        setVisible(true);
        
	}
	@SuppressWarnings("unchecked")
	private static JPanel giveArraylength() 
	{
		final JPanel displayPanel = new JPanel(new GridLayout(2,2));

		final JLabel label = new JLabel();
		final JTextField theField = new JTextField();
		JButton theButton = new JButton("Set Array Length");
		theButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myObject.addArray(Integer.parseInt(theField.getText()));
				MAX_OBJ = myObject.getObjectArrayLength();
			}		
		});
		
		for(int i =0;i < myObject.field.size();i++) {
			fieldList.addElement(myObject.getFromListAt(i));
			String valueString = "Double Click here to Edit";
			fieldValueList.addElement(valueString);
		}
		
		JPanel additionPanel = new JPanel(new GridLayout(1,1));
		
		JButton addFieldButton = new JButton("Add Field");
		addFieldButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					ObjectToAdd newObjectToAdd = new ObjectToAdd(1);
					fieldList.addElement(newObjectToAdd);
					myObject.addToList(newObjectToAdd);
					String valueString = "Double Click here to Edit";
					fieldValueList.addElement(valueString);
					counter++;
				
			}
		});
		additionPanel.add(addFieldButton);
		
		displayPanel.add(additionPanel);
		
		
		return displayPanel;
	}
	
	private static JPanel displayPanel() {
		JPanel bottomPanel = new JPanel(new GridLayout(1,2));
		fieldType = new JList(fieldList);
		valueList = new JList(fieldValueList);
		
		valueList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	ObjectToAdd theObj = (ObjectToAdd) fieldList.get(valueList.locationToIndex(evt.getPoint()));
		    	JFrame editClickedObject;
		        if (evt.getClickCount() == 2) {
		        	if (theObj.getType() == 1) {
		        		editClickedObject = new EditSubEObject(theObj, fieldList, "Editing SubObject" + theObj.toString());
		        	
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
		bottomPanel.add(fieldType);
		bottomPanel.add(valueList);
		return bottomPanel;
		
	}
}
