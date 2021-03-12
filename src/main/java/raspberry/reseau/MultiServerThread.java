/**
 * 
 */
package raspberry.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Remy
 *
 */
public class MultiServerThread implements Runnable {
	private Thread t; 
	private Socket s; 
	private PrintWriter out; 
	private BufferedReader in; 
	private MultiServer multiServer;
	private int numClient = 0; 

	public MultiServerThread(Socket socket, MultiServer multiServ) {
		this.multiServer = multiServ;
		this.s = socket;
		try {
			out = new PrintWriter(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			numClient = multiServer.addClient(out);
		} catch (IOException e) {
			e.getMessage();
		}
		t = new Thread(this);
		t.start();
	}

	public void run() {
		String message = "";
		System.out.println("Un nouveau client s'est connecte, no " + numClient);
		try {

			char charCur[] = new char[1]; 
			while (in.read(charCur, 0, 1) != -1)			{
				if (charCur[0] != '\u0000' && charCur[0] != '\n' && charCur[0] != '\r')
					message += charCur[0];
				else if (!message.equalsIgnoreCase("")) 
				{
					if (charCur[0] == '\u0000') 
						multiServer.sendAll(message, "" + charCur[0]);
					else
						multiServer.sendAll(message, "");
					message = "";
				}
			}
		} catch (Exception e) {
			e.getMessage();
		} 
		finally 
		{
			try {
				System.out.println("Le client no " + numClient + " s'est deconnecte");
				multiServer.delClient(numClient); 
				s.close(); 
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

}
