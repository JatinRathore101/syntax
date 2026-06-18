// Thread.sleep() — Pauses the CURRENT thread for a specified time
// Thread moves to TIMED_WAITING state during sleep
// Throws InterruptedException if another thread interrupts it

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        // Sleep for 500 milliseconds
        Thread.sleep(500);
        System.out.println("After 500ms sleep");

        // Sleep in a loop — countdown timer
        System.out.print("Countdown: ");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
            Thread.sleep(100); // pause between prints
        }
        System.out.println("Go!");

        // sleep() in a background thread
        Thread backgroundTask = new Thread(() -> {
            try {
                System.out.println("Background: started");
                Thread.sleep(300);
                System.out.println("Background: done after 300ms");
            } catch (InterruptedException e) {
                // Handle interruption gracefully
                System.out.println("Background: interrupted!");
                Thread.currentThread().interrupt(); // re-set the interrupt flag
            }
        });

        backgroundTask.start();

        // Interrupt the sleeping thread early
        Thread.sleep(100);
        backgroundTask.interrupt();

        backgroundTask.join();
        System.out.println("Main: finished.");

        // Note:
        // sleep() releases NO locks — other threads cannot enter synchronized blocks
        //         that this thread holds during sleep
        // yield() is a hint to the scheduler to give other threads a turn (rarely used)
    }
}
