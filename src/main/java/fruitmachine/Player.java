package fruitmachine;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {

    // unnecessary thread safety, should rly make it volatile anyway
    private final AtomicInteger plays = new AtomicInteger(0);

    private double earnings = 0;
    private double losses = 0;

    private double balance;
    private double peak;

    public Player(double balance) {
        this.balance = balance;
        this.peak = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

        if (this.balance > peak) {
            peak = this.balance;
        }
    }

    public AtomicInteger getPlays() {
        return plays;
    }

    public double getEarnings() {
        return earnings;
    }

    public void addEarnings(double earnings) {
        this.earnings += earnings;
    }

    public double getLosses() {
        return losses;
    }

    public void addLosses(double losses) {
        this.losses += losses;
    }

    public double getPeak() {
        return peak;
    }
}
