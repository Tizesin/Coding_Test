#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(int a, int b) {
    return a > b; 
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tree_cnt, need_wood, result;
    vector<int> tree_info;
    cin >> tree_cnt >> need_wood;

    for(int i = 0; i < tree_cnt; i++){
        int enter_val;
        cin >> enter_val;
        tree_info.push_back(enter_val);
    }
    sort(tree_info.begin(),tree_info.end(),compare);

    int low = 0, high = tree_info[0];

    while(low <= high){
        unsigned long wood_res = 0;
        int mid_num = (high + low)/2;
        for(int i = 0;i < tree_cnt;i++){
            if(tree_info[i]-mid_num <= 0)
                break; 
            wood_res += (tree_info[i]-mid_num);
        }
        if(wood_res >= need_wood){
            result = mid_num;
            low = mid_num + 1;
        }else{
            high = mid_num -1;
        }
    }
    cout << result;
}