package raspberry.reseaupc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import ihm.AccueilPane;
import raspberry.reseau.StaticProtocolMessages;

public class ClientPC {
	private String action;
	private ProtocolPC protocolPC = new ProtocolPC();
	private AccueilPane ac;

	public void runClient(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java ClientPC <host name> ");
			System.exit(1);
		}
		String hostName = args[0];// "127.0.0.1" ou ip du raspberry pi
		int portNumber = 8888;
		System.out.println("Pc client lancé");
		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Pc client connecté ");
			String fromServer;
			
			out.println("PC");

			new Thread(new Runnable() {
				String fromClient;

				@Override
				public void run() {
					while (true) {
						try {
							fromClient = stdIn.readLine();// modifier ca par un appel à un protocol
							if (fromClient != null) {
								out.println(ac.getAttAlgoSelected());
							}
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}
			}).start();

			while ((fromServer = in.readLine()) != null) {
				 if (fromServer.equals(StaticProtocolMessages.TERMINER)) {
	                    System.exit(0);
	                    }
				 if(fromServer != null){
					 protocolPC.traitement(fromServer);
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
