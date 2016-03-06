package wordsubtraction;

import java.util.Scanner;

public class WordSubtraction {

    public WordSubtraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        String one = scanner.nextLine();
        System.out.println("Input another string:");
        String two = scanner.nextLine();
        scanner.close();
        System.out.println("Cheers buddy.");

        int oneValue = 0;
        for (char c : one.toCharArray()) {
            oneValue += c;
        }

        int twoValue = 0;
        for (char c : two.toCharArray()) {
            twoValue += c;
        }

        System.out.println("First value: " + oneValue + "\r\nSecond value: " + twoValue + "\r\nDiff: " + (oneValue - twoValue));
    }

    public static void main(String[] args) {
        new WordSubtraction();
    }
}
