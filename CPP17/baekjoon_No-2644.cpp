#include <iostream>
#include <string.h>

struct person_info{

};

int main()
{
    int person_cnt, relate_cnt;
    int cal_person_1, cal_person_2;
    std::cin >> person_cnt;
    std::cin >> cal_person_1 >> cal_person_2;
    std::cin >> relate_cnt;

    int relate[relate_cnt][2]; // [relate_num],[parent][child][layer]
    memset(relate,'0',sizeof(relate));

    for(int i = 0; i < relate_cnt; i++){
        std::cin >> relate[i][0] >> relate[i][1];
    }
    return 0;
}