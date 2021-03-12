/**
 * 
 */
package raspberry.reseaulego;

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
	private Thread t; // contiendra le thread du client
	private Socket s; // recevra le socket liant au client
	private PrintWriter out; // pour gestion du flux de sortie
	private BufferedReader in; // pour gestion du flux d'entrée
	private MultiServer multiServer; // pour utilisation des méthodes de la classe principale
	private int numClient = 0; // contiendra le numéro de client géré par ce thread

	public MultiServerThread(Socket socket, MultiServer multiServ) {
		this.multiServer = multiServ;
		this.s = socket;
		try {
			// fabrication d'une variable permettant l'utilisation du flux de sortie avec
			// des string
			out = new PrintWriter(s.getOutputStream());
			// fabrication d'une variable permettant l'utilisation du flux d'entrée avec des
			// string
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// ajoute le flux de sortie dans la liste et récupération de son numéro
			numClient = multiServer.addClient(out);
		} catch (IOException e) {
			e.getMessage();
		}
		t = new Thread(this);
		t.start();
		System.out.println("Serveur créé");
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
