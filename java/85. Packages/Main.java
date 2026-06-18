// Packages — Namespaces that group related classes and avoid name collisions
// Convention: reverse domain name → com.company.module (e.g., com.google.auth)
// 'import' brings a class into scope; 'import static' imports static members

// This file is in the default package (no package declaration) for simplicity.
// In a real project: package com.example.app;

// Importing specific class from java standard library
import java.util.ArrayList;
import java.util.List;

// Wildcard import — imports ALL classes in the package (not sub-packages)
import java.util.*;

// Static import — import static members directly
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        // Using ArrayList (from java.util via import)
        List<String> list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");
        System.out.println("List: " + list);

        // Using static imports — no need to prefix with Math
        System.out.println("PI = " + PI);
        System.out.println("sqrt(16) = " + sqrt(16));

        // Fully qualified class name — no import needed (verbose but clear)
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("Today: " + today);

        // When two packages have the same class name, use fully qualified name
        // e.g., java.util.Date vs java.sql.Date — can't import both without conflict

        System.out.println();
        System.out.println("Package structure example:");
        System.out.println("  com.myapp.Main          → entry point");
        System.out.println("  com.myapp.models.User   → data model");
        System.out.println("  com.myapp.service.Auth  → business logic");
        System.out.println("  com.myapp.util.Helper   → utilities");
    }
}
