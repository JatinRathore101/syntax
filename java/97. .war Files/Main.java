// .war Files — Web Application ARchive
// A JAR with a specific structure for deploying Java web applications
// Deployed to a Servlet container: Tomcat, Jetty, WildFly, etc.
//
// WAR structure:
//   myapp.war
//   ├── WEB-INF/
//   │   ├── web.xml             (deployment descriptor — servlets, filters, mappings)
//   │   ├── classes/            (compiled .class files)
//   │   └── lib/                (dependency JARs)
//   ├── index.html              (static resources at root)
//   ├── css/, js/, images/      (frontend assets)
//   └── META-INF/

public class Main {
    public static void main(String[] args) {
        System.out.println("=== .war Files ===");
        System.out.println();
        System.out.println("WAR = Web Application Archive");
        System.out.println("Deployed to a Servlet container (Tomcat, Jetty, etc.)");
        System.out.println();
        System.out.println("WAR structure:");
        System.out.println("  myapp.war");
        System.out.println("  ├── WEB-INF/");
        System.out.println("  │   ├── web.xml         → deployment descriptor");
        System.out.println("  │   ├── classes/        → compiled .class files");
        System.out.println("  │   └── lib/            → dependency JARs");
        System.out.println("  ├── index.html          → static frontend");
        System.out.println("  └── META-INF/");
        System.out.println();
        System.out.println("WAR vs JAR vs EAR:");
        System.out.println("  .jar → library or standalone app");
        System.out.println("  .war → web app (Servlets, JSP, Spring MVC)");
        System.out.println("  .ear → enterprise app (multiple WARs + EJBs)");
        System.out.println();
        System.out.println("Build:");
        System.out.println("  Maven: <packaging>war</packaging> → mvn package → target/app.war");
        System.out.println("  Deploy: copy app.war to Tomcat's webapps/ folder");
        System.out.println();
        System.out.println("Modern Spring Boot apps:");
        System.out.println("  Often packaged as executable JAR with embedded Tomcat");
        System.out.println("  WAR is still used for deployment to external servers");
    }
}
