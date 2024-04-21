#include <iostream>

using namespace std;

int main() 
{
    int val[8] = {0,};
    int asc = 0, desc = 0;
    for(int i = 0; i < 8; i++)
        cin >> val[i];
    for(int i = 0; i < 8; i++)
    {   
        if(val[i]==val[i+1]-1)
            asc++;
        else if(val[i]==val[i+1]+1)
            desc++;   
    }
    if(asc==7)
        cout << "ascending";
    else if(desc==7)
        cout << "descending";
    else
        cout << "mixed";
}