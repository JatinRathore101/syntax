// Synchronization — Ensure only ONE thread executes a critical section at a time
// synchronized keyword acquires an object's monitor lock
// Fixes race conditions at the cost of some performance

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // --- Option 1: synchronized method ---
    static int counter = 0;

    static synchronized void increment() {
        counter++; // only one thread can be in here at a time
    }

    // --- Option 2: synchronized block (finer control) ---
    static int blockCounter = 0;
    static final Object LOCK = new Object();

    static void incrementWithBlock() {
        // Only the critical section is locked, not the whole method
        synchronized (LOCK) {
            blockCounter++;
        }
    }

    // --- Option 3: AtomicInteger (most efficient for simple counters) ---
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> { for (int i = 0; i < 1000; i++) increment(); };
        Runnable task2 = () -> { for (int i = 0; i < 1000; i++) incrementWithBlock(); };
        Runnable task3 = () -> { for (int i = 0; i < 1000; i++) atomicCounter.incrementAndGet(); };

        // Test synchronized method
        Thread[] t1 = new Thread[3];
        for (int i = 0; i < 3; i++) t1[i] = new Thread(task1);
        for (Thread t : t1) t.start();
        for (Thread t : t1) t.join();
        System.out.println("synchronized method: " + counter); // always 3000

        // Test synchronized block
        Thread[] t2 = new Thread[3];
        for (int i = 0; i < 3; i++) t2[i] = new Thread(task2);
        for (Thread t : t2) t.start();
        for (Thread t : t2) t.join();
        System.out.println("synchronized block:  " + blockCounter); // always 3000

        // Test AtomicInteger
        Thread[] t3 = new Thread[3];
        for (int i = 0; i < 3; i++) t3[i] = new Thread(task3);
        for (Thread t : t3) t.start();
        for (Thread t : t3) t.join();
        System.out.println("AtomicInteger:       " + atomicCounter.get()); // always 3000
    }
}
