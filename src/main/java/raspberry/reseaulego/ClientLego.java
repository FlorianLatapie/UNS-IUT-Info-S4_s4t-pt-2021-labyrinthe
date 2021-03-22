package raspberry.reseaulego;

import java.io.*;
import java.net.*;

//cette classe est pour les tests locaux, les classes pour pc et lego sont dans leurs packages respectifs 

public class ClientLego {
	public void runClient(String args) throws IOException {
		if (args == null) {
			System.err.println("Usage: java Client <host name> ");
			System.exit(1);
		}
		String hostName = args;// "127.0.0.1" ou ip du raspberry pi
		int portNumber = 8888;
		System.out.println("client lancé");
		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("client connecté ");
			String fromServer;

			while ((fromServer = in.readLine()) != null) {
				ProtocolLego pl = new ProtocolLego();
				if (fromServer.startsWith("broadcast ")) {
					fromServer = fromServer.substring(10);
					if (pl.traitement(fromServer)) {
						out.println(fromServer + " Mouvement effectue");
						System.out.println("\"" + fromServer + "\" :\nMouvement done");
					}
				} else {
					System.out.println(fromServer);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}
}
