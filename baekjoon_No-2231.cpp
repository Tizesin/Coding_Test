#include <iostream>
#include <math.h>

int main()
{
    int N, N_MAXLOCATION_NUM, N_size_cnt = 1;

    std::cin >> N;
    N_MAXLOCATION_NUM = N;
    while(1)
    {
        // 가장 높은 자릿수의 숫자 + 자릿수의 개수 체크
        if(N_MAXLOCATION_NUM / 10){
            N_MAXLOCATION_NUM /= 10;
            N_size_cnt++;
        }else{
            break;
        }

    }

    for(int i = pow(10,(N_size_cnt-1))*(N_MAXLOCATION_NUM-3); i < N; i++){
        int j = i;
        int sum_num = 0;
        while(j)
        {
            sum_num += j%10;
            j /= 10;
        }
        if(N == sum_num+i){
            std::cout << i;
            return 0;
        }
    }
    std::cout << "0";
    return 0;
}