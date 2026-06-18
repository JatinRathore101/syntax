// Comparable  — natural ordering defined INSIDE the class (compareTo)
// Comparator  — custom/external ordering defined OUTSIDE the class (compare)

import java.util.*;

// Comparable: implement inside the class for its natural/default ordering
class Student implements Comparable<Student> {
    String name;
    int    gpa;

    Student(String name, int gpa) { this.name = name; this.gpa = gpa; }

    // Natural order: sort by GPA ascending
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.gpa, other.gpa);
    }

    @Override public String toString() { return name + "(" + gpa + ")"; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 88),
            new Student("Bob",   92),
            new Student("Carol", 75),
            new Student("Dave",  88)
        );

        // Comparable — uses Student.compareTo() (by GPA)
        Collections.sort(students);
        System.out.println("By GPA (Comparable): " + students);

        // Comparator — external ordering; does NOT modify the class
        // Sort by name alphabetically
        Comparator<Student> byName = Comparator.comparing(s -> s.name);
        students.sort(byName);
        System.out.println("By name (Comparator): " + students);

        // Sort by GPA descending
        students.sort(Comparator.comparingInt((Student s) -> s.gpa).reversed());
        System.out.println("By GPA desc: " + students);

        // Chained comparator: by GPA desc, then name asc on ties
        students.sort(
            Comparator.comparingInt((Student s) -> s.gpa)
                      .reversed()
                      .thenComparing(s -> s.name)
        );
        System.out.println("GPA desc, name asc: " + students);

        // Comparator for primitives — integers
        List<Integer> nums = Arrays.asList(5, 2, 8, 1, 9, 3);
        nums.sort(Comparator.reverseOrder());
        System.out.println("Ints reversed: " + nums);
    }
}
