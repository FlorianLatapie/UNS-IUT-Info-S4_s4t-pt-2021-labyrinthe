package raspberry.reseaulego;

import lego.MouvementController;

import java.net.*;
import java.io.*;

public class Server {

	public void runServer() throws IOException {

		int portNumber = 8888;
		System.out.println("Server lance");
		try (ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			System.out.println("Server connecte");
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.toLowerCase() =="exit") {
					out.println("Appuyez sur retour sur la brique");
					//in.close();
					//out.close();
					serverSocket.close();
				} else {

					if (traitement(inputLine)) {
						out.println(inputLine + " Mouvement effectue");
						System.out.println("je reponds \"" + inputLine + "\" :\nMouvement done");
					} else {
						out.println("\"" + inputLine + "\" est incorrect");
						System.out.println("je reponds " + inputLine + "\nEst incorrect");
					}
				}

			}

		} catch (IOException e) {
			System.out.println("Connexion terminee");
			System.out.println(e.getMessage());
		}
	}

	public boolean traitement(String inputLine) {
		MouvementController mouvementController = new MouvementController(true);
		switch (inputLine) {
		case "A":
			mouvementController.avancer();
			return true;
		case "D":
			mouvementController.droite();
			return true;
		case "G":
			mouvementController.gauche();
			return true;
		case "R":
			mouvementController.reculer();
			return true;
		case "S":
			mouvementController.stop();
			return true;
		case "EXIT":
			return true;
		default:
			System.out.println("mouvement inconnu");
			return false;
		}
	}
}
