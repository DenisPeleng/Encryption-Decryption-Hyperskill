package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String mode = "";
        int key = 0;
        String text = "";
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].contains("-mode")) {
                mode = args[i + 1];
            } else if (args[i].contains("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].contains("-data")) {
                text = args[i + 1];
            }
        }
        switch (mode) {
            case "enc" -> System.out.println(EncryptDecryptionService.encryptText(text, key));
            case "dec" -> System.out.println(EncryptDecryptionService.decryptText(text, key));
            default -> System.out.println("Wrong input");
        }
    }
}
