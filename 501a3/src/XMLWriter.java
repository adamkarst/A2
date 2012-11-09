import java.io.*;
import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

public class XMLWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "FibXML.xml";
		
		Element root = new Element("MyRoot");
		
		int low = 0;
		int high = 1;
		
		for ( int i = 0; i < 10; i++)
		{
			Element fib = new Element("Fibonacci");
			fib.setAttribute("Index", String.valueOf(i));
			if ( i % 2 == 0 )
				fib.setName("FibFib"); // names can be changed after the instantiation of an element
			fib.setText(String.valueOf(low));
			int temp = high;
			high += low;
			low = temp;
			
			root.addContent(fib);
			
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

}
