#include <iostream>
#include <vector>

using namespace std;

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    unsigned int total_wire_cnt, need_wire_cnt, total_wire_len = 0;
    unsigned int MIN_len = 1, MID_len, MAX_len = 0;
    unsigned int result = 0;
    vector<int> wire_info;
    cin >> total_wire_cnt >> need_wire_cnt;
    for(int i = 0; i < total_wire_cnt; i++){
        unsigned int answer = 0;
        cin >> answer;
        MAX_len = max(MAX_len,answer);
        wire_info.push_back(answer);
    }

    //최대 길이 구하기
    while(MIN_len<=MAX_len){
        unsigned int cut_line = 0;
        MID_len = (MIN_len+MAX_len)/2;
        for(int i = 0; i < total_wire_cnt; i++){
            cut_line += wire_info[i]/MID_len;
            if(cut_line > need_wire_cnt)
                break;
        }
        if(cut_line >= need_wire_cnt){
            MIN_len = MID_len+1;
            result = max(result, MID_len);
        }
        else{
            MAX_len = MID_len-1;
        }
    }
    cout << result;
}