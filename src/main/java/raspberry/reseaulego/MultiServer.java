/**
 * 
 */
package raspberry.reseaulego;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import raspberry.reseaulego.*;

/**
 * @author Remy
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {

			int portNumber = 8888;
	        boolean listening = true;
	        System.out.println("Serveur lancé");
	        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
	            while (listening) {
		            new MultiServerThread(serverSocket.accept()).start();
		        }
		    } catch (IOException e) {
	            System.err.println("Could not listen on port " + portNumber);
	            System.exit(-1);
	        }
	    }
}
