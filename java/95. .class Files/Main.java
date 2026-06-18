// .class Files — Compiled Java bytecode
// When you compile a .java file, javac produces a .class file containing bytecode
// Bytecode is NOT machine code; it runs on the JVM (Java Virtual Machine)
// This is what makes Java "Write Once, Run Anywhere"

// Compilation flow:
//   Source code (.java)
//       ↓  javac (compiler)
//   Bytecode (.class)
//       ↓  JVM (interpreter + JIT compiler)
//   Machine code (runs on CPU)

public class Main {
    public static void main(String[] args) {
        System.out.println("=== .class Files ===");
        System.out.println();
        System.out.println("Compile:  javac Main.java  →  produces Main.class");
        System.out.println("Run:      java Main        →  JVM executes Main.class");
        System.out.println();

        // Demonstrate that class info is embedded in the .class file
        Class<?> cls = Main.class;
        System.out.println("Class name:    " + cls.getName());
        System.out.println("Package:       " + (cls.getPackageName().isEmpty() ? "(default)" : cls.getPackageName()));
        System.out.println("Superclass:    " + cls.getSuperclass().getSimpleName());
        System.out.println("Methods count: " + cls.getDeclaredMethods().length);

        // Each inner/anonymous class gets its own .class file
        // e.g., Main$1.class for anonymous class, Main$Inner.class for inner class

        System.out.println();
        System.out.println("Key points:");
        System.out.println("  - One .class file per class (including inner/anonymous classes)");
        System.out.println("  - .class files are platform-independent bytecode");
        System.out.println("  - JVM's JIT (Just-In-Time) compiler converts hot code to native");
        System.out.println("  - javap -c Main.class  → disassemble bytecode (readable form)");
        System.out.println("  - .class files are packaged into .jar files for distribution");
    }
}
