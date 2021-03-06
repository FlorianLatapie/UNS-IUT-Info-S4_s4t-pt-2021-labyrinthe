package raspberry.reseaulego;

import lego.MouvementController;

import java.net.*;
import java.io.*;

public class Server {

    public void runServer() throws IOException {

        int portNumber = 8888;

        try (
                ServerSocket serverSocket =
                        new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(inputLine.equals("exit")){
                    out.println("Server close !");
                    serverSocket.close();
                    in.close();
                    out.close();
                }
                traitement(inputLine);
                out.println(inputLine);
                System.out.println("server has replied server replies "+inputLine);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public void traitement(String inputLine){
        MouvementController mouvementController = new MouvementController(true);
        switch (inputLine){
            case "A":
                mouvementController.avancer();
                break;
            case "D":
                mouvementController.droite();
                break;
            case "G":
                mouvementController.gauche();
                break;
            case "R":
                mouvementController.reculer();
                break;
            case "S":
                mouvementController.stop();
                break;
            default:
                System.out.println("mouvement inconnu");
        }
    }
}
