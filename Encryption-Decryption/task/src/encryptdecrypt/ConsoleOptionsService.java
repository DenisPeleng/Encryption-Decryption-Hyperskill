package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleOptionsService {
    public static void start(String[] args) {
        boolean isConsoleOutput = true;
        boolean isFileInput = false;
        boolean isConsoleInput = false;
        String mode = "";
        int key = 0;
        String text = "";
        String alg = "shift";
        String filePathOutput = "";
        String filePathInput = "";
        EncryptDecryptionAlgorithm encDecAlgorithm = new ShiftAlgorithm();
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-mode")) {
                i++;
                mode = args[i];
            } else if (args[i].contains("-alg")) {
                i++;
                alg = args[i];
            } else if (args[i].contains("-key")) {
                i++;
                key = Integer.parseInt(args[i]);
            } else if (args[i].contains("-data")) {
                i++;
                isConsoleInput = true;
                text = args[i];
            } else if (args[i].contains("-in")) {
                i++;
                isFileInput = true;
                filePathInput = args[i];
            } else if (args[i].contains("-out")) {
                i++;
                isConsoleOutput = false;
                filePathOutput = args[i];
            }
        }
if (alg.equalsIgnoreCase("unicode")){
    encDecAlgorithm = new UnicodeAlgorithm();
}
        if (isFileInput) {
            Scanner scanner;
            try {
                scanner = new Scanner(new File(filePathInput));
            } catch (FileNotFoundException e) {
                System.out.println("Error");
                return;
            }
            text = scanner.nextLine();
        }
        if (isConsoleInput == isFileInput || text.isEmpty()) {
            System.out.println("Error");
            return;
        }

        String result = "";
        switch (mode) {
            case "enc" -> result = encDecAlgorithm.encryptText(text, key);
            case "dec" -> result = encDecAlgorithm.decryptText(text, key);
            default -> System.out.println("Error");
        }
        if (isConsoleOutput) {
            System.out.println(result);
        } else {
            try (FileWriter writer = new FileWriter(filePathOutput, false)) {
                writer.write(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
