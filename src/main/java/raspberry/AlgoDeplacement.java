package raspberry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AlgoDeplacement {
	public String[] runAlgoMurDroite(Integer lecture) throws IOException {

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
}
