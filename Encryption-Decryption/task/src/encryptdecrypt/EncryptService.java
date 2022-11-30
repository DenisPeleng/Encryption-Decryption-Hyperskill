package encryptdecrypt;

public class EncryptService {
    private static final String[] ALPHABETARRAY = "abcdefghijklmnopqrstuvwxyz".split("");

    public static String encryptText(String text, int key) {

        String[] textArr = text.split("");
        String[] encryptedArr = new String[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            if (String.valueOf(textArr[i]).matches("\\w")) {
                int indexNewLetter = getNewLetterIndex(textArr[i], key);
                encryptedArr[i] = ALPHABETARRAY[indexNewLetter];
            } else {
                encryptedArr[i] = textArr[i];
            }
        }
        return String.join("", encryptedArr);
    }

    private static int getLetterIndex(String letter) {
        int index = 0;
        for (int i = 0; i < ALPHABETARRAY.length; i++) {
            if (ALPHABETARRAY[i].contains(letter)) {
                return i;
            }
        }
        return index;
    }

    private static int getNewLetterIndex(String letter, int key) {
        int oldIndex = getLetterIndex(letter);
        int newIndex = oldIndex + key;
        while (ALPHABETARRAY.length < newIndex) {
            newIndex -= ALPHABETARRAY.length;
        }
        return newIndex;
    }
}
