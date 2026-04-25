#include <bits/stdc++.h>
using namespace std;

int main() {

    // =========================
    // 1. Character functions (cctype)
    // =========================
    char c = 'a';

    cout << "toupper: " << (char)toupper(c) << "\n";   // A
    cout << "tolower: " << (char)tolower('Z') << "\n"; // z

    cout << "isalpha(a): " << isalpha('a') << "\n";     // 1
    cout << "isdigit(5): " << isdigit('5') << "\n";     // 1
    cout << "isalnum(a): " << isalnum('a') << "\n";     // 1
    cout << "isspace(' '): " << isspace(' ') << "\n";   // 1
    cout << "islower(a): " << islower('a') << "\n";     // 1
    cout << "isupper(A): " << isupper('A') << "\n";     // 1
    cout << "ispunct(!): " << ispunct('!') << "\n";     // 1


    // =========================
    // 2. String basic operations
    // =========================
    string s = "hello";

    cout << "length: " << s.length() << "\n";
    cout << "size: " << s.size() << "\n";

    s.push_back('!');
    cout << "push_back: " << s << "\n";

    s.pop_back();
    cout << "pop_back: " << s << "\n";


    // =========================
    // 3. Access & modify
    // =========================
    cout << "s[1]: " << s[1] << "\n";

    s[0] = 'H';
    cout << "modified: " << s << "\n";


    // =========================
    // 4. Substring
    // =========================
    string str = "abcdef";

    cout << "substr(1,3): " << str.substr(1,3) << "\n"; // bcd


    // =========================
    // 5. Find
    // =========================
    string text = "hello world";

    cout << "find 'world': " << text.find("world") << "\n"; // index
    cout << "find 'x': " << text.find("x") << "\n";         // string::npos


    // =========================
    // 6. Compare
    // =========================
    string a = "abc", b = "abd";

    cout << "compare: " << a.compare(b) << "\n"; // <0 if a<b


    // =========================
    // 7. Reverse
    // =========================
    string rev = "hello";
    reverse(rev.begin(), rev.end());

    cout << "reversed: " << rev << "\n";


    // =========================
    // 8. Sort string
    // =========================
    string ss = "dcba";
    sort(ss.begin(), ss.end());

    cout << "sorted string: " << ss << "\n";


    // =========================
    // 9. Transform (to upper/lower full string)
    // =========================
    string t = "hello";

    transform(t.begin(), t.end(), t.begin(), ::toupper);
    cout << "upper: " << t << "\n";

    transform(t.begin(), t.end(), t.begin(), ::tolower);
    cout << "lower: " << t << "\n";


    // =========================
    // 10. Erase & insert
    // =========================
    string e = "hello";

    e.erase(1,2); // remove 2 chars from index 1
    cout << "erase: " << e << "\n";

    e.insert(1, "abc");
    cout << "insert: " << e << "\n";


    // =========================
    // 11. stoi / to_string
    // =========================
    string numStr = "123";

    int num = stoi(numStr);
    cout << "stoi: " << num << "\n";

    string back = to_string(num);
    cout << "to_string: " << back << "\n";


    // =========================
    // 12. Check palindrome (example)
    // =========================
    string p = "madam";
    string temp = p;

    reverse(temp.begin(), temp.end());

    cout << "is palindrome: " << (p == temp) << "\n";


    return 0;
}