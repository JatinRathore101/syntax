// Race Condition — A bug where the program's outcome depends on unpredictable
// thread scheduling. Two threads read/modify shared data simultaneously,
// producing incorrect results.
// Fix: synchronization (see topic 84)

public class Main {
    // Shared counter — accessed by multiple threads simultaneously
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        // Demonstrate the problem: 3 threads each increment counter 1000 times
        // Expected: 3000 — Actual: usually LESS (data is lost due to race)

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                // This is NOT atomic: it's 3 CPU operations:
                //   1. READ  counter from memory
                //   2. ADD   1
                //   3. WRITE back to memory
                // Two threads can read the same value before either writes back
                counter++;
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);
        Thread t3 = new Thread(incrementTask);

        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();  t3.join();

        System.out.println("Expected: 3000");
        System.out.println("Actual:   " + counter); // often less than 3000

        // The problem illustrated step by step:
        // Thread 1 reads counter=500, Thread 2 reads counter=500 (same value!)
        // Thread 1 writes 501, Thread 2 writes 501 — one increment is LOST

        System.out.println();
        System.out.println("Race conditions cause:");
        System.out.println("  - Lost updates (as shown above)");
        System.out.println("  - Stale reads (reading old data)");
        System.out.println("  - Inconsistent state");
        System.out.println("Solution: use 'synchronized' or AtomicInteger (see topic 84)");
    }
}
