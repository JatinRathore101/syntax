// Multiple Threads — Run several threads concurrently
// Each thread gets its own call stack; they share heap memory
// Order of execution is non-deterministic (managed by the OS scheduler)

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create 5 threads each doing a different task
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + id + " started  [" +
                                   Thread.currentThread().getName() + "]");
                // Simulate work proportional to thread id
                for (int j = 0; j < id * 2; j++) {
                    // busy work
                }
                System.out.println("Thread " + id + " finished [" +
                                   Thread.currentThread().getName() + "]");
            }, "Worker-" + id);
        }

        // Start all threads
        for (Thread t : threads) t.start();

        // Wait for all to finish before continuing
        for (Thread t : threads) t.join();

        System.out.println("All " + threads.length + " threads completed.");
        System.out.println();

        // Threads sharing a counter (demonstrates the need for synchronization)
        // See topic 84 (Synchronization) for the safe version
        int[] counter = {0}; // array trick to use in lambda
        Thread[] counters = new Thread[3];
        for (int i = 0; i < 3; i++) {
            counters[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) counter[0]++;
            });
        }
        for (Thread t : counters) t.start();
        for (Thread t : counters) t.join();

        // Result may be < 15 due to race condition (threads reading stale value)
        System.out.println("Counter (unsynchronized, might not be 15): " + counter[0]);
    }
}
