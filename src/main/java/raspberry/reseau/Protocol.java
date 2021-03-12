/**
 * 
 */
package raspberry.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Remy
 *
 */
public class Protocol implements Runnable {
	MultiServer multiServer;
	BufferedReader in;
	String strProtocol = "";
	Thread t;

	public Protocol(MultiServer multi) {
		this.multiServer = multi;
		in = new BufferedReader(new InputStreamReader(System.in));
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {

			while ((strProtocol = in.readLine()) != null) {
				if (strProtocol.equalsIgnoreCase("quit"))
					System.exit(0); // 
				else if (strProtocol.equalsIgnoreCase("total")) 
				{
					System.out.println("Nombre de connectes : " + multiServer.getNbClients());
					System.out.println("--------");
				} else {
					System.out.println("Cette commande n'est pas supportee");
					System.out.println("--------");
				}
				System.out.flush(); 
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
