package raspberry.reseau;

import java.io.*;
import java.net.*;

//cette classe est pour les tests locaux, les classes pour pc et lego sont dans leurs packages respectifs 

public class ClientManuel {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Usage: java Client <host name> ");
			System.exit(1);
		}
		String hostName = args[0];// "127.0.0.1" ou ip du raspberry pi
		int portNumber = 8888;
		System.out.println("client lancé");
		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("client connecté ");
			String fromServer;

			new Thread(new Runnable() {
				String fromClient;

				@Override
				public void run() {
					while (true) {
						try {
							fromClient = stdIn.readLine();
							if (fromClient != null) {
								out.println(fromClient);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}
			}).start();

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals(StaticProtocolMessages.TERMINER)) {
					System.exit(0);
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
