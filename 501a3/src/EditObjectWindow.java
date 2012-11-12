import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class EditObjectWindow extends JFrame {
	
	private static ObjectToAdd myObject;
	private static final String[] primativeList = {"char","byte","short","int","long", "float","double","boolean","void"};
	private static JList<String> fieldType = new JList<String>();
	private static JList<String> valueList = new JList<String>();
	private static DefaultListModel<String> valueModel;
	@SuppressWarnings("rawtypes")
	private static DefaultListModel<String> fieldList;
	private static JPanel fieldValuePanel;

	private static JTextField textFieldValue;
	
	public EditObjectWindow(ObjectToAdd object,String name) {
		super(name);
		myObject = object;
		Container windowPane = getContentPane();
		
        fieldList = new DefaultListModel<String>();
        valueModel = new DefaultListModel<String>();
        if (myObject.getObject() != null) {
        	fieldList.addElement(myObject.getObject().getClass().toString());
        	valueModel.addElement((myObject.getObject()).toString());
        }
        setOpeningFrame(windowPane);
 
        //Display the window.
        pack();
        setVisible(true);
        
	}
	
	public static void setOpeningFrame(Container windowPane) {
		JPanel returnPanel = new JPanel();
		if (myObject.getType()==0) {
	
		 returnPanel= primitivePanel();
		}
		else if (myObject.getType()==1) {
			
		}
		else if (myObject.getType()==2) {}
		else if (myObject.getType()==3) {}

		else if (myObject.getType()==4) {}
		
		windowPane.add(returnPanel);
        windowPane.setVisible(true);
			
	}
	
	private static JPanel primitivePanel() {
		JPanel bodyPanel = new JPanel(new GridLayout(2,1));
		JPanel additionPanel = new JPanel(new GridLayout(2,3));
		fieldValuePanel = new JPanel(new GridLayout(1,2));
		JLabel addFieldLabel = new JLabel("Create New field of type:");
		
		
		Vector<String> v = new Vector<String>();
		if(myObject.getType() == 0) {

			for (int i = 0; i < primativeList.length;i++){
				v.add(primativeList[i]);
			}
			final JComboBox<String> combo = new JComboBox<String>(v);
			
			additionPanel.add(addFieldLabel);
			
			additionPanel.add(new javax.swing.Box(0));
			additionPanel.add(new javax.swing.Box(0));
			additionPanel.add(new javax.swing.Box(0));
		
			additionPanel.add(combo);
			textFieldValue = new JTextField();
			additionPanel.add(textFieldValue);
			JButton addButton = new JButton("Add new Field");
			additionPanel.add(addButton);
			additionPanel.add(new javax.swing.Box(0));
			// add addition panel to the body
			bodyPanel.add(additionPanel);
			
			// setup the bottom panel
			
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (!((textFieldValue.getText().equals(null)|| (textFieldValue.getText().equals(""))))) {
						int primitiveType = combo.getSelectedIndex();
						ObjectToAdd newObj = new ObjectToAdd(0);
						if (primitiveType == 0) {
							char theChar = textFieldValue.getText().charAt(0);
							newObj.makeChar(theChar);
						} else if (primitiveType == 1) {
							byte newByte = Byte.parseByte(textFieldValue.getText());
							newObj.makeByte(newByte);	
						}else if (primitiveType == 2) {

							short newShort = Short.parseShort(textFieldValue.getText());
							newObj.makeShort(newShort);
						}else if (primitiveType == 3) {
							int newInt = Integer.parseInt(textFieldValue.getText());
							newObj.makeInt(newInt);
						}else if (primitiveType == 4) {
							long newLong = Long.parseLong(textFieldValue.getText());
							newObj.makeLong(newLong);
						}else if (primitiveType == 5) {
							float newFloat = Float.parseFloat(textFieldValue.getText());
							newObj.makeFloat(newFloat);
						}else if (primitiveType == 6) {
							double newDouble = Double.parseDouble(textFieldValue.getText());
							newObj.makeDouble(newDouble);
						}else if (primitiveType == 7) {
							boolean newBool = Boolean.getBoolean(textFieldValue.getText());

							newObj.makeBoolean(newBool);
							
						}else if (primitiveType == 8) {
							newObj.makeVoid();
						}
						myObject.setObject(newObj.getObject());
						fieldList.addElement(newObj.getObject().getClass().toString());
						
						String valueString = textFieldValue.getText();
						valueModel.addElement((newObj.getObject()).toString());
					}
				}
			});
		}
		fieldType = new JList<String>(fieldList);
		valueList = new JList<String>(valueModel);
		fieldValuePanel.add(fieldType);
		fieldValuePanel.add(valueList);
		
		//add other panel to the body
		bodyPanel.add(fieldValuePanel);
		return bodyPanel;
	}

	
}
