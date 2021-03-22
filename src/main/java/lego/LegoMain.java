package lego;

import java.io.IOException;

import lejos.hardware.Button;
import raspberry.reseaulego.ClientLego;

public class LegoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("+---------------+\n|  Labyrinthe   |\n+---------------+");
		ClientLego clientLego = new ClientLego();
		String[] argsCli = {"10.188.182.91"};
		clientLego.runClient(argsCli);
		
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {}
	}

}
