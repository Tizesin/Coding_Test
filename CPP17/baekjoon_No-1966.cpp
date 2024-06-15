#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int test_case;
    cin >> test_case;
    while(test_case--){
        int page_cnt, search_page, result = 1;
        queue<pair<int,int>> q_page_info;
        priority_queue<int> pq_page_info;
        cin >> page_cnt >> search_page;
        for(int i = 0; i<page_cnt; i++){
            int p_ipt;
            cin >> p_ipt;
            q_page_info.push({p_ipt,i});
            pq_page_info.push(p_ipt);
        }
        while(1){
            int page_importance = q_page_info.front().first;
            int page_idx = q_page_info.front().second;
            if(page_importance != pq_page_info.top()){
                q_page_info.pop();
                q_page_info.push({page_importance,page_idx});
            }
            else {
                if(page_idx == search_page)
                    break;
                else{
                    q_page_info.pop();
                    pq_page_info.pop();
                    result++;
                }
            }
        }
        cout << result << endl;
    }
}