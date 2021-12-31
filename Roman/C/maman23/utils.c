#include "utils.h"

/* checks that entered idx is valid */
int assertIndexArg(char * number, char * argv[]){
    char *end;
    int i = 0;
    if (number[i] == '-') {
        printf("== negative index is unacceptable, aborting... ===\n");
        return -1;
    }
    for (; i < (int)strlen(number); i++){
        if (!isdigit(number[i])) return 1;
    }
    i = (int) strtod(argv[1], &end);
    if (i == 0) {
        printf("zero idx is unacceptable, aborting... ===\n");
        return -1;
    }
    return i;
}

/* checks that file was opened properly and can be accessed */
int assertProperFile(FILE * currFile, char * argv[], int fileCounter, long currPointer, int n){
    if (!currFile){
        printf("No file found: %s\n==================\n", argv[fileCounter]);
        return -1;
    }
    else {
        fseek(currFile, 0, SEEK_END);
        currPointer = ftell(currFile);
        if (currPointer < n-1) {
            printf("file length is: %lo smaller than given idx: %d\n==================\n", currPointer, n);
            return -1;
        }
    }
    printf("found file: %s\n", argv[fileCounter]);
    return 0;
}

/* main runner func that runs in a loop and checks for (n-1)th idx in file converts to ASCII and prints to stdout*/
void runner(int argc, char * argv[], int n){
    int res;
    long currPointer = 0;
    int fileCounter = 2;
    FILE * currFile;
    for (; fileCounter < argc; fileCounter++){
        currFile = fopen(argv[fileCounter], "r");
        res = assertProperFile(currFile, argv, fileCounter, currPointer, n);
        if (res == -1) continue;
        fseek(currFile, n-1, SEEK_SET);
        currPointer = ftell(currFile);
        printf("pointer at: %lo (due to zero based n-1)\n", currPointer);
        printf("ASCII representation is: %d\n==================\n", (int) getc(currFile));
    }
}

