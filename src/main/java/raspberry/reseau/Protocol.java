/**
 * 
 */
package raspberry.reseau;

import raspberry.algo.RecommandationAlgo;

/**
 * @author Remy
 *
 */
public class Protocol{
	private MultiServer multiServer;
	private RecommandationAlgo recommandationAlgo = new RecommandationAlgo();
		
	public Protocol(MultiServer multiServer) {
		this.multiServer = multiServer;
	}

	public String processInfo(String input) {

		if(input.equalsIgnoreCase(null) || input.equalsIgnoreCase("")) {
			return  "client input is null : "+input;
		}
		
		else if(input.equalsIgnoreCase("test")) {
			return  "le protocol existe";
		}
		
		else if(input.startsWith("broadcast")){
			multiServer.sendAll(input);
			return "";	
		}
		
		else if(input.startsWith("valCapteur ")){
			recommandationAlgo.executer(Integer.parseInt((input).substring(11)));
			return "";	
		}
		
		
		else {
			return "commande inconnue";
		}
	}
}
