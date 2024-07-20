#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int jewel_cnt, jewel_weight, jewel_price;
    int bag_size, bag_cnt;
    int total_bags_weight = 0;
    vector<int> bags;
    vector<pair<int,int>> jewel_info;
    cin >> jewel_cnt >> bag_cnt;
    for(int i = 0; i < jewel_cnt; i++) {
        jewel_weight = 0;
        jewel_price = 0;
        cin >> jewel_weight >> jewel_price;
        // jewel_info.push_back({jewel_price,jewel_weight});
        jewel_info.push_back({jewel_weight,jewel_price});
    }
    for(int i = 0; i<bag_cnt; i++){
        bag_size = 0;
        cin >> bag_size;
        bags.push_back(bag_size);
    }

    sort(bags.begin(),bags.end());
    // sort(jewel_info.begin(),jewel_info.end(),[](const auto& a, const auto& b){
    //     return a.first > b.first;
    // });

    // for(int i = 0; i<bag_cnt; i++){
    //     for(int j = 0; j<jewel_cnt; j++){
    //         if(0 <= jewel_info[j].second && bags[i] >= jewel_info[j].second){
    //             total_bags_weight+=jewel_info[j].first;
    //             jewel_info[j].second = -1;
    //             break;
    //         }
    //     }
    // }

    sort(jewel_info.begin(),jewel_info.end());
     for(int i = 0; i<bag_cnt; i++){
        int jewel_idx = 0, jewel_idx_price = 0;
        for(int j = 0; j<jewel_cnt; j++){
            if(jewel_info[j].first > bags[i]){
                break;
            }
            else if(jewel_info[j].first != -1 && jewel_info[j].second > jewel_idx_price){
                jewel_idx = j;
                jewel_idx_price = jewel_info[j].second;
            }
        }
        jewel_info[jewel_idx].first = -1;
        total_bags_weight += jewel_idx_price;
    }
    cout << total_bags_weight;
}