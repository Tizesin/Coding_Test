#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int num[9] = {0,};
    int sort_num[9] = {0,};
    int enter_val;
    for(int i = 0; i < 9; i++){
        cin >> enter_val;
        num[i] = enter_val;
        sort_num[i] = enter_val;
    }
    sort(sort_num, sort_num+9);
    int i = 0;
    while(1)
    {
        if(sort_num[8]==num[i]){
            cout << sort_num[8] << "\n" << i+1 << endl;
            break;
        }
        i++;
    }
    return 0;
}