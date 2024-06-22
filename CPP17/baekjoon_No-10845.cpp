#include <iostream>
#include <queue>

using namespace std;
queue<int> q;

void cal(string order)
{
    if(order == "push"){
        int extra_num = 0;
        cin >> extra_num;
        q.push(extra_num);
    }
    else if(order == "pop"){
        if(q.empty())
            cout << -1 << endl;
        else{
            cout << q.front()<< endl;
            q.pop();
        }
    }
    else if(order == "size"){
        cout << q.size()<< endl;
    }
    else if(order == "empty"){
        if(q.empty())
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }
    else if(order == "front"){
        if(q.empty())
            cout << -1 << endl;
        else
            cout << q.front() << endl;
    }else if(order ==  "back"){
        if(q.empty())
            cout << -1 << endl;
        else
            cout << q.back() << endl;
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