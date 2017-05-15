package kryptonlib.tool;

import java.math.BigInteger;

/**
 * Created by USER1 on 09.05.2017.
 */
public final class ConverterNotations {
    public static String decimalToBinary(long val) {
        return Long.toString(val, 2);
    }

    public static String decimalToOctal(long val) {
        return Long.toString(val, 8);
    }

    public static String decimalToHex(long val) {
        return Long.toString(val, 16);
    }
    
    public static long binToDec(String bin) {
    	int position = bin.length() - 1;
    	BigInteger b = BigInteger.ZERO;
    	BigInteger osnovanie = BigInteger.valueOf(2);
    	
    	for (int i = 0; i < bin.length(); i++) {
    		if ( bin.charAt(i) == '1') 
    			b = b.add( osnovanie.pow(position) );
    		position-=1;
    	}
    	return b.longValue();
    }
}
