public class Magpie4 {
	/*
	 * Get a default greeting
	 */
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.length() == 0) {
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0) {
			response = "Why so negative?";
		} else if (findKeyword(statement, "mother") >= 0 || findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0 || findKeyword(statement, "brother") >= 0) {
			response = "Tell me more about your family.";
		}

		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		}
        else if (findKeyword(statement, "I want", 0) >= 0) {
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "I", 0) >= 0 &&
                (findKeyword(statement, "you", 0) >= 0) ) {
			// Look for a pattern (I <something> you)
			int pos = findKeyword(statement, "I", 0);

			if (pos >= 0 && findKeyword(statement, "you", pos + 1) >= 0) {
				response = transformIYouStatement(statement);
			} else {
				response = getRandomResponse();
			}
		}
		else {
			// Look for a two word (you <something> me)
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				response = transformYouMeStatement(statement);
			} else {
				response = getRandomResponse();
			}
		}
		return response;
	}

	/*
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?
	 */
	private String transformYouMeStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

    /*
	 * Take a statement with "I <something> you" and transform it into
	 * "Why do you <something> me?"
	 */
    private String transformIYouStatement(String statement) {
        // Remove the final period (if there is one).
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }

        int posI = findKeyword(statement, "I", 0);
        int posYou = findKeyword(statement, "you", posI + 1);

        String rest = statement.substring(posI + 1, posYou).trim();
        return "Why do you " + rest + " me?";
    }

    /*
     * Take a statement with "I want to <something>." and transform it into
     * "What would it mean to <something>?
     */
    private String transformIWantToStatement(String statement) {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

	/*
	 * Take a statement in the form "I want <something>"
	 * and respond "Would you be really happy if you had <something>?"
	 */
	private String transformIWantStatement(String statement) {
		//remove the final period (if there is one).
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() -1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() -1);
		}

		int pos = findKeyword(statement, "I want", 0);
		String rest = statement.substring(pos + 6).trim();
		return "Would you be really happy if you had " + rest + "?";
	}

	/*
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0) {
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}

			// The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/*
	 * Pick a default response to use if nothing else fits.
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}

}