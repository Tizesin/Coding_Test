#include <stdio.h>
#include <iostream>
#include <vector>

// 이 건물이 지어지는데 걸리는 시간 / 총 시간 / 짓기위한 조건을 저장하는 구조체
struct building_info {
    int only_build_time = -1;
    int total_build_time = -1;
    std::vector<int> relate_buildings;
};

// 해당 건물을 짓기 위해 걸리는 총 시간 계산 함수
int total_build_time_cal(int building_num,building_info* B_i)
{
    //이 건물을 짓는데 걸려있는 조건의 개수 파악
    int relate_buildings_cnt = B_i[building_num].relate_buildings.size();
    for(int i = 0; i < relate_buildings_cnt; i++){
        // 이 건물을 짓는데 걸려있는 조건의 건물이 완공되는데 걸리는 총 시간.
        int relate_buildings_total_build_time = B_i[B_i[building_num].relate_buildings[i]].total_build_time;
        // 이 건물을 짓는데 걸려있는 조건의 건물이 완공되는데 걸리는 총 시간이 아직 구해지지 않은 상태라면..?
        if(relate_buildings_total_build_time == -1){
            //이 건물을 짓는데 걸려있는 조건의 건물이 완공되는데 걸리는 총 시간을 구하기 위해 재귀함수 선언
            total_build_time_cal(B_i[building_num].relate_buildings[i],B_i);
        }
    }

    //이 건물을 짓는데 걸려있는 조건의 개수 파악하여 모든 조건이 충족 될 때의 시간을 계산.
    switch(relate_buildings_cnt){
        case 0:
            B_i[building_num].total_build_time = B_i[building_num].only_build_time;
            break;
        case 1:
            B_i[building_num].total_build_time = B_i[building_num].only_build_time + B_i[B_i[building_num].relate_buildings[0]].total_build_time;
            break;
        default:
            int max_relate_build_time = 0;
            for(int i = 0; i < relate_buildings_cnt; i++){
                if(max_relate_build_time < B_i[B_i[building_num].relate_buildings[i]].total_build_time)
                    max_relate_build_time = B_i[B_i[building_num].relate_buildings[i]].total_build_time;
            }
            B_i[building_num].total_build_time = B_i[building_num].only_build_time + max_relate_build_time;
    }
    return B_i[building_num].total_build_time;
}
int main(void)
{
    int test_case; // 테스트 케이스 개수
    int building_cnt; // 건물 개수
    int build_rule; // 건물 규칙(건설 조건) 개수
    int build_rule_start,build_rule_end; // 이 건물이 지어져야(build_rule_start).. 이 건물을 지을 수 있다(build_rule_end).
    int spc_building; // 특정 건물

    std::cin >> test_case;

    for(int i = 0; i < test_case; i++){
        std::cin >> building_cnt >> build_rule;
        struct building_info B_i[building_cnt+1]; // 0번 배열은 공백. -> 건물 번호가 1번 부터 시작하기에 보기 편하게..
        
        for(int i = 1; i < building_cnt+1; i++){
            std::cin >> B_i[i].only_build_time;
        }

        for(int i = 0; i < build_rule; i++){
            std::cin >> build_rule_start;
            std::cin >> build_rule_end;
            //이 빌딩을 짓기 위해 필요한 건물 정보를 저장.
            B_i[build_rule_end].relate_buildings.push_back(build_rule_start);
        }

        std::cin >> spc_building;
        std::cout << total_build_time_cal(spc_building,B_i) << std::endl;
    }
    return 0;
}