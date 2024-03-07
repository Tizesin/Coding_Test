#include <stdio.h>
#include <iostream>

int main(void)
{
    int test_case = 0;
    std::cin >> test_case;
    for(int a = 0; a < test_case; a++){
        int EAST_pin, WEST_pin;
        long long result = 1;
        std::cin >> WEST_pin;
        std::cin >> EAST_pin;
        
        int c = 1;
        for(int i = EAST_pin; i > EAST_pin-WEST_pin; i--){
            result = result * i;
            result = result / c;
            c++;
        }
        std::cout << result << std::endl;
    }
    
}
