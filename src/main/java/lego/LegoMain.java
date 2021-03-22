package lego;

import java.io.IOException;

import lejos.hardware.Button;
import raspberry.reseaulego.ClientLego;

public class LegoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("+---------------+\n|  Labyrinthe   |\n+---------------+");
		ClientLego clientLego = new ClientLego();
		String argsCli = "172.20.10.6"; //ip de l'ordinateur auquel il faut se connecter
		clientLego.runClient(argsCli);
		
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {}
	}

}
