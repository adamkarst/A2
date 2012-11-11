import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;


public class EditSubEObject extends JFrame {

	private static ObjectToAdd myObject;
	private static final String[] primativeList = {"char","byte","short","int","long", "float","double","boolean","void"};
	private static JList<String> fieldType = new JList<String>();
	private static JList<String> valueList = new JList<String>();
	private static DefaultListModel<String> valueModel;
	@SuppressWarnings("rawtypes")
	private static DefaultListModel fieldList;
	private static JPanel fieldValuePanel;

	@SuppressWarnings("rawtypes")
	private static DefaultListModel fieldValueList;
	private static DefaultListModel preExistingObj;
	private static JTextField textFieldValue;
	
	public EditSubEObject(ObjectToAdd object,DefaultListModel listofAlreadyMade, String name) {
		super(name);
		preExistingObj = listofAlreadyMade;
		
		myObject = object;
		Container windowPane = getContentPane();
		
        fieldList = new DefaultListModel<String>();
        valueModel = new DefaultListModel<String>();

        JPanel returnPanel = new JPanel();
		if (myObject.getType()==1) {
	
			returnPanel = multiObjectPanel();
		}
		
		windowPane.add(returnPanel);
        windowPane.setVisible(true);
        //Display the window.
        pack();
        setVisible(true);
        
	}
	
	private static JPanel multiObjectPanel() {
		
		JPanel bodyPanel = new JPanel(new GridLayout(2,1));
		JPanel additionPanel = new JPanel(new GridLayout(3,3));
		fieldValuePanel = new JPanel(new GridLayout(1,2));
		final JLabel addFieldLabel = new JLabel("Create New field of type:");
		
		
		Vector<String> v = new Vector<String>();
		if(myObject.getType() == 1) {
			v.add("New Object Primitives");
			final JComboBox<String> combo = new JComboBox<String>(v);
			
			additionPanel.add(addFieldLabel);
			
			additionPanel.add(new javax.swing.Box(0));
			additionPanel.add(new javax.swing.Box(0));
			additionPanel.add(new javax.swing.Box(0));
		
			additionPanel.add(combo);
			additionPanel.add(new javax.swing.Box(0));
			JButton addButton = new JButton("Add new Field");
			additionPanel.add(addButton);
			additionPanel.add(new javax.swing.Box(0));
			final JComboBox objectCombo = new JComboBox(preExistingObj.toArray());
			additionPanel.add(objectCombo);
			additionPanel.add(new javax.swing.Box(0));
			JButton addExistingButton = new JButton("Add Existing Object");
			additionPanel.add(addExistingButton);
			additionPanel.add(new javax.swing.Box(0));
			// add addition panel to the body
			bodyPanel.add(additionPanel);
			
			
			for(int i =0;i < myObject.field.size();i++) {
				fieldList.addElement(myObject.field.elementAt(i));
				String valueString = "Double Click here to Edit";
				valueModel.addElement(valueString);
			}
			// setup the bottom panel
			
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						ObjectToAdd newObjectToAdd = new ObjectToAdd(0);
						preExistingObj.addElement(newObjectToAdd);
						fieldList.addElement(newObjectToAdd);
						myObject.addField(newObjectToAdd);
						String valueString = "Double Click here to Edit";
						valueModel.addElement(valueString);
							
					}catch (WrongTypeException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			});
			
			addExistingButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						ObjectToAdd newObjectToAdd = (ObjectToAdd) preExistingObj.get(objectCombo.getSelectedIndex());
						fieldList.addElement(newObjectToAdd);
						myObject.addField(newObjectToAdd);
						String valueString = "Double Click here to Edit";
						valueModel.addElement(valueString);
							
					}catch (WrongTypeException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		fieldType = new JList (fieldList);
		valueList = new JList (valueModel);
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
		fieldValuePanel.add(fieldType);
		fieldValuePanel.add(valueList);
		
		//add other panel to the body
		bodyPanel.add(fieldValuePanel);
		return bodyPanel;
		
	}
}
