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
		try (PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));) {
			numClient = multiServer.addClient(in.readLine(), out);
			// System.out.println("Un nouveau client s'est connecté : #" + numClient);
			String inputLine, outputLine;
			Protocol protocol = new Protocol(multiServer);

			while ((inputLine = in.readLine()) != null) {
				System.out.println("recu : " + inputLine);
				if (inputLine.equals(StaticProtocolMessages.TERMINER)) {
					multiServer.sendAll(StaticProtocolMessages.TERMINER);
					System.exit(0);
				}
				if (!protocol.processInfo(inputLine).equals("")) {
					outputLine = protocol.processInfo(inputLine);
					System.out.println("envoyé : " + outputLine);
					out.println(outputLine);
				}
			}
		} catch (IOException e) {
			e.getMessage();
		} finally {
			try {
				System.out.println("Le client #" + numClient + " s'est deconnecté");
				multiServer.delClient(numClient);
				s.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

}
