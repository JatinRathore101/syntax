#include <bits/stdc++.h>
using namespace std;

// Base & Derived classes for dynamic_cast example
class Base {
public:
    virtual void show() { cout << "Base class\n"; }
};

class Derived : public Base {
public:
    void show() { cout << "Derived class\n"; }
};

int main() {

    int myInt = -10;
    string myStr = to_string(myInt);
    int myInt2 = stoi(myStr);
    cout<<myStr<< myInt2<<endl<<endl;

    // =========================
    // 1. Implicit Type Casting (Automatic)
    // =========================
    int a = 10;
    double b = a; // int -> double automatically

    cout << "Implicit (int -> double): " << b << "\n";


    // =========================
    // 2. C-Style Casting
    // =========================
    double x = 3.7;
    int y = (int)x; // force conversion

    cout << "C-style cast (double -> int): " << y << "\n";


    // =========================
    // 3. static_cast (recommended)
    // =========================
    double d = 9.8;
    int i = static_cast<int>(d);

    cout << "static_cast (double -> int): " << i << "\n";

    // int to char
    int num = 65;
    char ch = static_cast<char>(num);
    cout << "int -> char: " << ch << "\n"; // A


    // =========================
    // 4. const_cast
    // =========================
    const int val = 100;
    int* ptr = const_cast<int*>(&val);

    // modifying const (⚠️ undefined behavior, just demo)
    *ptr = 200;

    cout << "const_cast modified value: " << val << "\n";


    // =========================
    // 5. dynamic_cast (runtime casting)
    // =========================
    Base* basePtr = new Derived();

    Derived* derivedPtr = dynamic_cast<Derived*>(basePtr);

    if (derivedPtr) {
        cout << "dynamic_cast success\n";
        derivedPtr->show();
    } else {
        cout << "dynamic_cast failed\n";
    }


    // =========================
    // 6. reinterpret_cast (low-level)
    // =========================
    int n = 65;
    char* cptr = reinterpret_cast<char*>(&n);

    cout << "reinterpret_cast (int* -> char*): " << *cptr << "\n";


    // =========================
    // 7. Avoiding data loss example
    // =========================
    int p = 5, q = 2;

    double result1 = p / q; // integer division first
    double result2 = static_cast<double>(p) / q; // correct

    cout << "Wrong division: " << result1 << "\n";  // 2
    cout << "Correct division: " << result2 << "\n"; // 2.5


    // =========================
    // 8. Casting pointers
    // =========================
    int val2 = 10;
    void* vptr = &val2;

    int* iptr = static_cast<int*>(vptr);
    cout << "Pointer cast: " << *iptr << "\n";


    // =========================
    // 9. Enum casting
    // =========================
    enum Color { RED = 1, GREEN = 2 };

    int colorValue = static_cast<int>(GREEN);
    cout << "Enum to int: " << colorValue << "\n";


    // =========================
    // 10. Bool casting
    // =========================
    int zero = 0;
    int nonzero = 42;

    cout << "0 -> bool: " << static_cast<bool>(zero) << "\n";      // 0
    cout << "42 -> bool: " << static_cast<bool>(nonzero) << "\n";  // 1


    return 0;
}