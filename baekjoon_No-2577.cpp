#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int A,B,C;
    int result;
    cin >> A >> B >> C;
    int num_cnt[10] = {0,};
    result = A*B*C;

    while(result != 0){
        int val;
        val = result%10;
        num_cnt[val]++;
        result /= 10;
    }
    for(int i = 0; i < 10; i++){
        cout << num_cnt[i] << endl;
    }
}