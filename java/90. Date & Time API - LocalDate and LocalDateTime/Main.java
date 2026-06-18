// Date & Time API (Java 8+) — java.time package
// LocalDate:     date only (year, month, day) — no time, no timezone
// LocalTime:     time only (hour, min, sec)
// LocalDateTime: date + time — no timezone
// ZonedDateTime: date + time + timezone
// These are IMMUTABLE — operations return new instances

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // --- LocalDate ---
        LocalDate today     = LocalDate.now();
        LocalDate birthday  = LocalDate.of(1995, 6, 15);
        LocalDate tomorrow  = today.plusDays(1);
        LocalDate lastMonth = today.minusMonths(1);

        System.out.println("Today:      " + today);
        System.out.println("Birthday:   " + birthday);
        System.out.println("Tomorrow:   " + tomorrow);
        System.out.println("Last month: " + lastMonth);

        System.out.println("Year:  " + today.getYear());
        System.out.println("Month: " + today.getMonth());        // JUNE
        System.out.println("Day:   " + today.getDayOfWeek());    // MONDAY, etc.

        // Days between two dates
        long daysBetween = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("Days since birthday: " + daysBetween);

        // --- LocalDateTime ---
        LocalDateTime now       = LocalDateTime.now();
        LocalDateTime meeting   = LocalDateTime.of(2025, Month.DECEMBER, 25, 10, 30, 0);
        LocalDateTime inTwoHrs  = now.plusHours(2);

        System.out.println("\nNow:       " + now);
        System.out.println("Meeting:   " + meeting);
        System.out.println("In 2 hrs:  " + inTwoHrs);

        // Formatting
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        System.out.println("Formatted: " + now.format(fmt));

        // Parsing
        LocalDate parsed = LocalDate.parse("2025-12-25");
        System.out.println("Parsed:    " + parsed);

        // Comparison
        System.out.println("birthday before today: " + birthday.isBefore(today));
        System.out.println("meeting after now:     " + meeting.isAfter(now));
    }
}
