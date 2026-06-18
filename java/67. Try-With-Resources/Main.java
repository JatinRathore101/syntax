// Try-With-Resources (Java 7+) — Automatically closes resources after the try block
// Resources must implement AutoCloseable (or Closeable)
// No need for explicit finally block to close streams, connections, etc.

import java.io.*;

// Custom AutoCloseable resource
class DatabaseConnection implements AutoCloseable {
    String url;

    DatabaseConnection(String url) {
        this.url = url;
        System.out.println("Connection opened: " + url);
    }

    void query(String sql) {
        System.out.println("Executing: " + sql);
    }

    @Override
    public void close() {
        System.out.println("Connection closed: " + url);
    }
}

public class Main {
    public static void main(String[] args) {
        // Without try-with-resources — must manually close in finally
        // (old style, verbose and error-prone)
        DatabaseConnection conn1 = null;
        try {
            conn1 = new DatabaseConnection("db://old-style");
            conn1.query("SELECT * FROM users");
        } finally {
            if (conn1 != null) conn1.close();
        }

        System.out.println();

        // With try-with-resources — close() called automatically
        try (DatabaseConnection conn = new DatabaseConnection("db://try-with-resources")) {
            conn.query("SELECT * FROM products");
            // conn.close() is called automatically here, even if an exception is thrown
        }

        System.out.println();

        // Multiple resources — closed in REVERSE order of declaration
        try (DatabaseConnection db1 = new DatabaseConnection("db://primary");
             DatabaseConnection db2 = new DatabaseConnection("db://replica")) {
            db1.query("INSERT INTO log VALUES(...)");
            db2.query("SELECT * FROM log");
        }
        // db2.close() then db1.close() — reverse order

        System.out.println();

        // Real-world: reading a file with BufferedReader
        try (BufferedReader reader = new BufferedReader(new StringReader("line1\nline2\nline3"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
