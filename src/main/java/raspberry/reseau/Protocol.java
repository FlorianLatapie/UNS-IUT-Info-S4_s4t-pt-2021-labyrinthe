/**
 * 
 */
package raspberry.reseau;

/**
 * @author Remy
 *
 */
public class Protocol  {
	
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

		return output;
	}
	
}
