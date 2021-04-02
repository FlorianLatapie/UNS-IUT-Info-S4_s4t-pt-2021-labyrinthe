package lego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lejos.hardware.Button;
import raspberry.reseaulego.ClientLego;

public class LegoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("+---------------+\n|  Labyrinthe   |\n+---------------+");
		// création du socket
		ClientLego clientLego = new ClientLego();
		// lecture du fichier d'ip 
		BufferedReader in = new BufferedReader(new FileReader("./ip"));
		String ip = in.readLine();
		in.close();
		System.out.println(ip);
		clientLego.runClient(ip);

		//bloquage du programme tant que le bouton échap n'est pas cliqué sur le robot 
		while (Button.waitForAnyPress() != Button.ID_ESCAPE) {
		}
	}

}
