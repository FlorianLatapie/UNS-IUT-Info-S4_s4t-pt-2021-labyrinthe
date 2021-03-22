package raspberry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AlgoDeplacement {
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
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
        	int arrive=0;
        	String lecture;
            while ((lecture = stdIn.readLine()) != null) {
                if ((lecture.equals(101)) || (lecture.equals(001))) {
                	System.out.println("avancer");
                }else if (lecture.equals(100) || (lecture.equals(110)) || (lecture.equals(010)) || lecture.equals(000)){
                	System.out.println("droite");
                	System.out.println("avancer");
                	if (lecture.equals(000)) {
                		if (arrive==1) {
                			lecture = null;
                		}else arrive = 1;
                		
                	}
                }else if (lecture.equals(011)) {
                	System.out.println("gauche");
                	System.out.println("avancer");
                }else if (lecture.equals(111)) {
                	System.out.println("gauche");
                	System.out.println("gauche");
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
