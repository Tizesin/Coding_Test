#include <iostream>

 using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int weight;
    int total_5bag_cnt = 0,total_3bag_cnt = 0;
    cin >> weight;

    if(weight>=5){
        total_5bag_cnt += (weight/5);
        weight = weight%5;
    }

    while(weight){
        if(weight>=3){
            total_3bag_cnt += (weight/3);
            weight = weight%3;
        }
        else if(weight<3){
            if(total_5bag_cnt){
                total_5bag_cnt--;
                weight+=5;
            }
            else{
                cout << -1;
                return 0;
            }
        }
    }
    cout << total_5bag_cnt+total_3bag_cnt;
}