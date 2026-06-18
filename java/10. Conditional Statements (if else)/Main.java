// Conditional Statements - Execute different code blocks based on conditions

public class Main {
    public static void main(String[] args) {
        // Simple if — runs only when condition is true
        int temperature = 28;
        if (temperature > 30) {
            System.out.println("It's hot outside.");
        }

        // if-else — one of two blocks runs
        int number = -5;
        if (number >= 0) {
            System.out.println(number + " is positive or zero");
        } else {
            System.out.println(number + " is negative");
        }

        // if - else if - else (ladder) — exactly one block runs
        int score = 72;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // Nested if — condition inside another condition
        boolean isLoggedIn = true;
        boolean isAdmin    = false;
        if (isLoggedIn) {
            if (isAdmin) {
                System.out.println("Welcome, Admin!");
            } else {
                System.out.println("Welcome, User!");
            }
        } else {
            System.out.println("Please log in.");
        }
    }
}
