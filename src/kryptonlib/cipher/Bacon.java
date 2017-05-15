package kryptonlib.cipher;

import kryptonlib.abstraction.MonoCipher;
import kryptonlib.tool.ConverterNotations;

/**
 * Created by USER1 on 08.05.2017.
 * 
 * for TestDrive "вот и Ќаступила ƒол√ќ∆даЌЌая зима"
 */
public final class Bacon extends MonoCipher {
    //will use 2 and 3 mode of cipher
	//use modern alphabet
    public String encrypt(String plaintext, int mode) {
    	return null;
    }

    public String decrypt(String ciphertext, int mode) {
    	processArguments(ciphertext, mode);
    	StringBuilder plaintext = new StringBuilder(ciphertext.length() / 5);
    	String[] spl = splitText(ciphertext, mode);
    	steps.saveStep(spl);
    	if (mode == 1) {}
    	if (mode == 2) {
    		for (String s : spl) {
    			long num = ConverterNotations.binToDec(s);
    			char letter = USER_ALPHABET.charAt((int) num);
    			plaintext.append(letter);
    			steps.saveStep(plaintext);
    		}
    		return plaintext.toString();
    	}
    	if (mode == 3) {
    		for (String s : spl) {
    			long num = Integer.parseInt(s);
    			char letter = USER_ALPHABET.charAt((int)num);
    			plaintext.append(letter);
    			steps.saveStep(plaintext);
    		}
    		return plaintext.toString();
    	}
    	throw new IllegalArgumentException("data");
    }
    
    private String[] splitText(String text, int mode) {
    	text = text.replaceAll(" ", "");
    	text = text.substring(0, (text.length() / 5) * 5);//otsekaem lishnuyu chast
    	String[] str = new String[text.length() / 5];
    	steps.clear();
    	steps.saveStep(str);
    	
    	if (mode == 2) {
	    	//neobhodimo dobavit regularnoe znachenie ubirayuschee iz texta nenuzhnye simvoly
	    	int cnt = 0;
	    	for (int i = 0; i < text.length(); i+=5) {
	    		String tmp = text.substring(i, i + 5);
	    		StringBuilder result = new StringBuilder(5);
	    		for (int j = i; j < i + 5; j++) {
	    			char letter = tmp.charAt(j % 5);
	    			if ( Character.isLetter(letter) ) {
	    				if ( Character.isLowerCase(letter) )
	    					result.append('0');
	    				if ( Character.isUpperCase(letter) ) 
	    					result.append('1');
	    			} 
	    		}
	    		str[cnt++] = result.toString();
	    	}
    	}
    	if (mode == 3) {
    		final String FIRST_PART_ALPHABET = USER_ALPHABET.substring(0, USER_ALPHABET_SIZE / 2);
			//final String SECOND_PART_ALPHABET = USER_ALPHABET.substring(USER_ALPHABET_SIZE / 2, USER_ALPHABET_SIZE);
	    	
			int cnt = 0;
	    	for (int i = 0; i < text.length(); i+=5) {
	    		String tmp = text.substring(i, i + 5);
	    		StringBuilder result = new StringBuilder(5);
	    		for (int j = i; j < i + 5; j++) {
	    			char letter = tmp.charAt(j % 5);
	    			if ( Character.isLetter(letter) ) {
	    				if ( FIRST_PART_ALPHABET.indexOf(letter) != -1 )
	    					result.append('0');
	    				else
	    					result.append('1');
	    			} 
	    		}
	    		str[cnt++] = result.toString();
	    	}
    	}
    	return str;
    }

    private void processArguments(String text, int mode) {
    	if (text == null) 
    		throw new IllegalArgumentException("data");
    	if (mode <= 0 || mode > 3)	//1, 2, 3
    		throw new IllegalArgumentException("data");
    }
}
