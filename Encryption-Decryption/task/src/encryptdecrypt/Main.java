package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOperation = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        switch (typeOperation) {
            case "enc" -> System.out.println(EncryptDecryptionService.encryptText(text, key));
            case "dec" -> System.out.println(EncryptDecryptionService.decryptText(text, key));
            default -> System.out.println("Wrong input");
        }
    }
}
