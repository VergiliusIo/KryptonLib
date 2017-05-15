package kryptonlib.cipher;

/**
 * Created by USER1 on 08.05.2017.
 */
public class Rot13 extends Caesar {
    public String encrypt(String plaintext) {
        return super.encrypt(plaintext, 13);
    }

    public String decrypt(String ciphertext) {
        return super.decrypt(ciphertext, 13);
    }
}
