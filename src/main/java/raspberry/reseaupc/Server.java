package raspberry.reseaulego;

import java.net.*;
import java.io.*;
import java.util.Random;


public class Server {

    private static NetworkProtocol np = NetworkProtocol.getInstance();
    static Random test = new Random(); // for the sake of exemple / delete it later
    static String[] vmn = {"A","R","D"};

    public static void main(String[] args)throws Exception {
        int portNumber = 8888;
        System.out.println("Server lance");
        try(
                ServerSocket serverSocket =
                        new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ){
            System.out.println("Server connecte");
            String inputLine;
            if (np.getState() == 0) {
                while ((inputLine=in.readLine()) != null) {
                    if (inputLine.equals("exit")) {
                        out.println("Server close !");
                        in.close();
                        out.close();
                        serverSocket.close();
                    }
                    String answer;
                    answer = np.processInputServer(inputLine);
                    if (answer != null)
                        out.println(answer);
                }
            } else if (np.getState() == 1) {
                String info = vmn[test.nextInt(3)];
                out.println(info);

            }
                /*

                if (traitement(inputLine)) {
                    out.println("\""+inputLine+"\" :Mouvement effectué");
                    System.out.println("je reponds \""+inputLine+"\" :\nMouvement done");
                }
                else {
                    out.println("\""+inputLine + "\" est incorrect");
                    System.out.println("je reponds "+inputLine+"\nEst incorrect");
                }*/

        }
    }



    public static boolean traitement(String inputLine){
        //MouvementController mouvementController = new MouvementController(true);
        switch (inputLine){
            case "A":
               // mouvementController.avancer();
                return true;
            case "D":
               // mouvementController.droite();
                return true;
            case "G":
                //mouvementController.gauche();
                return true;
            case "R":
                //mouvementController.reculer();
                return true;
            case "S":
                //mouvementController.stop();
                return true;
            case "EXIT":
                return true;
            default:
                System.out.println("mouvement inconnu");
                return false;
        }
    }

}
