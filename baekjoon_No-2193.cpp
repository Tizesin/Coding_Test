#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int num;
    unsigned long dp[91] = {0,1};
    cin >> num;
    
    for(int i = 2; i <= num; i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    cout << dp[num];
    return 0;
}