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
    
    // 각 로프가 견딜 수 있는 무게를 정렬
    // [0] 가장 약한 로프 [rope_cnt-1] 가장 강한 로프
    std::sort(rope,rope+rope_cnt);

    // 로프의 개수 별 감당 가능 무게 측정
    for(int i = 0; i < rope_cnt; i++){
        if(can < rope[i]*(rope_cnt-i)){
            can = rope[i]*(rope_cnt-i);
        }
    }
    std::cout << can;
    return 0;
}