#include <iostream>
#include <vector>
#include <stack>
#include <cstdlib>

using namespace std;

int main() 
{
    //speed up
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    vector<int> result;
    stack<int> st;
    vector<string> ret;
    int total_num_cnt;
    cin >> total_num_cnt;
    bool find_max_point = false;
    bool fail_chk = false;
    for(int i = 0; i < total_num_cnt; i++){
        int enter_num;
        cin >> enter_num;
        result.push_back(enter_num);
    }
    int num = 1;
    int idx = 0;
    while(1){
        if(num>total_num_cnt+1){
            cout << "NO";
            return 0;
        }
        if(idx==total_num_cnt)
            break;

        if(st.empty() || st.top()!=result[idx]){
            st.push(num);
            ret.push_back("+");
            num++;
        }else if(st.top()==result[idx]){
            st.pop();
            ret.push_back("-");
            idx++;
        }
    }
    for(string a : ret)
        cout << a << "\n";
}