// Thread Lifecycle and States
//
// NEW        → created with 'new Thread()', not yet started
// RUNNABLE   → running or ready to run (after start())
// BLOCKED    → waiting to acquire a synchronized lock
// WAITING    → waiting indefinitely (wait(), join() with no timeout)
// TIMED_WAITING → waiting for a specific time (sleep(), join(ms), wait(ms))
// TERMINATED → run() has finished

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("  State inside run(): " +
                               Thread.currentThread().getState()); // RUNNABLE
            try {
                Thread.sleep(200); // moves to TIMED_WAITING
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Demo-Thread");

        // NEW — created but not started
        System.out.println("After new:   " + t.getState());   // NEW

        t.start();
        // RUNNABLE — started
        System.out.println("After start: " + t.getState());   // RUNNABLE

        Thread.sleep(50); // give t time to enter sleep
        // TIMED_WAITING — inside sleep()
        System.out.println("During sleep: " + t.getState());  // TIMED_WAITING

        t.join(); // wait for t to finish
        // TERMINATED — run() returned
        System.out.println("After finish: " + t.getState());  // TERMINATED

        System.out.println();
        System.out.println("State summary:");
        System.out.println("  NEW            → Thread created, start() not called yet");
        System.out.println("  RUNNABLE       → Running or waiting for CPU");
        System.out.println("  BLOCKED        → Waiting to enter a synchronized block");
        System.out.println("  WAITING        → Waiting for notify() or join()");
        System.out.println("  TIMED_WAITING  → Waiting with timeout (sleep, join(ms))");
        System.out.println("  TERMINATED     → run() method has completed");
    }
}
