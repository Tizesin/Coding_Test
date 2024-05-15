#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    int building_cnt;
    int result = 0;
    cin >> building_cnt;
    int budilding_list[building_cnt][2] = {0,}; // 빌딩번호[x값] , 빌딩의 높이 , 보이는 건물

    for(int i = 0; i < building_cnt; i++){
        cin >> budilding_list[i][0];
    }

    for(int i = 0; i < building_cnt; i++){
        int x1 = i;
        int y1 = budilding_list[i][0];
        for(int j = i+1; j<building_cnt; j++){
            int x2 = j;
            int y2 = budilding_list[j][0];
            //선분공식 -> y = ax + b
            double a1 = (y1-y2); // [x1 4 | y1 6][x2 11 | y2 7] -1 / -7
            double a2 = (x1-x2); // [x1 4 | y1 6][x2 11 | y2 7] -1 / -7
            double a = a1/a2; //(y1-y2)/(x1-x2); // [x1 4 | y1 6][x2 11 | y2 7] -1 / -7
            double b = y1 - a*x1;

            //바로 옆에 있는 건물이라면..
            if(j-i==1){
                budilding_list[i][1] += 1;
                budilding_list[j][1] += 1;
            }else {
                for(int k = i+1; k < j; k++){
                    //  y >= ax + b 라면.. 즉 사이에 가려지는 건물이 있다면.
                    if(budilding_list[k][0] >= a*k+b){
                        break;
                    }else{
                        if(k==j-1){
                            budilding_list[i][1] += 1;
                            budilding_list[j][1] += 1;
                        }
                    }
                }  
            }
        }
    }
    for(int i = 0; i < building_cnt; i++){
        if(result < budilding_list[i][1])
            result = budilding_list[i][1];
    }
    cout << result << endl;
    
    return  0;

}