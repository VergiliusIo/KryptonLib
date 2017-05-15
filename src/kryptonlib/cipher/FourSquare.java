package kryptonlib.cipher;

import java.util.Arrays;

import kryptonlib.abstraction.Square;
import kryptonlib.abstraction.SymmetricCipher;

/**
 * Created by USER1 on 09.05.2017.
 */

/*
For test:
char[][] ac = {
        {'A','B','C','D','E'},
        {'F','G','H','I','K'},
        {'L','M','N','O','P'},
        {'Q','R','S','T','U'},
        {'V','W','X','Y','Z'}
};
char[][] bc = {
        {'A','B','C','D','E'},
        {'F','G','H','I','K'},
        {'L','M','N','O','P'},
        {'Q','R','S','T','U'},
        {'V','W','X','Y','Z'}
};

char[][] cc = {
        {'C','R','I','P','T'},
        {'O','G','A','F','B'},
        {'D','E','H','K','L'},
        {'M','N','Q','S','U'},
        {'V','W','X','Y','Z'}
};


char[][] dc = {
        {'S','E','G','U','R'},
        {'T','A','B','C','D'},
        {'F','H','I','K','L'},
        {'M','N','O','P','Q'},
        {'V','W','X','Y','Z'}
};
 */
public final class FourSquare extends SymmetricCipher {
    public String encrypt(String plaintext, Square a, Square b, Square c, Square d) {
        processArguments(plaintext, a, b, c, d);
        plaintext = plaintext.toUpperCase();
        String[] biograms = makeBiograms(plaintext);
        StringBuilder ciphertext = new StringBuilder(plaintext.length());
        ciphertext.insert(0, plaintext);
        steps.clear();
        steps.saveStep(ciphertext);
        for (int i = 0; i < biograms.length; i++) {
            Square.Coordinate cA = a.getCoordinate(biograms[i].charAt(0));
            Square.Coordinate cB = b.getCoordinate(biograms[i].charAt(1));
            //System.out.println(ciphertext.toString());
            //C square
            ciphertext.setCharAt(i, c.matrix[cA.getY()][cB.getX()]);
            //D square
            ciphertext.setCharAt(i, d.matrix[cB.getY()][cA.getX()]);
            steps.saveStep(ciphertext);
        }
        return ciphertext.toString();
    }
    
    public String decrypt(String ciphertext, Square a, Square b, Square c, Square d) {
        processArguments(ciphertext, a, b, c, d);
        ciphertext = ciphertext.toUpperCase();
        String[] biograms = makeBiograms(ciphertext);
        StringBuilder plaintext = new StringBuilder(ciphertext.length());
        plaintext.insert(0, ciphertext);
        steps.clear();
        steps.saveStep(plaintext);
        for (int i = 0; i < biograms.length; i++) {
        	Square.Coordinate cC = c.getCoordinate(biograms[i].charAt(0));
        	Square.Coordinate cD = d.getCoordinate(biograms[i].charAt(1));
        	//A square
        	plaintext.setCharAt(i, a.matrix[cC.getY()][cD.getX()]);
        	//B square
        	plaintext.setCharAt(i, b.matrix[cD.getY()][cC.getX()]);
        	steps.saveStep(plaintext);
        }
        return plaintext.toString();
    }

    private static void processArguments(Object... objects) {
        for (Object o : objects) {
            if (o == null)
                throw new IllegalArgumentException("data");

        }
    }

    private static String[] makeBiograms(String text) {
    	processArguments(text);
    	text = text.replaceAll(" ", "");
        String[] biograms = new String[text.length() / 2];
        int cnt = 0;
        for (int i = 0; i < text.length(); i+=2) {
            String biogram = text.substring(i, i + 2);
            biograms[cnt++] = biogram;
        }
        return biograms;
    }
}
