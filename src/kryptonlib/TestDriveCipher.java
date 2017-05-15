package kryptonlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import kryptonlib.abstraction.Cipher;
import kryptonlib.cipher.Bacon;
import kryptonlib.cipher.Caesar;
import kryptonlib.cipher.FourSquare;
import kryptonlib.tool.ConverterNotations;

/**
 * Created by USER1 on 08.05.2017.
 */
public class TestDriveCipher {
    public static void main(String[] args) {
    	String s = "вот и Ќаступила ƒол√ќ∆даЌЌая зима";
    	Bacon bacon = new Bacon();
    	System.out.println(bacon.decrypt(s, 2));
    	
    	String[] str = {"Hello", "world!"};
    	System.out.println(Arrays.toString( str ) );
    }
}
