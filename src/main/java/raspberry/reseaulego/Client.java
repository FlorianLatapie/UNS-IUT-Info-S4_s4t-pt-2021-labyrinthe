package raspberry.reseaulego;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
    	String hostName = "172.20.10.10"; // ip address of lego 
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
            System.out.println("client connecté ");
        	String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if(userInput.equalsIgnoreCase("EXIT")){
                	out.println(userInput.toUpperCase());
                    out.close();
                    in.close();
                    echoSocket.close();
                }
                out.println(userInput.toUpperCase());
                System.out.println("LEGO a repondu '" + in.readLine()+"'");
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
