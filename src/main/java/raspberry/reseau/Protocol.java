/**
 * 
 */
package raspberry.reseau;

/**
 * @author Remy
 *
 */
public class Protocol  {
	private MultiServer multiServer;
	
	
	
	public Protocol(MultiServer multiServer) {
		this.multiServer = multiServer;
	}



	public String processInfo(String input) {
		String output=  null;
		if(input.equalsIgnoreCase(null)) {
			output = "T nul";
		}
		else if(input.equalsIgnoreCase("")) {
			output = "Protocl c ok";
		}
		else if(input.equalsIgnoreCase("test")) {
			output = "TEst ok frere";
		}
		else if(input.equalsIgnoreCase("broadcast")){
			multiServer.sendAll(input);
			output = "je fais un broadcast";
		}

		return output;
	}
	
}
