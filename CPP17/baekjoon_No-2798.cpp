#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int total_card, goal_num;
    int result = 0;
    vector<int> card_list;
    cin >> total_card >> goal_num;
    while(total_card--){
        int num;
        cin >> num;
        card_list.push_back(num);
    }
    for(int i = 0; i < card_list.size(); i++){
        for(int j = 0; j < card_list.size(); j++){
            if(i==j) continue;
            for(int k = 0; k < card_list.size(); k++){
                if(i==k || j==k) continue;
                int sum = card_list[i]+card_list[j]+card_list[k];
                if(sum == goal_num){
                    cout << sum;
                    return 1;
                }
                else if(result < sum && sum < goal_num)
                    result = sum;
            }
        }
    }
    cout << result;
}