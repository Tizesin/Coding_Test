#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() 
{
    int user_cnt;
    double user_age;
    double idx = 0.000001;
    string user_name;
    vector<pair<double,string>> user_info;
    cin >> user_cnt;
    while(user_cnt--){
        idx += 0.000001;
        cin >> user_age >> user_name;
        user_info.push_back({user_age+idx,user_name});
    }
    sort(user_info.begin(),user_info.end());

    for(int i = 0; i < user_info.size(); i++){
        cout << (int)user_info[i].first << " " << user_info[i].second << "\n";
    }
}
