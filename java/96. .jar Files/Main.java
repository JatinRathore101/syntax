// .jar Files — Java ARchive; a ZIP file containing .class files + resources
// Used to: package a library, distribute a standalone application, or share code
// META-INF/MANIFEST.MF specifies the entry point (Main-Class)

public class Main {
    public static void main(String[] args) {
        System.out.println("=== .jar Files ===");
        System.out.println();
        System.out.println("A .jar file is a ZIP archive containing:");
        System.out.println("  - Compiled .class files");
        System.out.println("  - Resources (images, configs, properties)");
        System.out.println("  - META-INF/MANIFEST.MF (metadata)");
        System.out.println();
        System.out.println("Common commands:");
        System.out.println("  Create:  jar cf  app.jar *.class");
        System.out.println("  Run:     java -jar app.jar  (needs Main-Class in MANIFEST)");
        System.out.println("  List:    jar tf  app.jar");
        System.out.println("  Extract: jar xf  app.jar");
        System.out.println();
        System.out.println("MANIFEST.MF example:");
        System.out.println("  Manifest-Version: 1.0");
        System.out.println("  Main-Class: com.example.Main");
        System.out.println("  Class-Path: libs/dependency.jar");
        System.out.println();
        System.out.println("Types of JARs:");
        System.out.println("  Executable JAR  → contains Main-Class, run with java -jar");
        System.out.println("  Library JAR     → no Main-Class; used as dependency");
        System.out.println("  Fat/Uber JAR    → includes ALL dependencies inside one file");
        System.out.println("                    (Maven Shade plugin, Spring Boot plugin)");
        System.out.println();

        // You can inspect the current JAR at runtime (if running from a jar)
        String jarPath = Main.class.getProtectionDomain()
                              .getCodeSource().getLocation().getPath();
        System.out.println("Running from: " + jarPath);

        System.out.println();
        System.out.println("Build tools create JARs automatically:");
        System.out.println("  Maven:  mvn package         → target/app-1.0.jar");
        System.out.println("  Gradle: gradle build        → build/libs/app.jar");
    }
}
