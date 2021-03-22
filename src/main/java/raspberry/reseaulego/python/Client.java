package raspberry.reseaulego.python;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("localhost", 9000);
        DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
        DataInputStream in = new DataInputStream(soc.getInputStream());
        while (true) {
            String msg = (String) in.readUTF();
            System.out.println("python: " + msg);
            dout.writeUTF("Ok");
            dout.flush();
            if (msg == "")
                break;
        }
        dout.close();
        soc.close();
    }
}