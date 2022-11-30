package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        System.out.println(EncryptService.encryptText(text, key));
    }
}
