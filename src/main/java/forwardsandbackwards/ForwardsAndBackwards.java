package forwardsandbackwards;

import java.util.Scanner;

public class ForwardsAndBackwards {

    public ForwardsAndBackwards() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your string:");
        String input = scanner.nextLine();
        scanner.close();
        String backwards = new StringBuilder(input).reverse().toString();
        if (backwards.equals(input)) {
            System.out.println("Backwards is same as forwards!");
        } else {
            System.out.println("Backwards is not same as forwards!");
        }
    }

    public static void main(String[] args) {
        new ForwardsAndBackwards();
    }

}
