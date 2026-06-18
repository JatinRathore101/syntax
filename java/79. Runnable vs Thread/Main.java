// Runnable vs Thread
// Thread:   extend Thread class — simpler but blocks further inheritance (Java is single-inheritance)
// Runnable: implement Runnable interface — preferred; separates task from thread mechanism

// --- Approach 1: Extend Thread ---
class DownloadTask extends Thread {
    String url;

    DownloadTask(String url) {
        super("Download-" + url);
        this.url = url;
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Downloading: " + url);
    }
}

// --- Approach 2: Implement Runnable ---
class UploadTask implements Runnable {
    String fileName;

    UploadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Uploading: " + fileName);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Using Thread subclass
        DownloadTask dt = new DownloadTask("image.png");
        dt.start();

        // Using Runnable — thread wraps the task
        UploadTask ut = new UploadTask("report.pdf");
        Thread uploadThread = new Thread(ut, "Upload-report");
        uploadThread.start();

        // Runnable with anonymous class (old style)
        Thread t1 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Anonymous Runnable: " + Thread.currentThread().getName());
            }
        }, "Anonymous-Thread");
        t1.start();

        // Runnable with lambda (modern, preferred)
        Thread t2 = new Thread(() ->
            System.out.println("Lambda Runnable: " + Thread.currentThread().getName()),
            "Lambda-Thread"
        );
        t2.start();

        dt.join(); uploadThread.join(); t1.join(); t2.join();

        // Summary:
        // Use Runnable/lambda — clean, composable, works with ExecutorService
        // Avoid extending Thread unless you truly need Thread-specific customization
        System.out.println("All tasks done.");
    }
}
