// throws — Declares that a method CAN throw a checked exception
// Forces the CALLER to either handle it (try-catch) or propagate it (throws)
// throw  (no s) = actually throws an exception
// throws (with s) = declares that an exception might be thrown

import java.io.IOException;

public class Main {

    // Without 'throws' — must handle checked exceptions internally
    // With    'throws' — passes the responsibility to the caller

    // This method declares it might throw IOException (checked)
    static void readConfig(String path) throws IOException {
        if (!path.endsWith(".cfg")) {
            throw new IOException("Invalid config file: " + path);
        }
        System.out.println("Reading config: " + path);
    }

    // Chain: parseConfig calls readConfig, so it also needs to declare/catch
    static void parseConfig(String path) throws IOException {
        readConfig(path);          // just propagates; doesn't catch
        System.out.println("Config parsed successfully.");
    }

    // Can declare multiple exception types
    static void riskyMethod() throws IOException, IllegalArgumentException {
        // might do either
    }

    public static void main(String[] args) {
        // Caller MUST handle the declared checked exception
        try {
            parseConfig("settings.cfg");
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Provide invalid file to trigger the exception
        try {
            parseConfig("settings.txt");
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Unchecked exceptions (RuntimeException) do NOT need 'throws' declaration
        // They can be thrown at any time without compile-time enforcement
        try {
            throw new RuntimeException("unchecked — no 'throws' needed");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
