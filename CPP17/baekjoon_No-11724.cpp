#include <iostream>

struct line_info{
    int line_use = 0;
    int line_end_p_1 = 0;
    int line_end_p_2 = 0;
};
int N, M, result = 0;

void cal(int num,line_info *line)
{
    line[num].line_use = 1;
    for(int j = 1; j < M+1; j++){
        if(line[j].line_use != 1){
            if(line[j].line_end_p_1 == num){
                line[j].line_use = 1;
                cal(line[j].line_end_p_2,line);
            }
            else if(line[j].line_end_p_2 == num){
                line[j].line_use = 1;
                cal(line[j].line_end_p_1,line);
            }
        }
    }
}

int main() 
{
    std::cin >> N >> M;
    
    line_info line[M+1];
    for(int i = 1; i < M+1; i++)
        std::cin >> line[i].line_end_p_1 >> line[i].line_end_p_2;

    for(int j = 1; j < M+1; j++){
        if(line[j].line_use == 0){
            cal(line[j].line_end_p_1,line);
            result++;
        }
    }
    std::cout << result << std::endl;
}