// Switch Statement — Selects one of many code blocks to execute based on a value
// Works with: int, char, String, enum (and their wrappers)

public class Main {
    public static void main(String[] args) {
        // Traditional switch — 'break' prevents fall-through to next case
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday");    break;
            case 2: System.out.println("Tuesday");   break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday");  break;
            case 5: System.out.println("Friday");    break;
            default: System.out.println("Weekend");  // runs if no case matches
        }

        // Switch with String
        String season = "summer";
        switch (season) {
            case "spring": System.out.println("Flowers bloom");  break;
            case "summer": System.out.println("Hot and sunny");  break;
            case "autumn": System.out.println("Leaves fall");    break;
            case "winter": System.out.println("Cold and snowy"); break;
            default:       System.out.println("Unknown season");
        }

        // Fall-through (no break) — multiple cases share one block
        int x = 2;
        switch (x) {
            case 1:
            case 2:
            case 3:
                System.out.println("x is 1, 2, or 3"); // triggers for 1, 2, or 3
                break;
            default:
                System.out.println("x is something else");
        }

        // Switch Expression (Java 14+) — no break needed, returns a value
        int month = 4;
        String monthName = switch (month) {
            case 1  -> "January";
            case 2  -> "February";
            case 3  -> "March";
            case 4  -> "April";
            default -> "Other";
        };
        System.out.println("Month: " + monthName);
    }
}
