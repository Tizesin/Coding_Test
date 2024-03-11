#include <iostream>
#include <string.h>

int main()
{
    // var 선언
    char array[1000000]={0};
    char* cut_text;
    int cut_cnt = 0;

    //입력받기 [^\n] -> fget 이게 나을수도 있다.
    scanf("%[^\n]s", array);

    cut_text = strtok(array," ");

    while(cut_text){
        cut_text = strtok(NULL," ");
        cut_cnt++;
    }
    printf("%d",cut_cnt);
}