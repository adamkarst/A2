package Networking;

public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client  = new Client(1236, "127.0.0.1");
		try
		{
			client.receiveFile("E:\\School\\CPSC 501\\XMLPlay\\XMLPlay\\Client_Copy_Of_App.xml");
		}
		catch(Exception exp)
		{
			System.err.println(exp.toString());
		}
	}

}
