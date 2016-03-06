package yearaddition;

import java.util.Scanner;

public class YearAddition {

    public YearAddition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the year:");
        String input = scanner.nextLine();
        scanner.close();

        int total = 0;
        for (char c : input.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(c));
            total += i;
        }

        System.out.println("Added: " + total);
    }

    public static void main(String[] args) {
        new YearAddition();
    }

}
