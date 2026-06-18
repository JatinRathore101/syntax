// Access Modifiers — Control visibility of classes, fields, and methods
//
// private:   visible ONLY within the same class
// (default): visible within the same PACKAGE (no keyword needed)
// protected: visible in same package + subclasses (even in other packages)
// public:    visible EVERYWHERE

class AccessDemo {
    private   int privateField   = 1;  // only this class
    int       defaultField       = 2;  // same package only
    protected int protectedField = 3;  // same package + subclasses
    public    int publicField    = 4;  // everywhere

    private   void privateMethod()   { System.out.println("private");   }
    void      defaultMethod()        { System.out.println("default");   }
    protected void protectedMethod() { System.out.println("protected"); }
    public    void publicMethod()    { System.out.println("public");    }

    // Private field accessed through public method (encapsulation pattern)
    public int getPrivateField() { return privateField; }
}

class SubClass extends AccessDemo {
    void test() {
        // privateField   — NOT accessible (compile error)
        // defaultField   — accessible (same package)
        // protectedField — accessible (subclass)
        // publicField    — accessible (everywhere)
        System.out.println("Sub sees default:   " + defaultField);
        System.out.println("Sub sees protected: " + protectedField);
        System.out.println("Sub sees public:    " + publicField);
    }
}

public class Main {
    public static void main(String[] args) {
        AccessDemo obj = new AccessDemo();

        // obj.privateField   — NOT accessible (compile error if uncommented)
        System.out.println("default:   " + obj.defaultField);
        System.out.println("protected: " + obj.protectedField);
        System.out.println("public:    " + obj.publicField);
        System.out.println("private (via getter): " + obj.getPrivateField());

        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();
        // obj.privateMethod(); — compile error

        SubClass sub = new SubClass();
        sub.test();

        System.out.println("\nAccess Modifier Summary:");
        System.out.println("  private   → same class only");
        System.out.println("  (default) → same package");
        System.out.println("  protected → same package + subclasses");
        System.out.println("  public    → everywhere");
    }
}
