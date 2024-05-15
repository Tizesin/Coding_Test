#include <iostream>

int triangle[46];

int cal(int num)
{
    for(int i = 1; i <= 45; i++) {
        for(int j = 1; j <= 45; j++) {
            for(int a = 1; a <= 45; a++) {
                if(triangle[i] + triangle[j] + triangle[a] == num)
                    return 1;
            }
        }
    }
    return 0;
}
int main()
{
    int test_case, num;
    std::cin >> test_case;

    for(int i = 1; i <= 45; i++){
        triangle[i] = i*(i+1)/2;
    }
    for(int i = 0; i < test_case; i++){
        std::cin >> num;
        std::cout << cal(num) << std::endl;
    }
    return 0;
}