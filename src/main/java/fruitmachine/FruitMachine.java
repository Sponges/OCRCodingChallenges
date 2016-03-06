package fruitmachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

// this whole class needs a lot of improvement
public class FruitMachine {

    private static final DecimalFormat DISPLAY_FORMAT = new DecimalFormat("###.##");
    private static final char[] FRUITS = {
            'C', 'B', 'L', 'O', 'S', 'K'
    };

    private final Player player;

    private Scanner scanner;

    public FruitMachine() {
        this.player = new Player(10.00);

        scanner = new Scanner(System.in);
        String input;
        try {
            while ((input = scanner.nextLine()) != null) {
                try {
                    processInput(input);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IllegalStateException ignored) {}
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void processInput(String input) throws InterruptedException {
        switch (input.toLowerCase()) {
            case "": {
                go();
                break;
            }

            case "win": {
                while (!go());
                break;
            }

            case "win 10": {
                float start = System.currentTimeMillis();
                while ((System.currentTimeMillis() - start) / 1000 < 10) {
                    Thread.sleep(50);
                    go();
                }
                break;
            }

            case "exit": {
                System.out.println("Bye lol");
                scanner.close();
                break;
            }

            default: {
                System.out.println("Invalid input \"" + input + "\"!");
            }
        }
    }

    private boolean go() {
        player.getPlays().incrementAndGet();

        Random random = new Random();
        char[] chars = select(random, 3);
        double balance = player.getBalance();

        if (balance <= 0) {
            System.out.println("Out of money! " + String.format("\nTurns: %s\nWinnings: %s\nLosses: %s\nPeak balance: %s",
                    player.getPlays().get(), format(player.getEarnings()), format(player.getLosses()), format(player.getPeak())));
            scanner.close();
            return true;
        }

        player.setBalance(balance - 0.20);
        player.addLosses(0.20);

        double winnings = 0;
        boolean jackpot = false;
        boolean won = false;

        if (chars[0] == chars[1] && chars[1] == chars[2]) {
            if (chars[0] == 'B') {
                winnings = 20.00;
                jackpot = true;
            } else {
                winnings = 3.00;
                won = true;
            }
        } else if (chars[0] == chars[1] || chars[0] == chars[2]) {
            winnings = 1.00;
        }

        player.setBalance(player.getBalance() + winnings);
        player.addEarnings(winnings);
        System.out.printf("[%s][%s][%s] - $%s\n", chars[0], chars[1], chars[2], format(player.getBalance()));

        if (jackpot) {
            System.out.println("" +
                      "===========================" +
                    "\n=                         =" +
                    "\n=         JACKPOT         =" +
                    "\n=         $20.00          =" +
                    "\n=                         =" +
                    "\n===========================");
        }

        return won;
    }

    private char[] select(Random random, int amount) {
        char[] chars = new char[amount];

        for (int i = 0; i < amount; i++) {
            int rand = random.nextInt(FRUITS.length);
            chars[i] = FRUITS[rand];
        }

        return chars;
    }

    private double format(double d) {
        return new BigDecimal(d).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        new FruitMachine();
    }

}
