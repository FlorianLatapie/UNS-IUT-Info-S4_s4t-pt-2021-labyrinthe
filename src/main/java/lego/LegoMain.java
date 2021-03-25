package lego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lejos.hardware.Button;
import raspberry.reseaulego.ClientLego;

public class LegoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("+---------------+\n|  Labyrinthe   |\n+---------------+");
		ClientLego clientLego = new ClientLego();
		BufferedReader in = new BufferedReader(new FileReader("./ip"));
		String ip = in.readLine();
		in.close();
		System.out.println(ip);
		clientLego.runClient(ip);
		
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {}
	}

}
