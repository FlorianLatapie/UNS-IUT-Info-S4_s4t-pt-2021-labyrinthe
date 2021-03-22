package raspberry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class AlgoDeplacement {
	private static String algo = "murDroite";

	public static String[] runAlgoMurDroite(Integer lecture) {

		int arrive = 0;

		if ((lecture.equals(101)) || (lecture.equals(001))) {
			String[] retour = { "A" };
			return retour;
		}

		else if (lecture.equals(100) || (lecture.equals(110)) || (lecture.equals(010)) || lecture.equals(000)) {
			String[] retour = { "D", "A" };
			return retour;
		}

		else if (lecture.equals(011)) {
			String[] retour = { "G", "A" };
			return retour;

		} else if (lecture.equals(111)) {
			String[] retour = { "G", "G" };
			return retour;
		}

		else if (lecture.equals(000)) {
			if (arrive == 1) {
				lecture = null;
			} else {
				arrive = 1;
				String[] retour = { "ARR" };
				return retour;

			}
		}
		String[] retour = { "ERR" };
		return retour;
	}

	public static void run(int parseInt) {
		switch (algo) {
		case "murDroite":
			System.out.println(Arrays.toString(runAlgoMurDroite(parseInt)));
			//TODO faire bouger le robot a l'aide d'un client qui fait un broadcast svp
			break;
		default:
			System.out.println("algo inconnu : " + algo);
		}
	}
}
