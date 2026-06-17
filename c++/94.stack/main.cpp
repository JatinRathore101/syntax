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

/*
Stacks
FILO and LIFO

for stack s
functions -> s.push() , s.empty() , s.top() , s.pop()
*/

int main()
{
    stack<int> s;
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    while(!s.empty())
    {
        cout<<s.top()<<endl;
        s.pop();
    }
    return 0;
}

