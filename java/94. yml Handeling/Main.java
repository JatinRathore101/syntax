// YAML Handling in Java
// Java has NO built-in YAML support — you need a library
// Most popular: SnakeYAML (used internally by Spring Boot)
//
// To use SnakeYAML, add to pom.xml (Maven):
//   <dependency>
//     <groupId>org.yaml</groupId>
//     <artifactId>snakeyaml</artifactId>
//     <version>2.2</version>
//   </dependency>
//
// This file demonstrates the concept; actual YAML parsing requires the jar.

public class Main {
    public static void main(String[] args) {
        // --- What a typical application.yml looks like (Spring Boot) ---
        String yamlContent = """
            server:
              port: 8080

            spring:
              datasource:
                url: jdbc:mysql://localhost:3306/mydb
                username: root
                password: secret
              application:
                name: my-spring-app

            app:
              max-retries: 3
              timeout: 5000
            """;

        System.out.println("Sample application.yml:");
        System.out.println(yamlContent);

        // --- How you'd parse it with SnakeYAML ---
        System.out.println("To parse YAML with SnakeYAML:");
        System.out.println("""
            // Add dependency then:
            import org.yaml.snakeyaml.Yaml;
            import java.io.InputStream;
            import java.util.Map;

            Yaml yaml = new Yaml();
            try (InputStream is = Main.class.getResourceAsStream("/application.yml")) {
                Map<String, Object> data = yaml.load(is);
                Map<String, Object> server = (Map<String, Object>) data.get("server");
                System.out.println("Port: " + server.get("port")); // 8080
            }
            """);

        // --- In Spring Boot ---
        System.out.println("In Spring Boot, YAML is read automatically:");
        System.out.println("  @Value(\"${server.port}\") int port;");
        System.out.println("  @ConfigurationProperties(prefix = \"app\") class AppConfig {...}");

        // --- Simple key=value alternative (Java built-in) ---
        // Java Properties files (.properties) work without extra libraries
        java.util.Properties props = new java.util.Properties();
        props.setProperty("server.port", "8080");
        props.setProperty("app.name", "my-app");
        System.out.println("\nProperties (built-in alternative to YAML):");
        props.forEach((k, v) -> System.out.println("  " + k + " = " + v));
    }
}
