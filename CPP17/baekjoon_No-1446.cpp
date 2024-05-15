#include <iostream>
#include <algorithm>

using namespace std;

struct road_info{
    int point; // 0- 아에 탈 필요 없음 1- 얜 무조건 타야 이득임 
    int start;
    int end;
    int cut_time;
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int fast_road_cnt, track, total_path_cnt = 0;
    int m_point, m_start, m_end, m_cut_time;
    cin >> fast_road_cnt >> track;
    road_info fast_road[fast_road_cnt];
    int fast_road_sort[fast_road_cnt];
    for(int i = 0; i < fast_road_cnt; i++){
        cin >> m_start >> m_end >> m_cut_time;

        fast_road_sort[i] = m_start;
        fast_road[i].point = 1;
        fast_road[i].start = m_start;
        fast_road[i].end = m_end;
        fast_road[i].cut_time = m_end-m_start;
        
        if(m_end > track){
            fast_road[i].point = 0;
        }else if(m_end-m_start >= m_cut_time){
            fast_road[i].point = 0;
        }
    }
    for(int i = 0; i<fast_road_cnt; i++){
        if(fast_road[i].point == 0){
            continue;
        }
        for(int j = 0; j<fast_road_cnt; j++){
            if(fast_road[i].start == fast_road[j].start && fast_road[i].end == fast_road[j].end){
                if(fast_road[i].cut_time > fast_road[j].cut_time){
                    fast_road[i].point = 0;
                }
                else{
                    fast_road[j].point = 0;
                }
            }
        }
    }
    //what the fuck?
    
    for(int i = 0; i<fast_road_cnt; i++){
        if(fast_road[i].point == 0)
            continue;
        
    }


    while(1){
        int i = 0;
        int cut_point = track;
        int now_pos = 0;
        if(fast_road_sort[n] < now_pos <= fast_road_sort[n+1]){
            now_pos = fast_road_sort[n+1];
        }
        if(now_pos == fast_road[i].start){
            if(fast_road[i].point == 1){
                now_pos = fast_road[i].end;
                cut_point -= fast_road[i].cut_time;
            }else if(fast_road[i].point == 2){
                fast_road[i].point == 0;
                now_pos = fast_road[i].end;
                cut_point -= fast_road[i].cut_time;
            }
        }
    }
}