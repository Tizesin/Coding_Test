#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int m_layer, total_building_cnt;
    cin >> m_layer;
    total_building_cnt = pow(2,m_layer)-1;
    int memo[total_building_cnt+1] = {0,};
    for(int i = 1; i < total_building_cnt+1; i++){
        cin >> memo[i];
    }

    int print_layer = 1;
    int top = pow(2,m_layer-1);
    cout << memo[top] << endl;
    while(1){
        print_layer++;
        // cout << "layer " << print_layer << " : " << endl;
        top = pow(2,m_layer-print_layer);
        for(int i = 0; i < pow(2,print_layer-1); i++){
            cout << memo[top] << " ";
            top += pow(2,m_layer+1-print_layer);
        }
        cout << endl;
        if(print_layer == m_layer)
            break;
    }
    return 0;
}