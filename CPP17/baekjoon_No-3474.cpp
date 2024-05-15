#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int test_case, num;
    cin >> test_case;
    for(int i = 0; i < test_case; i++){
        int sum = 0;
        cin >> num;
        for(int j = 5; j <= num; j *= 5)
            sum += num / j;
        cout << sum << "\n";
    }
    return 0;
}