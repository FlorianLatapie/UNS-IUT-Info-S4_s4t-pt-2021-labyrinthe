package raspberry;

import java.io.IOException;

import raspberry.reseau.MultiServer;

/**
 * ce package sera compilé sur windows puis executé sur le raspberry pi
 * 
 */

public class RaspMain {
	public static void main(String[] args) throws IOException {
		System.out.println("--- Raspberry Pi main ---\n");
		MultiServer multiServer = new MultiServer();
		multiServer.runServer(args);
	}
}
