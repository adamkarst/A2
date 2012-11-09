import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class XMLReaderRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "App.xml";
		
		try
		{
			SAXBuilder builder = new SAXBuilder(false);
			// reading an XML file, creating the Document object containing all the elements along with attributes
			Document doc = builder.build(fileName);  
			
			Element root = doc.getRootElement(); // getting the root element of a document
			
			recursive(root, 0); // recursive function to visit every element
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	// root is the current element, level is used to produce a proper, well-formatted output
	private static void recursive(Element curElement, int level) 
	{
		println("Printing Attributes for " + curElement.getName() + "...", level);
		List<Attribute> attIter = curElement.getAttributes();
		Iterator<Attribute> j = attIter.iterator();
		while ( j.hasNext() )
		{
			Attribute att = (Attribute) j.next();
			// for each attribute, print the name and the value
			// getValue returns a string, if you know the type of your attribute use get???Value e.g. getIntValue, getDoubleValue, etc.
			println("\t" + att.getName() + " = " + att.getValue(), level);
		}

		println("Printing Elements for " + curElement.getName() + "...", level);
		
		List<Element> childrenList = curElement.getChildren();		
		Iterator<Element> i = childrenList.iterator();
		
		while ( i.hasNext() )
		{
			Element curEl = (Element) i.next();
			recursive(curEl, level + 1); // before visiting the text, we do the recursion, what happens if we place this line at the end of the loop?
			if ( curEl.getText().trim().length() > 0) // to avoid empty spaces/lines
				println( "\tText in " + curEl.getName() + ": " + curEl.getText(), level+1);
			
		}
	}

	private static void println(String msg, int level) {
		// adding proper number of tabs before printing the actual string
		for ( int i = 0; i < level; i++ )
			System.out.print("\t");
		System.out.println(msg);
	}
}
