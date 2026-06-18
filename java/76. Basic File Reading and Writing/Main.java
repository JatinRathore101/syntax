// Basic File Reading and Writing
// Writing: FileWriter / BufferedWriter / PrintWriter
// Reading: FileReader / BufferedReader / Files (NIO)

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "sample.txt";

        // --- Write to a file ---
        // BufferedWriter wraps FileWriter for efficiency
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, File I/O!");
            writer.newLine();
            writer.write("Line 2: Java file writing.");
            writer.newLine();
            writer.write("Line 3: Done.");
        }
        System.out.println("File written.");

        // --- Read line by line ---
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        }

        // --- Append to existing file ---
        try (BufferedWriter appender = new BufferedWriter(new FileWriter(filePath, true))) {
            appender.newLine();
            appender.write("Line 4: Appended.");
        }

        // --- Read all lines at once (NIO, Java 7+) ---
        List<String> lines = Files.readAllLines(Path.of(filePath));
        System.out.println("All lines (" + lines.size() + "):");
        lines.forEach(l -> System.out.println("  " + l));

        // --- Write all at once (NIO) ---
        Files.writeString(Path.of("output.txt"), "NIO write — simple and clean.");
        System.out.println("output.txt: " + Files.readString(Path.of("output.txt")));

        // Cleanup
        Files.deleteIfExists(Path.of(filePath));
        Files.deleteIfExists(Path.of("output.txt"));
        System.out.println("Files deleted.");
    }
}
