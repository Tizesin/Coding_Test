#include <iostream>

int main(void)
{
    int test_case = 0;
    int ret[41][2];
    int N = 0;
    
    //피보나치 함수에서 0의 값 대입
    ret[0][0] = 1;
    ret[0][1] = 0;

    //피보나치 함수에서 1의 값 대입
    ret[1][0] = 0;
    ret[1][1] = 1;
    
    std::cin >> test_case; 

    //피보나치 함수 2 ~ 40 까지의 값
    for(int i=2;i<41;i++){
        ret[i][0] = ret[i-2][0] + ret[i-1][0];
        ret[i][1] = ret[i-2][1] + ret[i-1][1];
    }

    for(int i = 0; i < test_case; i++){
        std::cin >> N;
        std::cout << ret[N][0] << " " << ret[N][1] << std::endl;
    }
    return 0;
}