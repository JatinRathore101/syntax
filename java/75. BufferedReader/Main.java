// BufferedReader — Efficient character-based input with buffering
// Faster than Scanner for large inputs (competitive programming, file reading)
// Wraps an InputStreamReader (for System.in) or FileReader (for files)

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Reading from a String (simulates file/stdin reading)
        String input = "Alice\n30\nNew York\nSoftware Engineer\n";
        BufferedReader br = new BufferedReader(new StringReader(input));

        String name       = br.readLine(); // reads one line
        int    age        = Integer.parseInt(br.readLine()); // parse manually
        String city       = br.readLine();
        String profession = br.readLine();

        System.out.println("Name:       " + name);
        System.out.println("Age:        " + age);
        System.out.println("City:       " + city);
        System.out.println("Profession: " + profession);
        br.close();

        System.out.println();

        // Read all lines until null
        String multiLine = "Line 1\nLine 2\nLine 3\nLine 4";
        BufferedReader br2 = new BufferedReader(new StringReader(multiLine));
        String line;
        int lineNum = 1;
        while ((line = br2.readLine()) != null) {  // null = end of input
            System.out.println(lineNum++ + ": " + line);
        }
        br2.close();

        System.out.println();

        // BufferedReader for reading System.in (real keyboard input)
        // BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // String userInput = stdin.readLine();

        // Tip: BufferedReader vs Scanner
        // BufferedReader: faster, lower overhead, returns String (parse manually)
        // Scanner:        slower, more convenient methods (nextInt, nextDouble, etc.)
        System.out.println("BufferedReader is ideal for fast line-by-line reading.");
    }
}
