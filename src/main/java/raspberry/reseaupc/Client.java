package raspberry.reseaulego;

import java.io.*;
import java.net.*;


public class Client {

    private static NetworkProtocol np = NetworkProtocol.getInstance();

    public static void main(String[] args) throws IOException {

        /*if (args.length != 1) {
            System.err.println(
                    "Usage: java Client <host name> ");
            System.exit(1);
        }

        String hostName = args[0];*/
        String hostName = "localhost"; // ip address of lego
        int portNumber = 8888;
        System.out.println("client lancé");
        try(
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ){
            System.out.println("client connecté ");
            if(np.getState() == 0){
                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    System.out.println("rentre while");
                    if (userInput.toUpperCase().equals("EXIT")) {
                        out.println(userInput.toUpperCase());
                        out.close();
                        echoSocket.close();
                        in.close();
                    }
                    out.println(userInput.toUpperCase());
                    System.out.println("LEGO a repondu " + in.readLine());
                }
            }
            else if(np.getState() == 1){
                String serverInfo;
                while((serverInfo = in.readLine()) != null) {
                    if (serverInfo.equals("END")) {
                        out.println("Server close !");
                        in.close();
                        out.close();
                        echoSocket.close();
                    }

                    String ack = np.processInputClient(serverInfo);
                    if (ack != null)
                        out.println("LEGO a repondu " + ack);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }


}
