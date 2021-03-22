/**
 * 
 */
package raspberry.reseau;

import raspberry.AlgoDeplacement;

/**
 * @author Remy
 *
 */
public class Protocol{
	private MultiServer multiServer;
		
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
			return "bc effectue";	
		}
		
		else if(input.startsWith("valCapteur ")){
			AlgoDeplacement.run(Integer.parseInt((input).substring(11)));
			return "";	
		}
		
		
		else {
			return "commande inconnue";
		}
	}
}
