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
	private static DefaultListModel fieldList;
	private static JPanel fieldValuePanel;

	@SuppressWarnings("rawtypes")
	private static DefaultListModel fieldValueList;
	private static JTextField textFieldValue;
	
	public EditObjectWindow(ObjectToAdd object,String name) {
		super(name);
		myObject = object;
		Container windowPane = getContentPane();
		
        fieldList = new DefaultListModel<String>();
        valueModel = new DefaultListModel<String>();

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
			for(int i =0;i < myObject.field.size();i++) {
				fieldList.addElement(myObject.field.elementAt(i).toString());
				valueModel.addElement(myObject.value.elementAt(i).toString());
			}
			// setup the bottom panel
			
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (!((textFieldValue.getText().equals(null)|| (textFieldValue.getText().equals(""))))) {
							fieldList.addElement(combo.getSelectedItem().toString());
							myObject.addField(combo.getSelectedItem().toString());
							myObject.addFieldValue(textFieldValue.getText());
							String valueString = textFieldValue.getText();
							valueModel.addElement(valueString);
						}
					} catch (WrongTypeException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
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
