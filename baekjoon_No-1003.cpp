#include <stdio.h>
#include <iostream>

int main(void)
{
    int T = 0;
    int ret[41][2];
    int N = 0;
    
    ret[0][0] = 1;
    ret[0][1] = 0;
    ret[1][0] = 0;
    ret[1][1] = 1;
    
    std::cin >> T; 

    for(int i=2;i<41;i++){
        ret[i][0] = ret[i-2][0] + ret[i-1][0];
        ret[i][1] = ret[i-2][1] + ret[i-1][1];
    }

    for(int i = 0; i < T; i++){
        std::cin >> N;
        std::cout << ret[N][0] << " " << ret[N][1] << std::endl;
    }
    return 0;
}