package encryptdecrypt;

public class UnicodeAlgorithm extends EncryptDecryptionAlgorithm {

    @Override
    char getNewLetter(String letter, int key) {
        char character = letter.toCharArray()[0];
        return (char) ((int) character + key);
    }
}
