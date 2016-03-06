package codeitup;

import java.util.Scanner;

public class CodeItUp {

    public CodeItUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your input string:");
        String input = scanner.nextLine();
        scanner.close();
        for (char c : input.toCharArray()) {
            System.out.print((char)((int)c+25));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new CodeItUp();
    }
}
