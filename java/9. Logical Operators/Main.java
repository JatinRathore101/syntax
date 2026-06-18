// Logical Operators - Combine multiple boolean expressions
// && (AND), || (OR), ! (NOT)

public class Main {
    public static void main(String[] args) {
        // AND (&&) — true only if BOTH sides are true
        System.out.println("true  && true  = " + (true  && true));   // true
        System.out.println("true  && false = " + (true  && false));  // false
        System.out.println("false && true  = " + (false && true));   // false

        // OR (||) — true if AT LEAST ONE side is true
        System.out.println("true  || false = " + (true  || false));  // true
        System.out.println("false || false = " + (false || false));  // false

        // NOT (!) — inverts the boolean value
        System.out.println("!true  = " + !true);   // false
        System.out.println("!false = " + !false);  // true

        // Short-circuit evaluation:
        // && stops if left side is false (right side not evaluated)
        // || stops if left side is true  (right side not evaluated)
        int x = 0;
        if (x != 0 && (10 / x > 1)) {
            System.out.println("this won't run");
        } else {
            System.out.println("Short-circuit && avoided division by zero");
        }

        // Practical example: user authentication
        int age      = 20;
        boolean hasID = true;
        if (age >= 18 && hasID) {
            System.out.println("Entry allowed");
        }

        boolean isWeekend = true;
        boolean isHoliday = false;
        if (isWeekend || isHoliday) {
            System.out.println("Day off!");
        }
    }
}
