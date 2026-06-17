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
Balanced bracket problem.
print YES if input brackets balanced else print NO.

Balanced brackets
{[()]}            YES
[({)}]            NO
{{[[{}(())]()]}}  YES

Solving this using stack.
*/
string isbalanced(string s);

int main()
{
    int t;cin>>t;
    while(t--)
    {
        string s;cin>>s;
        cout<<isbalanced(s)<<endl;
    }
    return 0;
}

string isbalanced(string s)
{
    stack<char> st;
    for(auto ch:s)
    {
        if((ch=='(')||(ch=='{')||(ch=='['))
        {
            st.push(ch);
        }
        else if((ch==')')||(ch=='}')||(ch==']'))
        {
            if((ch==')')&&(st.top()=='('))
            {
                st.pop();
            }
            else if((ch=='}')&&(st.top()=='{'))
            {
                st.pop();
            }
            else if((ch==']')&&(st.top()=='['))
            {
                st.pop();
            }
            else
            {
                return "NO";
            }
        }
    }
    if(st.empty()){return "YES";}
    return "NO";
}
