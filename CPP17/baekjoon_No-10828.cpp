#include <iostream>
#include <vector>

using namespace std;
vector<int> stack;

void cal(string order)
{
    if(order == "push"){
        int extra_num = 0;
        cin >> extra_num;
        stack.push_back(extra_num);
    }
    else if(order == "pop"){
        if(stack.empty())
            cout << -1 << endl;
        else{
            cout << stack[stack.size()-1]<< endl;
            stack.pop_back();
        }
    }
    else if(order == "size"){
        cout << stack.size()<< endl;
    }
    else if(order == "empty"){
        if(stack.empty())
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }
    else if(order == "top"){
        if(stack.empty())
            cout << -1 << endl;
        else
            cout << stack[stack.size()-1]<< endl;
    }
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int order_cnt;
    cin >> order_cnt;
    while(order_cnt--){
        string word;
        cin >> word;
        cal(word);
    }
}