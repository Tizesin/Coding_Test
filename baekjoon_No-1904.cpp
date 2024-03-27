#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int num;
    long long dp[1000001] = {0,1,2};
    cin >> num;
    
    for(int i = 3; i <= num; i++){
        dp[i] = dp[i-1]+dp[i-2];
        dp[i] %= 15746;
    }
    cout << dp[num];
    return 0;
}