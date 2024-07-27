#include<iostream>
#include<algorithm>

using namespace std;

int main()
{
    int startPoint, endPoint;
    
    cin >> startPoint >> endPoint;
    bool checkMap[endPoint+1] = {false,};
    fill(checkMap+2, checkMap + endPoint+1, true);
    // for(int i = 0; i<endPoint+1; i++)
    //     cout << checkMap[i] << endl;
        
        
    for(int i = 2; i*i<=endPoint; i++){
        if(checkMap[i])
            for(int j = i*i; j<=endPoint; j+=i){
                checkMap[j] = false;
            }
    }
    
    
    for(int i=startPoint; i<=endPoint; i++){
        if(checkMap[i])
            cout << i << "\n";       
    }
}