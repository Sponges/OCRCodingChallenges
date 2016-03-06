package namethatnumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// only input allowed is UPPERCASE-LETTERS
public class NameThatNumber {

    private final Map<Character, Integer> charMap = new HashMap<>();

    public NameThatNumber() {
        reallyEfficientMethod();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number:");
        String input = scanner.nextLine();
        scanner.close();

        System.out.print("Phone number: ");
        for (char c : input.toCharArray()) {
            if (c == '-') {
                System.out.print(' ');
                continue;
            }

            System.out.print(charMap.get(c));
        }
        System.out.println();
    }

    private void reallyEfficientMethod() {
        charMap.put('A', 2); charMap.put('B', 2); charMap.put('C', 2);
        charMap.put('D', 3); charMap.put('E', 3); charMap.put('F', 3);
        charMap.put('G', 4); charMap.put('H', 4); charMap.put('I', 4);
        charMap.put('J', 5); charMap.put('K', 5); charMap.put('L', 5);
        charMap.put('M', 6); charMap.put('N', 6); charMap.put('O', 6);
        charMap.put('P', 7); charMap.put('Q', 7); charMap.put('R', 7);charMap.put('S', 7);
        charMap.put('T', 8); charMap.put('U', 8); charMap.put('V', 8);
        charMap.put('W', 9); charMap.put('X', 9); charMap.put('Y', 9);charMap.put('Z', 9);
    }

    public static void main(String[] args) {
        new NameThatNumber();
    }

}
