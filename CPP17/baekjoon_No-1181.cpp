#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


bool length_sort(string a, string b) {
    if(a.length() == b.length())
        return a < b;
    else
        return a.length() < b.length();
}

int main() 
{
    int input_num;
    string words[20000];
    // vector<string> words = {0,};
    cin >> input_num;
    for(int i = 0; i < input_num; i++){
        cin >> words[i];
        // string word;
        // cin >> word;
        // words.push_back(word);
    }
    sort(words, words+input_num, length_sort);
    // sort(words.begin(),words.end(),length_sort);

    for(int i = 0; i < input_num; i++){
        if(words[i] == words[i-1])
            continue;
        cout << words[i] << endl;
    }
}