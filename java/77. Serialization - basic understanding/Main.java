// Serialization — Convert an object to a byte stream (save to file/send over network)
// Deserialization — Convert byte stream back to an object
// Class must implement java.io.Serializable (marker interface — no methods)
// Fields marked 'transient' are excluded from serialization

import java.io.*;

// Must implement Serializable to be serializable
class User implements Serializable {
    // serialVersionUID ensures compatibility between serialized/deserialized versions
    private static final long serialVersionUID = 1L;

    String name;
    int    age;
    transient String password; // 'transient' — NOT serialized (sensitive data)

    User(String name, int age, String password) {
        this.name     = name;
        this.age      = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Alice", 30, "secret123");
        System.out.println("Before serialization: " + user);

        // Serialize — write object to file
        String filePath = "user.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(user);
            System.out.println("Object serialized to " + filePath);
        }

        // Deserialize — read object back from file
        User loaded;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            loaded = (User) ois.readObject();
            System.out.println("Deserialized: " + loaded);
            // 'password' is null because it was marked transient
        }

        // Cleanup
        new File(filePath).delete();

        // Key points:
        // - Serializable is a marker interface (no methods to implement)
        // - 'transient' fields are skipped (use for passwords, connections, etc.)
        // - serialVersionUID prevents InvalidClassException on class version mismatch
        // - For modern apps, prefer JSON (Jackson/Gson) over Java Serialization
        System.out.println("Note: transient 'password' is null after deserialization.");
    }
}
