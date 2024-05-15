#include <iostream>

int main()
{
    int N, start_num = 666, search_num = 666;
    int count_6 = 0, result_count = 0;
    std::cin >> N;

    while(1){
        search_num = start_num;
        count_6 = 0;
        while(search_num > 0){
            if(search_num%10 == 6){
                count_6++;
                if(count_6 == 3){
                    result_count++;
                    break;
                }
            }else{
                count_6 = 0;
            }
            search_num /= 10;
        }
        if(result_count == N){
            break;
        }
        start_num++;
    }
    std::cout << start_num << std::endl;
    return 0;
}