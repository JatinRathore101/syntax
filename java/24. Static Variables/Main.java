// Static Variables — Belong to the CLASS, shared by ALL instances
// There is only ONE copy in memory regardless of how many objects exist

class Counter {
    int instanceCount;          // instance variable — unique per object
    static int totalCreated;    // static variable — ONE shared copy for all

    Counter() {
        instanceCount = 0;
        totalCreated++;          // increments the single shared counter
    }

    void increment() { instanceCount++; }
}

class AppConfig {
    // Static constants — shared, immutable class-level values
    static final String APP_NAME    = "MyApp";
    static final String VERSION     = "1.0.0";
    static final int    MAX_RETRIES = 3;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Before creation: " + Counter.totalCreated); // 0

        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        System.out.println("After 3 objects: " + Counter.totalCreated); // 3

        c1.increment();
        c1.increment();
        c2.increment();

        // instanceCount is per-object (different for each)
        System.out.println("c1.instanceCount: " + c1.instanceCount); // 2
        System.out.println("c2.instanceCount: " + c2.instanceCount); // 1
        System.out.println("c3.instanceCount: " + c3.instanceCount); // 0

        // Static accessed via class name (best practice)
        System.out.println("Total: " + Counter.totalCreated);        // 3

        // Static constants — no object needed
        System.out.println(AppConfig.APP_NAME + " v" + AppConfig.VERSION);
        System.out.println("Max retries: " + AppConfig.MAX_RETRIES);
    }
}
