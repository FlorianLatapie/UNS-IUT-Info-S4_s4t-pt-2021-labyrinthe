/**
 * 
 */
package raspberry.reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * @author Remy
 *
 */
public class MultiServer {
	private Map<String, PrintWriter> tabClients = new HashMap<>();
	

	private int nbClients = 0;

	public void runServer(String[] args) throws IOException {
		MultiServer multiServ = new MultiServer();
		try {
			int port;
			if (args.length <= 0)
				port = 8888;
			else
				port = Integer.parseInt(args[0]);

			ServerSocket ss = new ServerSocket(port);
			checkConnexion(port);
			while (true) {
				new MultiServerThread(ss.accept(), multiServ);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static void checkConnexion(int port) {
		System.out.println("--------\nDemarre sur le port : " + port+"\n--------");
	}

	public synchronized void sendAll(String message) {
		for (PrintWriter printWriter : tabClients.values()) {
			if(printWriter!=null) {
				printWriter.println(message);
			}
			else {
				System.err.println("un printwriter est null");
			}
		}
	}

	public synchronized void delClient(int i) {
		nbClients--;
		if (tabClients.get(i) != null) 
		{
			tabClients.remove(i);
		}
	}


	public synchronized int addClient(String nom, PrintWriter out) {
		System.out.println(nom+"#"+nbClients+" connecté et ajouté");
		nbClients++;
		tabClients.put(nom, out); 
		return tabClients.size() - 1;
	}

	public synchronized int getNbClients() {
		return nbClients;
	}
	
	public Map<String, PrintWriter> getTabClients() {
		return tabClients;
	}

	public void sendTo(String nomCli, String message) {
		tabClients.get(nomCli).print(message);
		
	}
}
