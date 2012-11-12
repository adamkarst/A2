import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

public class XMLWriter {

	/**
	 * @param args
	 */
	public XMLWriter(DefaultListModel<ObjectToAdd> objectList) {
		// TODO Auto-generated method stub
		String fileName = "sendFileXML.xml";
		
		Element root = new Element("serialized");
		
		
		for ( int i = 0; i < objectList.size(); i++)
		{
			ObjectToAdd theObject = (ObjectToAdd)objectList.elementAt(i);
			
			serializeObject(theObject, root);
		}
			
		Document doc = new Document(root);
		
		try {
			FileOutputStream fStream = new FileOutputStream(fileName);
			XMLOutputter xmlPersister = new XMLOutputter();
			xmlPersister.output(doc, fStream);	// the XMLOutputter object needs a Document and a file stream to create the XML file
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Element serializeObject(ObjectToAdd obj, Element root) {
		Element theObjectToSerialize = new Element("Object");
		Element valueOfObject = new Element("Value");
		
		
		theObjectToSerialize.setName("Object"); // names can be changed after the instantiation of an element
		if (obj.getType() == 0) {
			Object theObjectsObject = obj.getObject();
			if (theObjectsObject != null) {
				theObjectToSerialize.setAttribute("class", theObjectsObject.getClass().toString());
				valueOfObject.setText(theObjectsObject.toString());
				valueOfObject.setName("Value");
				theObjectToSerialize.addContent(valueOfObject);
			}
			
			
		}
		else if (obj.getType() == 1) {
			for (int i = 0; i < obj.field.size();i++) {
				ObjectToAdd object = obj.field.get(i);
				if (object != null) {
					serializeObject(object,theObjectToSerialize);
				}
			}
		}
		else if (obj.getType() == 2 || obj.getType() == 3) {
			try {


			} catch (Exception e) {}
		}
		else if (obj.getType() == 4) {
			for (int i = 0; i < obj.objectList.size();i++) {
				ObjectToAdd object = obj.getFromListAt(i);
				if (object != null) {
					serializeObject(object,theObjectToSerialize);
				}
			}
		}
		
		
		root.addContent(theObjectToSerialize);
		return root;
	}

}
