#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int name_cnt, user_cnt; 
    cin >> name_cnt >> user_cnt;
    multimap<int,string> name_info;
    for(int i=0; i<name_cnt; i++){
        string name; int name_cutline;
        cin >> name >> name_cutline;
        name_info.insert({name_cutline,name});
    }
    
    for(int i=0; i<user_cnt; i++){
        int user_score;
        cin >> user_score;
        cout << (name_info.lower_bound(user_score)) ->second << endl;
    }
}