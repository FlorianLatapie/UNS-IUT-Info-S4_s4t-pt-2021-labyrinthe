/**
 * 
 */
package raspberry.reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;




/**
 * @author Remy
 *
 */
public class MultiServer {
	private List<PrintWriter> tabClients = new ArrayList<>();
	private int nbClients = 0;

	public static void main(String[] args) throws IOException {
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
		System.out.println("--------");
		System.out.println("Demarre sur le port : " + port);
		System.out.println("--------");
	}

	public synchronized void sendAll(String message) {
		System.out.println(tabClients.toString());
		for (PrintWriter printWriter : tabClients) {
			if(printWriter!=null) {
				printWriter.println(message);
			}
			else {
				System.err.println("un pw est null");
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


	public synchronized int addClient(PrintWriter out) {
		nbClients++;
		tabClients.add(out); 
		return tabClients.size() - 1;
	}

	public synchronized int getNbClients() {
		return nbClients;
	}
}
