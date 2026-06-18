// hashCode() — Returns an integer that identifies an object
// Critical contract: if a.equals(b) then a.hashCode() == b.hashCode()
// Used internally by HashMap, HashSet, Hashtable for bucket placement
// Always override hashCode when you override equals

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Student {
    String name;
    int    id;

    Student(String name, int id) { this.name = name; this.id = id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return id == s.id && Objects.equals(name, s.name);
    }

    // hashCode must return same value for equal objects
    @Override
    public int hashCode() {
        return Objects.hash(name, id); // stable hash from both fields
    }

    @Override
    public String toString() { return name + "#" + id; }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Alice", 101); // logically equal to s1
        Student s3 = new Student("Bob",   102);

        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1 hashCode:   " + s1.hashCode()); // same
        System.out.println("s2 hashCode:   " + s2.hashCode()); // same

        // HashSet relies on hashCode + equals to detect duplicates
        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2); // not added — duplicate (equal hashCode AND equals)
        set.add(s3);
        System.out.println("Set size: " + set.size()); // 2 (s1==s2 is one entry)
        System.out.println("Set: " + set);

        // HashMap uses hashCode to find the bucket, equals to find the key
        HashMap<Student, String> map = new HashMap<>();
        map.put(s1, "Computer Science");
        System.out.println("Get with s2 (equal to s1): " + map.get(s2)); // "Computer Science"
    }
}
