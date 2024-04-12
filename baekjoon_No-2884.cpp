#include <iostream>

using namespace std;

int main() 
{
    int enter_H, enter_M;
    int total_M;
    cin >> enter_H >> enter_M;
    total_M = enter_H*60+enter_M-45;
    if(total_M<0) total_M += 1440;
    enter_H = total_M/60;
    enter_M = total_M%60;
    cout << enter_H << " " << enter_M;
}