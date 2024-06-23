#include <iostream>
#include <vector>
#include <queue>

using namespace std;


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int arrcount_sort[10001] = {0,};
    int total_cnt, answer;
    cin >> total_cnt;
    while(total_cnt--){
        cin >> answer;
        arrcount_sort[answer]++;
    }

    for(int i = 1; i<10001;i++){
        for(int j=0; j<arrcount_sort[i];j++){
            cout << i << "\n";
        }
    }
}