#include <iostream>
#include <algorithm>
using namespace std;


bool sort_option(string a, string b) {
    if(a.length() == b.length())
        return a < b;
    else
        return a.length() < b.length();
}

int main() 
{
    int input_num;
    string words[20000];
    cin >> input_num;
    for(int i = 0; i < input_num; i++)
        cin >> words[i];
    
    sort(words, words+input_num, sort_option);

    for(int i = 0; i < input_num; i++){
        if(words[i] == words[i-1])
            continue;
        cout << words[i] << endl;
    }
}
