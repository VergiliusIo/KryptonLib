package kryptonlib.cipher;

import kryptonlib.abstraction.MonoCipher;

/**
 * Created by USER1 on 09.05.2017.
 */
public class Pairs extends MonoCipher {
    public String encrypt(String plaintext, String firstLine, String secondLine) {
        processArguments(plaintext, firstLine, secondLine);
        plaintext = plaintext.toUpperCase();
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(ciphertext);
        for (int i = 0; i < plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            int index = firstLine.indexOf(letter);
            if ( Character.isLetter(letter) ) {
                //Если символа нет в первой строке, то берём парный ему во 2 строке
                if (index == -1){
                    index = secondLine.indexOf(letter);
                    letter = firstLine.charAt(index);
                }
                else if (index != -1)
                    letter = secondLine.charAt(index);
            }
            ciphertext.setCharAt(i, letter);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, String firstLine, String secondLine) {
        processArguments(ciphertext, firstLine, secondLine);
        ciphertext = ciphertext.toUpperCase();
        return encrypt(ciphertext, firstLine, secondLine);
    }


    private static void processArguments(String input, String firstLine, String secondLine) {
        if (input == null || firstLine == null || secondLine == null)
            throw new IllegalArgumentException("data");
        if (firstLine == secondLine)
            throw new IllegalArgumentException("Odin i tot zhe object");
        else if (firstLine.length() != secondLine.length())
            throw new IllegalArgumentException("Lengths is not equal");
        else {
            for (int i = 0; i < firstLine.length(); i++) {
                char letter = firstLine.charAt(i);
                if (secondLine.indexOf(letter) != -1)
                    throw new IllegalArgumentException("duplicate");
            }
        }
    }
}
