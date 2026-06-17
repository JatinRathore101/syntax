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

// ===== 1) Sort characters in a string =====

string sortString(string str) {
    sort(str.begin(), str.end());
    return str;
}

// ===== 2) Sort array (vector) of strings =====

// Default lexicographic sort
vector<string> sortArrayLexicographic(vector<string> arr) {
    sort(arr.begin(), arr.end());
    return arr;
}

// ===== TESTING =====

int main() {
    cout << "---- String Sorting ----\n";

    string str1 = "dcba";
    cout << sortString(str1) << endl; // abcd

    cout << "\n---- Array Sorting ----\n";

    vector<string> arr1 = {"banana", "apple", "cherry"};
    auto res1 = sortArrayLexicographic(arr1);
    for (auto &s : res1) cout << s << " ";
    cout << endl;

    return 0;
}