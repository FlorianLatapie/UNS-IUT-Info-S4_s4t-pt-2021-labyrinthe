package lego;

import java.io.IOException;

import lejos.hardware.Button;
import raspberry.reseaulego.Server;

public class LegoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("+---------------+\n|  Labyrinthe   |\n+---------------+");
		Server legoServ = new Server();
		legoServ.runServer();
		
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {}
	}

}
