package kryptonlib.cipher;

import kryptonlib.abstraction.MonoCipher;

import java.math.BigInteger;

/**
 * Created by USER1 on 08.05.2017.
 */
public final class Affine extends MonoCipher {
    public String encrypt(String plaintext, int firstKey, int secondKey) {
        processArguments(plaintext, firstKey, secondKey);
        plaintext = plaintext.toUpperCase();
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(plaintext);
        for (int in = 0; in < plaintext.length(); in++) {
            char letter = plaintext.charAt(in);
            if ( Character.isLetter(letter) )
                letter = (char) ((firstKey * (letter - USER_ALPHABET_START) + secondKey) % USER_ALPHABET_SIZE + USER_ALPHABET_START);
            ciphertext.setCharAt(in, letter);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, int firstKey, int secondKey) {
    	processArguments(ciphertext, firstKey, secondKey);
        ciphertext = ciphertext.toUpperCase();
        StringBuilder plaintext = new StringBuilder(ciphertext.length());
        plaintext.insert(0, ciphertext);
        steps.clear();
        steps.saveStep(plaintext);
        BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(26)); //size alphabet
        for (int in = 0; in < ciphertext.length(); in++) {
            char letter = ciphertext.charAt(in);
            if ( Character.isLetter(letter) ) {
                int decoded = inverse.intValue() * (letter - USER_ALPHABET_START - secondKey + USER_ALPHABET_SIZE);
                letter = (char)(decoded % USER_ALPHABET_SIZE + USER_ALPHABET_START);
            }
            plaintext.setCharAt(in, letter);
            steps.saveStep(plaintext);
        }
        return plaintext.toString();
    }
    
    private void processArguments(String text, int firstKey, int secondKey) {
    	if (text == null)
    		throw new IllegalArgumentException("data");
    }
}
