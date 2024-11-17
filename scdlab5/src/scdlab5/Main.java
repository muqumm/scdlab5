package scdlab5;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        APlab5 APlab5 = new APlab5();
        // Start the thread
        APlab5.start();
        // Wait for the thread to finish
        try {
            APlab5.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class APlab5 extends Thread {
    private volatile boolean running = true;

    public void stopPrinting() {
        running = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        while (running && count < 26) {
            // Generate a random number between 0 and 25
            int randomIndex = random.nextInt(26);
            // Convert the random number to a character (A-Z)
            char alphabet = (char) ('A' + randomIndex);
            // Print the character
            System.out.print(alphabet + " ");
            // Increment the count
            count++;
            // Sleep for a random time between 100ms to 500ms
            try {
                Thread.sleep(random.nextInt(401) + 100); // Sleep between 100ms and 500ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nFinished printing alphabets.");
    }
}