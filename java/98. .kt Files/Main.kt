// Main.kt — Kotlin source file
// Kotlin is 100% interoperable with Java; both run on the JVM
// Kotlin files have the .kt extension and are compiled with 'kotlinc'

// --- Variables ---
// val = immutable (like Java final); var = mutable
val appName: String = "MyApp"     // explicit type
var userAge = 25                   // type inferred as Int

// --- Data class — auto-generates equals(), hashCode(), toString(), copy() ---
data class User(val name: String, val age: Int)

// --- Extension function — add a method to an existing class without subclassing ---
fun String.isPalindrome(): Boolean = this == this.reversed()

// --- Null safety ---
// Non-nullable: String   — compiler prevents null assignment
// Nullable:     String?  — null is allowed
fun greet(name: String?): String {
    return "Hello, ${name ?: "Guest"}!"  // Elvis operator: use "Guest" if null
}

fun main() {
    println("=== Kotlin Basics ===")

    // Variables
    println("$appName, age=$userAge")

    // Data class
    val user1 = User("Alice", 30)
    val user2 = User("Alice", 30)
    println(user1)                          // User(name=Alice, age=30)
    println("user1 == user2: ${user1 == user2}") // true (data class equality)

    val user3 = user1.copy(age = 31)        // copy with modification
    println("Copy: $user3")

    // Extension function
    println("racecar isPalindrome: ${"racecar".isPalindrome()}")
    println("hello isPalindrome:   ${"hello".isPalindrome()}")

    // Null safety
    println(greet("Bob"))
    println(greet(null))

    // String templates (cleaner than Java string concat)
    val name = "World"
    println("Hello, $name! Length = ${name.length}")

    // Ranges and loops
    for (i in 1..5) print("$i ")
    println()

    // When expression (like switch but more powerful)
    val score = 85
    val grade = when {
        score >= 90 -> "A"
        score >= 75 -> "B"
        else        -> "C"
    }
    println("Grade: $grade")

    // Lambda and higher-order functions
    val nums = listOf(1, 2, 3, 4, 5)
    val evens = nums.filter { it % 2 == 0 }
    val doubled = nums.map { it * 2 }
    println("Evens:   $evens")
    println("Doubled: $doubled")
}
