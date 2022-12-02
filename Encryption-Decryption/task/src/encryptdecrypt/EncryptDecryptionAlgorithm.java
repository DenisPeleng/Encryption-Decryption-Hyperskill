package encryptdecrypt;

public abstract class EncryptDecryptionAlgorithm {
    public String encryptText(String text, int key) {

        String[] textArr = text.split("");
        String[] encryptedArr = new String[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            char newLetter = getNewLetter(textArr[i], key);
            encryptedArr[i] = String.valueOf(newLetter);

        }
        return String.join("", encryptedArr);
    }


    abstract char getNewLetter(String letter, int key);

    public String decryptText(String text, int key) {

        return encryptText(text, -key);
    }

}