// Scanner — Reads input from console, files, or strings
// Most common way to read user input in Java console applications
// import java.util.Scanner

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner reading from a String (safe to run without real stdin)
        // In a real app: new Scanner(System.in) reads from keyboard
        Scanner sc = new Scanner("Alice\n25\n175.5\ntrue");

        // Read different types
        String name   = sc.nextLine();    // reads whole line
        int    age    = sc.nextInt();     // reads integer
        double height = sc.nextDouble();  // reads decimal
        boolean flag  = sc.nextBoolean(); // reads true/false

        System.out.println("Name:   " + name);
        System.out.println("Age:    " + age);
        System.out.println("Height: " + height);
        System.out.println("Flag:   " + flag);

        sc.close();

        System.out.println();

        // Scanner reading multiple values on one line
        Scanner sc2 = new Scanner("10 20 30 40 50");
        int sum = 0;
        while (sc2.hasNextInt()) {
            sum += sc2.nextInt();
        }
        System.out.println("Sum: " + sum); // 150
        sc2.close();

        System.out.println();

        // Scanner reading CSV
        Scanner sc3 = new Scanner("apple,banana,cherry").useDelimiter(",");
        while (sc3.hasNext()) {
            System.out.println("Fruit: " + sc3.next());
        }
        sc3.close();

        // In a real interactive program:
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter name: ");
        // String name = sc.nextLine();
        // sc.close();
    }
}
