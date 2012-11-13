import javax.swing.*;

import Networking.Server;

public class serverSendFileThread extends Thread {
	
	    public serverSendFileThread() {
	    	super("serverSendFileThread");
	    }
	    
	    public void run(DefaultListModel<ObjectToAdd> list, JFrame theFrame) {
	    	Server server  = new Server(1236);
			try
			{
				server.sendFile("E:\\School\\CPSC 501\\501a3\\sendFileXML.xml");
				theFrame.dispose();
			}
			catch(Exception exp)
			{
				System.err.println(exp.toString());
			}
	    }
	
}
