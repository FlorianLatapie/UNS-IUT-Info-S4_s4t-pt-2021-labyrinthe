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
	private MultiServer multiServer;
	private int numClient = 0; 

	public MultiServerThread(Socket socket, MultiServer multiServ) {
		this.multiServer = multiServ;
		this.s = socket;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try (
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		){
			numClient = multiServer.addClient(out);
			System.out.println("Un nouveau client s'est connecte, no " + numClient);
			String inputLine, outputLine;
            Protocol protocol = new Protocol(multiServer);
            if(numClient > 0)
				protocol.processInfo("broadcast");
            outputLine = protocol.processInfo("");
            out.println(outputLine);
			while ((inputLine = in.readLine()) != null) {
				outputLine = protocol.processInfo(inputLine);
				out.println(outputLine);
			}
		} catch (IOException e) {
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
