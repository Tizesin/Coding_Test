#include <iostream>

int main(void)
{
    int val, coin_5 = 0, coin_2 = 0;

    std::cin >> val;
    coin_2 = val/2;
    if(val-(coin_2*2) == 1){
        if(coin_2 > 1){
            coin_2 -= 2;
            coin_5 += 1;
        }else{
            std::cout << -1;
            return 0;
        }
    }
    while(coin_2 / 5){
        coin_2 -= 5;
        coin_5 += 2;
    }
    std::cout << coin_2 + coin_5;
    return 0;
}