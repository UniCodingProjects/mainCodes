#include <stdio.h>

struct {
    char arr[100];
} line;

void checkCurrChar(char stop, char c, char *curlyBracersC, char *squareBracersC, char *roundBracersC, char *fail,
                   char *roundBracersAll, char *curlyBracersAll, char *squareBracersAll);

void checkIfLineIsBalanced(char *roundBracersC, char *curlyBracersC,
        char *squareBracersC, char *lineCounter, char *charInLineC);

char checkBalance(char roundBracersC, char curlyBracersC, char squareBracersC){
    if ((roundBracersC == 0) && (curlyBracersC == 0) && (squareBracersC == 0)){
        return 1;
    }
    return 0;
}

void checkCurrChar(char stop, char c, char *curlyBracersC, char *squareBracersC, char *roundBracersC, char *fail,
        char *roundBracersAll, char *curlyBracersAll, char *squareBracersAll){
    if (stop == 0) {
        if (c == '(') {*roundBracersC += 1; *roundBracersAll +=1;}
        else if (c == '{') {*curlyBracersC += 1; *curlyBracersAll +=1;}
        else if (c == '[') {*squareBracersC += 1; *squareBracersAll +=1;}
        else if (c == ')') {*roundBracersC -= 1; *roundBracersAll -=1;}
        else if (c == '}') {*curlyBracersC -= 1;*curlyBracersAll -=1;}
        else if (c == ']') {*squareBracersC -= 1; *squareBracersAll -=1;}

        if (*roundBracersAll < 0 || *curlyBracersAll < 0 || *squareBracersAll < 0){
            *fail = 1;
        }
    }
}

void printLn(char stop, char lineN){
    int i = 0;
    printf("--:>>%d  ", lineN);
    for (i=0;i<stop;i++){
        printf("%c", line.arr[i]);
    }
}

void checkIfEndOfLine(char c, char *charInLineC, char *lineCounter,
        char *roundBracersC, char *curlyBracersC, char *squareBracersC){
    if (c == '\n' || c == EOF){
        checkIfLineIsBalanced(roundBracersC, curlyBracersC, squareBracersC, lineCounter, charInLineC);
        printLn(*charInLineC, *lineCounter);
        *charInLineC = 0;
        *lineCounter += 1;
    }
}

void resetCounters(char *roundBracersC, char *curlyBracersC, char *squareBracersC){
    *roundBracersC = 0;
    *curlyBracersC = 0;
    *squareBracersC = 0;
}

void checkIfLineIsBalanced(char *roundBracersC, char *curlyBracersC, char *squareBracersC, char *lineCounter,
        char *charInLineC){
    if (checkBalance(*roundBracersC, *curlyBracersC, *squareBracersC) == 0){
        printf("Line: #%d: is unbalanced\n", *lineCounter);
        resetCounters(roundBracersC, curlyBracersC, squareBracersC);
    }
}

char toStop(char c, char stop, char *charInLineC, char lineCounter, char roundBracersC,
        char curlyBracersC, char squareBracersC, char *continueFlag) {
    line.arr[(int) *charInLineC] = c;
    *charInLineC += 1;
    if (c == '/'){
        char next = getchar();
        line.arr[(int)*charInLineC] = next;
        *charInLineC += 1;
        checkIfEndOfLine(c, charInLineC, &lineCounter, &roundBracersC, &curlyBracersC, &squareBracersC);
        if (*charInLineC == 0) {*continueFlag = 1; return stop;}
        if (next == '*') {
            *continueFlag = 1;
            return 1;
        }
    }
    else if (c == '*'){
        char next = getchar();
        line.arr[(int)*charInLineC] = next;
        *charInLineC += 1;
        checkIfEndOfLine(c, charInLineC, &lineCounter, &roundBracersC, &curlyBracersC, &squareBracersC);
        if (*charInLineC == 0) {*continueFlag = 1; return stop;}
        if (next == '/') {
            *continueFlag = 1;
            return 0;
        }
    }
    else if (c == '"' && stop == 0){
        *continueFlag = 1;
        return 1;
    }
    else if (c == '"' && stop == 1){
        *continueFlag = 1;
        return 0;
    }
    return stop;
}

void report(char curlyBracersAll, char squareBracersAll, char roundBracersAll, char fail){
    printf("\nCurly parenthesis: %d, Square parenthesis: %d, Round parenthesis: %d\n",
            curlyBracersAll, squareBracersAll, roundBracersAll);
    if (!(curlyBracersAll == 0 && squareBracersAll == 0 && roundBracersAll == 0)) {
        printf("Input is unbalanced due to uneven number of parentheses\n");
    }
    else if (fail == 1) {
        printf("Input is unbalanced due to wrong order of parenthesis\n");
    }
    else{
        printf("Proper parenthesis placement in input\n");
    }
}

int main(){
    char ch;
    char roundCounter = 0, curlyCounter= 0, squareCounter = 0;
    char roundCounterAll = 0, curlyCounterAll = 0, squareCounterAll = 0;
    char stop = 0, continueFlag = 0;
    char charCounter = 0, lineCounter = 1;
    char fail = 0;

    printf("Please input your code as a string or redirect from file to check parentheses\n");
    while ((ch = getchar()) != EOF) {
        stop = toStop(ch, stop, &charCounter, lineCounter, roundCounter, curlyCounter, squareCounter, &continueFlag);
        if (continueFlag == 1){
            continueFlag = 0;
            continue;
        }
        checkIfEndOfLine(ch, &charCounter, &lineCounter, &roundCounter, &curlyCounter, &squareCounter);
        checkCurrChar(stop, ch, &curlyCounter, &squareCounter, &roundCounter, &fail,
                      &roundCounterAll, &curlyCounterAll, &squareCounterAll);
    }
    line.arr[(int)charCounter] = ch;
    checkIfEndOfLine(ch, &charCounter, &lineCounter, &roundCounter, &curlyCounter, &squareCounter);
    report(curlyCounterAll, squareCounterAll, roundCounterAll, fail);
    return 0;
}