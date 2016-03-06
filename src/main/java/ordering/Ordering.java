package ordering;

import java.util.Arrays;
import java.util.Scanner;

public class Ordering {

    public Ordering() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 10 numbers! (one at a time)");
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Thanks. Your numbers: " + Arrays.toString(numbers));
        scanner.close();

        System.out.print("Acceding order: ");
        Arrays.sort(numbers);
        String toPrint = Arrays.toString(numbers);
        toPrint = toPrint.substring(1, toPrint.length() - 1);
        System.out.println(toPrint);

        System.out.print("Descending order: ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(i);
            if (i > 0) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Ordering();
    }
}
