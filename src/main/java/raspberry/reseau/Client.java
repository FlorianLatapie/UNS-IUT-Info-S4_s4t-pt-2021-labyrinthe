package raspberry.reseau;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
    	//String hostName = "172.20.10.10"; // ip address of lego 
    	if (args.length != 1) {
            System.err.println(
                    "Usage: java Client <host name> ");
            System.exit(1);
        }
    	String hostName = args[0];//"127.0.0.1";
        int portNumber = 8888;
        System.out.println("client lancé");
        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
            System.out.println("client connectÃ© ");
            String fromServer;
        	String fromClient;
        	while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                fromClient = stdIn.readLine();
                if (fromClient != null) {
                    System.out.println("Client: " + fromClient);
                    out.println(fromClient);
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
