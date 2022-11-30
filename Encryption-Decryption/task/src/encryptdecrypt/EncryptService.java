package encryptdecrypt;

public class EncryptService {
    public static String encryptText(String text) {
        char[] textChrArr = text.toCharArray();
        char[] encryptedArr = new char[textChrArr.length];
        for (int i = 0; i < textChrArr.length; i++) {
            if (String.valueOf(textChrArr[i]).matches("\\w")) {
                int diff = (textChrArr[i] - 'a');
                encryptedArr[i] = (char) ('z' - diff);
            } else {
                encryptedArr[i] = textChrArr[i];
            }
        }
        return new String(encryptedArr);
    }
}
