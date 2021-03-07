package raspberry.reseaupc;

//import sun.nio.ch.Net;

public class NetworkProtocol {

    private NetworkProtocol(){}

    private static final int WAITING = 0;
    private static final int SENDINFO = 1;
    private static int state = WAITING;
    private static final String[] algoTypes = {"random", "leftHandedRule"};

    private static NetworkProtocol instance = null;

    public static synchronized NetworkProtocol getInstance()
    {
        if (instance == null)
        {   instance = new NetworkProtocol();
        }
        return instance;
    }


    public String processInputServer(String input){
        String output = null;
        if(state == WAITING){ //First communication client->server
            String[] temp = input.split(":"); // <algo>:<typeAlgo>
            if(temp[0].equalsIgnoreCase("algo")){
                if(temp[1].equalsIgnoreCase("random") || temp[1].equalsIgnoreCase("leftHandRule")){
                    output = "OK";
                    state=SENDINFO;
                }
            }
            else{
                output = "You're supposed to write algo:<algoType>";
            }
        }
        else if(state == SENDINFO){

        }
        return output;
    }

    public String processInputClient(String input){
        String output = null;
        if(input.equalsIgnoreCase("A") || input.equalsIgnoreCase("R")
            ||input.equalsIgnoreCase("D") || input.equalsIgnoreCase("G") )
                output="OK";
        else{
            output="command not defined <" + input + ">";
        }
        return output;
    }

    public int getState() {
        return state;
    }
}
