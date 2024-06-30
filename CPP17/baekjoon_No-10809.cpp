#include <iostream>
#include <string.h>

using namespace std;

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int result[26];
    memset(result,-1,sizeof(result));
    string word;
    cin >> word;
    for(int j = 0; j<word.length(); j++){
        if(result[static_cast<int>(word[j])-97] == -1)
            result[static_cast<int>(word[j])-97] = j;
    }

    for(int i = 0; i<sizeof(result)/sizeof(int); i++)
        cout << result[i] << " ";
}