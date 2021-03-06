package raspberry.reseaulego;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        /*if (args.length != 1) {
            System.err.println(
                    "Usage: java Client <host name> ");
            System.exit(1);
        }

        String hostName = args[0];*/
    	String hostName = "172.20.10.10"; // ip address of lego 
        int portNumber = 8888;

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
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if(userInput.equals("exit")){
                    out.println("Server close !");
                    echoSocket.close();
                    in.close();
                    out.close();
                }
                out.println(userInput);
                System.out.println("echo: server replies " + in.readLine());
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
