package encryptdecrypt;

public class ShiftAlgorithm extends EncryptDecryptionAlgorithm {
    private static final char[] charAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    char getNewLetter(String letter, int key) {
        boolean isUpperCase = Character.isUpperCase(letter.toCharArray()[0]);
        int oldIndex = getLetterIndex(letter);
        if (oldIndex == -1) {
            return letter.toCharArray()[0];
        }
        int newIndex = oldIndex + key;
        if (newIndex < 0) {
            newIndex = charAlphabet.length + newIndex;
        }
        while (charAlphabet.length < newIndex) {
            newIndex -= charAlphabet.length;
        }

        return isUpperCase ? Character.toUpperCase(charAlphabet[newIndex]) : charAlphabet[newIndex];
    }

    private int getLetterIndex(String letter) {
        for (int i = 0; i < charAlphabet.length; i++) {
            if (charAlphabet[i] == letter.toCharArray()[0]) {
                return i;
            }
        }
        return -1;
    }
}
