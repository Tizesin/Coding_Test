#include <vector>
#include <iostream>

using namespace std;

int main()
{
    int test_case;
    cin >> test_case;
    while(test_case--){
        string result;
        int total_score = 0, bonus_score = 0;
        cin >> result;
        for(int i = 0; i < result.length(); i++){
            if(result[i] == 'X'){
                bonus_score = 0;
            }
            else{
                total_score = total_score + bonus_score + 1;
                bonus_score++;
            }
        }
        cout << total_score << endl;
    }
}
