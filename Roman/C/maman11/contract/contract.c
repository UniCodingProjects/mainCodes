#include <stdio.h>
#include <ctype.h>

void toPrintArr(char s[]){
    int i;
    for (i=0;i<81;i++){
        if (s[i] == '\000' || (int) s[11] == 39) break;
        printf("%c", s[i]);
    }
    printf("\n");
}

void setSequenceStop(char s2[], char first, char last, int idx, int *outPutIdx, int *lastIdx, int *i, char *sequential){
    s2[idx] = first;
    s2[idx + 1] = '-';
    s2[idx + 2] = last;
    *outPutIdx += 3;
    *lastIdx = *i+1;
    *sequential = 0;
}

void setNonSeqStop(char s2[], char curr, int *outPutIdx, int *lastIdx, int *i, char *sequential){
    s2[*outPutIdx] = curr;
    *outPutIdx += 1;
    *lastIdx = *i+1;
    *sequential = 0;
}

int getInputLen(char s1[]){
    int i;
    char counter = 0;
    for (i=0;i<81;i++){
        if (s1[i] == '\n') break;
        counter++;
    }
    return counter;
}

void fillOutput(char s1[], char s2[], int len){
    int i = 0, lastIdx = 0, outPutIdx = 0;
    char curr, next, isSpace = 0, sequential = 0;

    for (i=0; i<len; i++) {
        curr = s1[i];
        next = s1[i+1];
        if (curr == '\n' || curr == EOF) break;
        if (curr == ' ') isSpace = 1; else isSpace = 0;
        if (!isalnum(curr) || curr == next){
            if (sequential > 1 && isSpace == 0){
                setSequenceStop(s2, s1[lastIdx], curr, outPutIdx, &outPutIdx, &lastIdx, &i, &sequential);
                continue;
            }
            setNonSeqStop(s2, curr, &outPutIdx, &lastIdx, &i, &sequential);
            continue;
        }
        if ((curr < next) && (curr - next) == -1){
            sequential++;
            continue;
        }
        if ((sequential > 1) && isSpace == 0){
            setSequenceStop(s2, s1[lastIdx], curr, outPutIdx, &outPutIdx, &lastIdx, &i, &sequential);
            continue;
        }
        else{
            if (sequential == 1){
                setNonSeqStop(s2,  s1[lastIdx], &outPutIdx, &lastIdx, &i, &sequential);
                setNonSeqStop(s2,  s1[i], &outPutIdx, &lastIdx, &i, &sequential);
                continue;
            }            setNonSeqStop(s2,  s1[lastIdx], &outPutIdx, &lastIdx, &i, &sequential);
            continue;
        }
    }
}

void contract(char s1[], char s2[]){
    int len = getInputLen(s1);
    fillOutput(s1, s2, len);
}

int main(){
    char input[81]; /* input str max size is 81 due to zero based ~ 0-80*/
    char output[81];

    printf("Enter a random char sequence or input from a txt file, max allowed characters = 80\n");
    fgets(input, 81, stdin);

    contract(input, output);
    printf("Input sequence: ");
    toPrintArr(input);
    printf("Output sequence: ");
    toPrintArr(output);

    return 0;
}
