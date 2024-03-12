#include <iostream>
#include <algorithm>

int main()
{
    int rope_cnt ,can = -1;
    std::cin >> rope_cnt;
    int rope[rope_cnt];

    for(int i = 0; i < rope_cnt; i++){
        std::cin >> rope[i];
    }
    std::sort(rope,rope+rope_cnt);

    for(int i = 0; i < rope_cnt; i++){
        if(can < rope[i]*(rope_cnt-i)){
            can = rope[i]*(rope_cnt-i);
        }
    }
    std::cout << can;
    return 0;
}