import javax.swing.*;


public class testWriter {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DefaultListModel<ObjectToAdd> list = new DefaultListModel<ObjectToAdd>();
		
		ObjectToAdd newb = new ObjectToAdd(0);
		newb.makeChar('a');
		
		
		newb.makeChar('a');
		list.addElement(newb);
		XMLWriter writer = new XMLWriter(list);
		
	}
	
	public testWriter(@SuppressWarnings("rawtypes") DefaultListModel list) {
		@SuppressWarnings({ "unused", "unchecked" })
		XMLWriter writer = new XMLWriter(list);
	}
}
