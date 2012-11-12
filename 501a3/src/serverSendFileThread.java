import javax.swing.DefaultListModel;

import Networking.Server;


public class serverSendFileThread extends Thread {
	
	    public serverSendFileThread() {
	    	super("serverSendFileThread");
	    }
	    
	    public void run(DefaultListModel list) {
	    	testWriter writer = new testWriter(list);
	    	Server server  = new Server(1236);
			try
			{
				server.sendFile("E:\\School\\CPSC 501\\501a3\\sendFileXML.xml");
			}
			catch(Exception exp)
			{
				System.err.println(exp.toString());
			}
	    }
	
}
