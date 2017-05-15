package kryptonlib.cipher;

import kryptonlib.abstraction.PolyCipher;

/**
 * Created by lophtpicker on 09.05.2017.
 */
public final class Viginere extends PolyCipher {
    private static int smesh = USER_ALPHABET_START;//смещение алфавита относительно таблицы юникодов

    public String encrypt(String plaintext, String keyword) {
    	processArguments(plaintext, keyword);
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(ciphertext);
        for (int i = 0; i < plaintext.length(); i++) {
        	char letter = plaintext.charAt(i);
            if ( Character.isLetter(letter) ) {
            	letter = (char) ((letter + keyword.charAt(i)) % USER_ALPHABET_SIZE);
            }
            ciphertext.setCharAt(i, letter);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }
    public String decrypt(String ciphertext, String keyword) {
    	processArguments(ciphertext, keyword);
        StringBuilder plaintext = new StringBuilder(ciphertext.length());
        plaintext.insert(0, ciphertext);
        steps.clear();
        steps.saveStep(plaintext);
        for (int i = 0; i < ciphertext.length();i++) {
            char letter = ciphertext.charAt(i);
            if ( Character.isLetter(letter) ) {
            	letter = (char)( (letter - keyword.charAt(i)) % USER_ALPHABET_SIZE );
            }
            plaintext.setCharAt(i, letter);
            steps.saveStep(plaintext);
        }
        return plaintext.toString();
    }
    
    private static void processArguments(String text, String key) {
    	if (text == null || key == null)
    		throw new IllegalArgumentException("data");
    }
}
