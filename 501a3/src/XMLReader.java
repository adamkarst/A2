import java.io.*;
import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;


public class XMLReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "App.xml";
		
		try
		{
			SAXBuilder builder = new SAXBuilder(false);
			Document doc = builder.build(fileName);
			
			Element root = doc.getRootElement();
			
		
			System.out.println(root.getName());
			
			Attribute attVersion = root.getAttribute("version");
			double val = attVersion.getDoubleValue();
			System.out.println("Version: " + val + " " + attVersion.getValue());
			
			List<Element> childrenList = root.getChildren();
			
			Iterator<Element> i = childrenList.iterator();
			
			while ( i.hasNext() )
			{
				Element curEl = (Element) i.next();
				System.out.println(curEl.getName() + " has " + curEl.getChildren().size() + " child elements");
				List<Attribute> attList = curEl.getAttributes();
				Iterator<Attribute> j = attList.iterator();
				while ( j.hasNext() )
				{
					Attribute att = (Attribute) j.next();
					System.out.println("\t" + att.getName() + " = " + att.getValue());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
