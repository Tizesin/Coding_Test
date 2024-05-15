#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int rock_cnt;
    int turn_chk = 0; // 0 상근이가 다음 턴 / 1 창영이가 다음 턴

    cin >> rock_cnt;
    turn_chk = (rock_cnt/3)%2;
    if(rock_cnt%3%2 == 0){
        if(turn_chk==0)
            cout << "CY";
        else
            cout << "SK";
    }
    else{
        if(turn_chk==0)
            cout << "SK";
        else
            cout << "CY";
    }
    return 0;
}