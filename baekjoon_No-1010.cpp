#include <stdio.h>
#include <iostream>

long combination(long a)
{
    int result = 1;
    while(a)
    {
        result *= a;
        a--;
    }
    return result;
}

int main(void)
{
    int test_case = 0;
    int EAST_pin, WEST_pin;
    int result;
    std::cin >> test_case;
    for(int a = 0; a < test_case; a--){
        std::cin >> WEST_pin;
        std::cin >> EAST_pin;
        std::cout << combination(WEST_pin) << std::endl;
        std::cout << combination(EAST_pin) << std::endl;
        std::cout << combination(EAST_pin-WEST_pin) << std::endl;
        result = combination(EAST_pin)/(combination(WEST_pin)*combination(EAST_pin-WEST_pin));
        std::cout << result << std::endl;
    }
    
}