// Threads — Lightweight sub-processes; allow concurrent execution
// Java provides Thread class and Runnable interface
// JVM is multi-threaded by default (e.g., garbage collector runs in a separate thread)

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Way 1: Extend Thread class
        class MyThread extends Thread {
            String taskName;
            MyThread(String name) { this.taskName = name; }

            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(taskName + " - step " + i +
                                       " [" + Thread.currentThread().getName() + "]");
                }
            }
        }

        // Way 2: Implement Runnable (preferred — allows extending other classes)
        Runnable printTask = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Runnable - step " + i +
                                   " [" + Thread.currentThread().getName() + "]");
            }
        };

        Thread t1 = new MyThread("Thread-A");
        Thread t2 = new Thread(printTask, "Thread-B");

        // start() — creates a new OS thread and calls run() on it
        // run()   — does NOT create a new thread; runs in current thread
        t1.start();
        t2.start();

        // join() — main thread waits for t1 and t2 to finish
        t1.join();
        t2.join();

        System.out.println("Both threads finished.");

        // Thread metadata
        System.out.println("Thread count: " + Thread.activeCount());
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }
}
