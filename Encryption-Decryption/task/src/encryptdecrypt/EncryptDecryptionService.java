package encryptdecrypt;

public class EncryptDecryptionService {
    public static String encryptText(String text, int key) {

        String[] textArr = text.split("");
        String[] encryptedArr = new String[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            char newLetter = getNewLetter(textArr[i], key);
            encryptedArr[i] = String.valueOf(newLetter);

        }
        return String.join("", encryptedArr);
    }

    private static char getNewLetter(String letter, int key) {
        char character = letter.toCharArray()[0];
        return (char) ((int) character + key);
    }

    public static String decryptText(String text, int key) {

        return encryptText(text, -key);
    }

}