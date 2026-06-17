#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstring>

#include <map>
#include <unordered_map>
#include <set>
#include <unordered_set>

#include <queue>
#include <stack>
#include <deque>

#include <utility>
#include <tuple>

#include <limits>
#include <climits>

#include <numeric>
using namespace std;

// Custom struct for complex sorting
struct Person {
    string name;
    int age;
};

// Custom comparator for struct
bool comparePerson(const Person &a, const Person &b) {
    if (a.age == b.age)
        return a.name < b.name; // tie-breaker
    return a.age < b.age;
}

int main() {

    // =========================
    // 1. Sorting vector<int>
    // =========================
    vector<int> nums = {5, 2, 8, 1, 3};

    sort(nums.begin(), nums.end()); // ascending
    // sort(nums.begin(), nums.end(), greater<int>()); // descending

    cout << "Sorted nums: ";
    for (int x : nums) cout << x << " ";
    cout << "\n";


    // =========================
    // 2. Sorting vector<string>
    // =========================
    vector<string> words = {"banana", "apple", "cherry"};

    sort(words.begin(), words.end()); // lexicographical

    cout << "Sorted words: ";
    for (auto &w : words) cout << w << " ";
    cout << "\n";


    // =========================
    // 3. Sorting a string
    // =========================
    string s = "dcba";

    sort(s.begin(), s.end()); // characters sorted

    cout << "Sorted string: " << s << "\n";


    // =========================
    // 4. Sorting vector<pair<int,int>>
    // =========================
    vector<pair<int,int>> vp = {{1,3}, {1,2}, {2,2}, {2,1}};

    sort(vp.begin(), vp.end()); 
    // default: first asc, then second asc

    cout << "Sorted pairs: ";
    for (auto &p : vp) cout << "(" << p.first << "," << p.second << ") ";
    cout << "\n";


    // =========================
    // 5. Custom comparator (lambda)
    // =========================
    // Sort by second descending
    sort(vp.begin(), vp.end(), [](auto &a, auto &b) {
        return a.second > b.second;
    });

    cout << "Pairs sorted by second desc: ";
    for (auto &p : vp) cout << "(" << p.first << "," << p.second << ") ";
    cout << "\n";


    // =========================
    // 6. Sorting struct vector
    // =========================
    vector<Person> people = {
        {"Jai", 24},
        {"Amit", 22},
        {"Rohit", 24}
    };

    sort(people.begin(), people.end(), comparePerson);

    cout << "Sorted people: ";
    for (auto &p : people)
        cout << "(" << p.name << "," << p.age << ") ";
    cout << "\n";


    // =========================
    // 7. Sorting with custom rule (even first, then odd)
    // =========================
    vector<int> arr = {5, 2, 7, 8, 1, 4};

    sort(arr.begin(), arr.end(), [](int a, int b) {
        if (a % 2 == b % 2)
            return a < b; // same parity
        return a % 2 < b % 2; // even first
    });

    cout << "Even first sorting: ";
    for (int x : arr) cout << x << " ";
    cout << "\n";


    // =========================
    // 8. Partial sorting (top k smallest)
    // =========================
    vector<int> v = {9, 4, 1, 7, 3, 6};

    int k = 3;
    partial_sort(v.begin(), v.begin() + k, v.end());

    cout << "Top k smallest: ";
    for (int i = 0; i < k; i++) cout << v[i] << " ";
    cout << "\n";


    // =========================
    // 9. nth_element (k-th smallest)
    // =========================
    vector<int> v2 = {9, 4, 1, 7, 3, 6};

    nth_element(v2.begin(), v2.begin() + 2, v2.end());

    cout << "3rd smallest element: " << v2[2] << "\n";


    // =========================
    // 10. Stable sort
    // =========================
    vector<pair<int,int>> vs = {{1,3}, {1,2}, {1,1}};

    stable_sort(vs.begin(), vs.end(), [](auto &a, auto &b) {
        return a.first < b.first;
    });

    cout << "Stable sort result: ";
    for (auto &p : vs) cout << "(" << p.first << "," << p.second << ") ";
    cout << "\n";


    return 0;
}