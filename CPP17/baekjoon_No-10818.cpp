#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    vector<int> num;
    cin >> N;
    while(N--){
        int enter;
        cin >> enter;
        num.push_back(enter);
    }
    sort(num.begin(),num.end());
    cout << num[0] << " " << num[num.size()-1] << endl;
}
