package kryptonlib.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kryptonlib.abstraction.Hash;

/**
 * Created by lophtpicker on 09.05.2017.
 */
public class MD5 extends Hash {
    public static String md5Custom(String st)  {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ) 
            md5Hex = "0" + md5Hex;
        return md5Hex;
    }
    
    private static void processArguments(String st) {
    	if (st == null)
    		throw new IllegalArgumentException("data");
    }
}
