// Do-While Loop — Executes the body AT LEAST ONCE, then checks the condition
// Syntax: do { body } while (condition);

public class Main {
    public static void main(String[] args) {
        // Basic do-while
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 5);
        System.out.println();

        // Key difference: do-while runs at least once even if condition is false
        int x = 10;
        while (x < 5) {
            System.out.println("while: this never prints");
        }
        do {
            System.out.println("do-while: runs once even though x=" + x + " < 5 is false");
        } while (x < 5);

        // Classic use-case: menu-driven programs
        // (here we simulate user input with a variable)
        int choice;
        int attempt = 0;
        do {
            attempt++;
            choice = (attempt < 3) ? 0 : 3; // simulate: user enters 3 on 3rd try
            System.out.println("Attempt " + attempt + " → choice: " + choice);
        } while (choice != 3);
        System.out.println("Valid choice selected!");

        // Sum 1 to 5
        int n = 1, sum = 0;
        do {
            sum += n;
            n++;
        } while (n <= 5);
        System.out.println("Sum 1-5 = " + sum); // 15
    }
}
