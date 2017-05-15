package kryptonlib.abstraction;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by USER1 on 08.05.2017.
 */
public abstract class Cipher {
	public StepsWork steps = new StepsWork();
	public final static String USER_LANGUAGE = "en";
	public final static String USER_ALPHABET;
	public final static int USER_ALPHABET_SIZE = 26;
	public final static int USER_ALPHABET_START;
	public final static int USER_ALPHABET_END;
	public static HashMap<String, Range> alphabets = new HashMap<>();
	
	static {
		alphabets.put("en", new Range(65, 90));
		alphabets.put("ru", new Range(1040, 1072));
		
		//USER_LANGUAGE = Locale.getDefault().getLanguage();
		USER_ALPHABET = alphabets.get(USER_LANGUAGE).toString();
		//USER_ALPHABET_SIZE = USER_ALPHABET.length();
		USER_ALPHABET_START = alphabets.get(USER_LANGUAGE).getFrom();
		USER_ALPHABET_END = alphabets.get(USER_LANGUAGE).getTo();
	}
	
	public static String getCertainAlphabet(String language) {
		return alphabets.get(language).toString();
	}
	
	
	public static String getUserLanguage() { return USER_LANGUAGE; }
	public static String getUserAlphabet() { return USER_ALPHABET; }
	public static int getUserAlphabetSize() { return USER_ALPHABET_SIZE; }
}


class Range {
	private int from, to;
	
	public Range(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(to - from);
		for (int i = from; i < to + 1; i++) 
			result.append( Character.toChars(i) );
		return result.toString();
	}
	
	public int getFrom() { return from; }
	public int getTo() { return to; }
}