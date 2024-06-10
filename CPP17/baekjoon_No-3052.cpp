#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> num;
    int A;
    for(int i = 0; i < 10; i++){
        cin >> A;
        num.push_back(A%42);
    }
    sort(num.begin(), num.end());
    num.erase(unique(num.begin(),num.end()), num.end());

    cout << num.size() << endl;
}