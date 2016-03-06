package hackproof;

import java.io.*;
import java.util.Scanner;

// "hack proof"
public class HackProof {

    public HackProof() {
        Scanner scanner = new Scanner(System.in);

        {
            File file = new File("document.txt");
            if (!file.exists()) {
                try {
                    write(file, "Yo this is an empty document.\n");
                } catch (IOException e) {
                    System.out.println("Could not write default contents to \"document.txt\"!");
                    e.printStackTrace();
                    scanner.close();
                    return;
                }
            }
        }

        {
            File file = new File("credentials.txt");
            if (!file.exists()) {
                System.out.println("No credentials exist! Please enter a new username:");
                String username = scanner.nextLine();
                System.out.println("Ok, username set to \"" + username + "\"! Now set your password:");
                String password = scanner.nextLine();
                System.out.println("Verify your password by repeating it:");
                String verifiedPassword = scanner.nextLine();
                if (!verifiedPassword.equalsIgnoreCase(password)) {
                    System.out.println("Passwords did not match! Exiting.");
                    scanner.close();
                    return;
                }
                try {
                    write(file, "user=" + username + "\r\npass=" + password);
                } catch (IOException e) {
                    System.out.println("Something went wrong when writing to the file :L");
                    e.printStackTrace();
                    scanner.close();
                    return;
                }
                System.out.println("Success!");
            }
        }

        {
            File file = new File("credentials.txt");
            String content;
            try {
                content = read(file);
            } catch (IOException e) {
                System.out.println("Something went wrong when reading from the file :L");
                e.printStackTrace();
                scanner.close();
                return;
            }
            String[] credentials = content.split("\r\n");
            String username = credentials[0];
            username = username.substring(username.indexOf("=") + 1);
            String password = credentials[1];
            password = password.substring(password.indexOf("=") + 1);
            System.out.println("Username:");
            String inputtedUsername = scanner.nextLine();
            if (!inputtedUsername.equals(username)) {
                System.out.println("Invalid username \"" + username + "\"! Cya.");
                scanner.close();
                return;
            }
            System.out.println("Password:");
            String inputtedPassword = scanner.nextLine();
            if (!inputtedPassword.equals(password)) {
                System.out.println("Invalid password \"" + password + "\"! Cya.");
                scanner.close();
                return;
            }
            System.out.println("Access granted! File contents:\r\n");
        }

        {
            File file = new File("document.txt");
            String content;
            try {
                content = read(file);
            } catch (IOException e) {
                System.out.println("Something went wrong whilst accessing \"document.txt\"!");
                e.printStackTrace();
                scanner.close();
                return;
            }
            System.out.println(content);
        }
        scanner.close();
    }

    private void write(File file, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }

    private String read(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String input;
        while ((input = reader.readLine()) != null) {
            content.append(input).append("\r\n");
        }
        reader.close();
        return content.toString();
    }

    public static void main(String[] args) {
        new HackProof();
    }

}
