#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void contract (char s1[], char s2[]){
    int i;j = 0;counter = 0;indicator = 0;
    for(i = 0; i < strlen(s1); i++){  / looping threw all the chars in the givven string /
    if( isalnum(s1[i]) ){
        if(s1[i] == s1[i+1] - 1){  /checking if the current char is previous numericly to the next char in the string/
        counter++;
        }
        else if(counter >= 2){ /if the current char isnt numericly previous to the next - we shoring the string according to our sequence/
        s2[j] = s1[i-counter];
            j++;
            s2[j] = '-';
            j++;
            s2[j] = s1[i];
            counter = 0;
            j++;
            indicator =1;
        }else / if the sequence is lesser than 2/
        counter = 0;
        if(counter <= 1 && !(s1[i] ==s1[i+1] - 1 && s1[i+1] == s1[i+2] - 1) && indicator == 0 ){
            s2[j]= s1[i];
            j++;
        }
    }else{
        s2[j]= s1[i];
        j++;
    }
    indicator = 0;
    }
}
int main()
{
    char s1[81];
    char s2[81];
    printf("Please enter a string: ");
    fgets(s1, 81, stdin);
    printf("\nThankyou!");
    contract(s1, s2);
    printf("\nThe string you inputed is: %s\nShortened string: %s\n", s1,s2); /ptinting the new shorted string*/
    return 0;
}
