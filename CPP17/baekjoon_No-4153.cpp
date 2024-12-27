#include <iostream>

using namespace std;

int main(){
    int a,b,c;
    int max_len;
    while(1){
        cin >> a >> b >> c;
        if(a+b+c == 0)
            break;
        a *= a;
        b *= b;
        c *= c;
        max_len = max(a,max(b,c));
        if(max_len == a+b+c-max_len)
            cout << "right" << "\n";
        else
            cout << "wrong" << "\n";
    }
}
