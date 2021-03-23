package raspberry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StdinScriptReader {
    public static void main(String[] args) throws IOException, InterruptedException {
        String path = System.getProperty("user.dir") +
                "\\src\\main\\java\\raspberry\\python\\SimpleStdinValue.py";

        ProcessBuilder pb = new ProcessBuilder("python", path).inheritIO();
        Process p = pb.start();
        Thread.sleep(1);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
            Thread.sleep(1);
        }

    }


}



