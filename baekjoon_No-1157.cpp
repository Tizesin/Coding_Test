#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
int main()
{
    string enter_words;
    vector<char> words;
    char word, high_word;
    int cnt = 0, high_cnt = 0;
    bool eq_high_cnt = false;

    cin >> enter_words;

    for(int i = 0; i < enter_words.length(); i++){
        words.push_back(enter_words[i]);
    }
    transform(words.begin(), words.end(), words.begin(), ::toupper);
    sort(words.begin(),words.end());

    for(int i = 0; i < words.size(); i++){
        if(word != words[i]){
            word = words[i];
            cnt = 1;
        }else{
            cnt++;
        }
        if(high_cnt < cnt){
            high_cnt = cnt;
            high_word = word;
            eq_high_cnt = false;
        }else if(high_cnt == cnt){
            eq_high_cnt = true;
        }
    }
    if(eq_high_cnt)
        cout << "?";
    else
        cout << high_word;
    return 0;
}