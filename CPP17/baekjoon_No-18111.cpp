#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int col, row, inven, ans;
    int h = 0, res_time = -1;
    vector<int> ground;
    cin >> col >> row >> inven;
    for(int i = 0; i < (col*row); i++){
        cin >> ans;
        ground.push_back(ans);
    }
    sort(ground.begin(),ground.end());
    //연산과정
    for(int nh = ground[0]; nh<=ground[col*row-1]; nh++) {
        int now_inven = inven;
        int total_time = 0;
        for(int i = 0; i<(col*row); i++){
            //파내야할때
            if(ground[i]>nh){
                total_time += (ground[i]-nh)*2;
                now_inven += ground[i]-nh;
            }
            //쌓아야할때
            if(ground[i]<nh){
                total_time += nh-ground[i];
                now_inven -= nh-ground[i];
            }
        }
        if(now_inven<0)
            continue;
        if(res_time == -1 || res_time >= total_time){
            res_time = total_time;
            h = nh;
        }
    }


    cout << res_time << " " << h;
}