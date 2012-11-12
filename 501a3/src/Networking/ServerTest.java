package Networking;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
