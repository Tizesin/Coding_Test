#include <iostream>
#include <algorithm>
#include <string.h>

using namespace std;

int main()
{
    while(1){
        string str, str_rev;
        cin >> str;
        if(str=="0")
            break;
        str_rev = str;
        reverse(str_rev.begin(), str_rev.end());
        if(str.compare(str_rev))
            cout << "no" << endl;
        else
            cout << "yes" << endl;
    }
}