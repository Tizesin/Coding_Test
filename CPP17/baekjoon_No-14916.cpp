#include <iostream>

int main(void)
{
    int val, coin_5 = 0, coin_2 = 0;

    std::cin >> val;

    //2원짜리 동전으로 모두 계산할 때..
    coin_2 = val/2;

    //거스름돈 1원이 남았을 경우, 2원 동전 2개를 빼고 5원 동전 하나 추가
    if(val-(coin_2*2) == 1){
        if(coin_2 > 1){
            coin_2 -= 2;
            coin_5 += 1;
        }else{
            std::cout << -1;
            return 0;
        }
    }

    // 2원 동전이 5개 있을 경우.. 5원 동전 2개로 변경
    while(coin_2 / 5){
        coin_2 -= 5;
        coin_5 += 2;
    }
    std::cout << coin_2 + coin_5;
    return 0;
}