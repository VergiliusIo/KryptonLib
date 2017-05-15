package kryptonlib.cipher;

import kryptonlib.abstraction.MonoCipher;

/**
 * Created by USER1 on 08.05.2017.
 */
public class Caesar extends MonoCipher {
    //i = i + shift
    public String encrypt(String plaintext, int shift) {
    	processArguments(plaintext);
        plaintext = plaintext.toUpperCase();
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(plaintext);
        for (int i = 0; i < plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if ( Character.isLetter(letter) ) {
                letter = (char) ((( (letter - USER_ALPHABET_START) + shift) % USER_ALPHABET_SIZE) + USER_ALPHABET_START);
            }
            ciphertext.setCharAt(i, letter);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }


    public String decrypt(String ciphertext, int shift) {
        processArguments(ciphertext);
        ciphertext = ciphertext.toUpperCase();
        StringBuilder plaintext = new StringBuilder(ciphertext.length());
        plaintext.insert(0, ciphertext); 
        steps.clear();
        steps.saveStep(plaintext);
        for (int i = 0; i < ciphertext.length(); i++) {
            char letter = ciphertext.charAt(i);
            if ( Character.isLetter(letter) ) {
                letter = (char)(((USER_ALPHABET_SIZE + ( (letter - USER_ALPHABET_START) - shift)) % 26) + USER_ALPHABET_START);
        	}
            plaintext.setCharAt(i,letter);
            steps.saveStep(plaintext);
        }
        return plaintext.toString();
    }
    
    private static void processArguments(String text) {
    	if (text == null)
    		throw new IllegalArgumentException("data");
    }
}
