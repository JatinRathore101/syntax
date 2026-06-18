// Static Methods — Belong to the CLASS, not to any instance
// Called as ClassName.methodName() — no object required
// Cannot access instance (non-static) fields directly

class MathUtils {
    // Pure utility methods — operate on input only, no state needed
    static int     square(int n)     { return n * n; }
    static int     cube(int n)       { return n * n * n; }
    static int     max(int a, int b) { return a > b ? a : b; }
    static int     min(int a, int b) { return a < b ? a : b; }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class StringUtils {
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
}

public class Main {
    public static void main(String[] args) {
        // No object needed — call directly on the class
        System.out.println("square(5)     = " + MathUtils.square(5));
        System.out.println("cube(3)       = " + MathUtils.cube(3));
        System.out.println("max(10, 25)   = " + MathUtils.max(10, 25));
        System.out.println("isPrime(17)   = " + MathUtils.isPrime(17));
        System.out.println("isPrime(15)   = " + MathUtils.isPrime(15));

        System.out.println("reverse(hello)      = " + StringUtils.reverse("hello"));
        System.out.println("isPalindrome(racecar)= " + StringUtils.isPalindrome("racecar"));

        // main() itself is static — that is why Java can call it without creating an object
    }
}
