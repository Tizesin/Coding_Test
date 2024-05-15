#include <iostream>
#include <string.h>

int main()
{
    // var 선언
    char text[1000000]={0,};
    char* cut_text;
    int cut_cnt = 0;

    //입력받기 [ %[^/n]s의 의미는 문자열에서 개행문자를 제외한 모든 문자를 읽는 다는 뜻.]
    scanf("%[^\n]s", text);

    cut_text = strtok(text," ");

    while(cut_text){
        cut_text = strtok(NULL," ");
        cut_cnt++;
    }
    printf("%d",cut_cnt);
}