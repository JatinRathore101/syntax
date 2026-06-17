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
Queue - FIFO
for queue q -
functions -> q.push() , q.empty() , q.front() , q.pop()
*/

int main()
{
    queue<string> q;
    q.push("dfvh");
    q.push("fc432");
    q.push("3ddd");
    q.push("zx");
    q.push("xae");

    while(!q.empty())
    {
        cout<<q.front()<<endl;
        q.pop();
    }
    return 0;
}

