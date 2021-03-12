/**
 * 
 */
package raspberry.reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Vector;


/**
 * @author Remy
 *
 */
public class MultiServer {
	private Vector tabClients = new Vector();
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

	public synchronized void sendAll(String message, String sLast) {
		PrintWriter out;
		for (int i = 0; i < tabClients.size(); i++)
		{
			out = (PrintWriter) tabClients.elementAt(i); 
			if (out != null)
			{
				out.print(message + sLast);
				out.flush(); // envoi dans le flux de sortie
			}
		}
	}

	public synchronized void delClient(int i) {
		nbClients--;
		if (tabClients.elementAt(i) != null) 
		{
			tabClients.removeElementAt(i); 
		}
	}


	public synchronized int addClient(PrintWriter out) {
		nbClients++;
		tabClients.addElement(out); 
		return tabClients.size() - 1;
	}

	public synchronized int getNbClients() {
		return nbClients;
	}
}
