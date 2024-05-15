#include <iostream>
using namespace std;

int main()
{
    int con_cnt, total_money,high_val = 0;
    int money_evr, money_evr_ex, overflow_cnt=0;
    cin >> con_cnt;
    int con_req[con_cnt][2];
    for(int i = 0; i < con_cnt; i++){
        cin >> con_req[i][0];
        con_req[i][1] = 0;
        if(high_val < con_req[i][0])
            high_val = con_req[i][0];
    }
    cin >> total_money;

    money_evr_ex = total_money; 
    money_evr =  total_money/con_cnt; 
    for(int i = 0; i < con_cnt; i++){
        if(con_req[i][1] != 1 && money_evr>con_req[i][0]){
            overflow_cnt++;
            money_evr_ex -= con_req[i][0];
            if(overflow_cnt==con_cnt){
                break;
            }
            else{
                money_evr = money_evr_ex/(con_cnt-overflow_cnt);
            }
            con_req[i][1] = 1;
            i = -1;
        }
    }
    
    if(money_evr>=high_val)
        cout << high_val;
    else
        cout << money_evr;
}