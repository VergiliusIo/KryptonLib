package kryptonlib.cipher;

import kryptonlib.abstraction.MonoCipher;

/**
 * Created by USER1 on 08.05.2017.
 */
public final class Atbash extends MonoCipher {
    //i = n - i + 1
    public String encrypt(String plaintext) {
        processArguments(plaintext);   
        plaintext = plaintext.toUpperCase();
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(ciphertext);
        for (int i = 0; i < plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if ( Character.isLetter(letter) ) {
                letter = (char) ((USER_ALPHABET_SIZE - (letter - USER_ALPHABET_START) - 1) + USER_ALPHABET_START);
            }
            ciphertext.setCharAt(i, letter);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
    	processArguments(ciphertext);
        ciphertext = ciphertext.toUpperCase();
        String plaintext = encrypt(ciphertext);
        return plaintext;
    }
    
    private void processArguments(String text) {
    	if (text == null) 
    		throw new IllegalArgumentException("data");
    }
}
