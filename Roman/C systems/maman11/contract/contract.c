#include <stdio.h>



char isHigher(char first, char next){
    char boolean = 0;
    
    return boolean;
}






void contract(char s1[], char s2[]){
    int i = 0;
    int len = sizeof(s1);
    for (i=0;i<len;i++){
        printf("%c", s1[i]);
    }
}


int main(){
    FILE *fp;
    char input[81]; /* input str max size is 81 due to zero based ~ 0-80*/
    char output[81];

    fp = fopen("input.txt","r");
    if (fgets(input, 81, fp)){
        puts(input);
        fclose(fp);
    }
    contract(input, output);











    return 0;
}