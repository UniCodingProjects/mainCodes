#include "utils.h"

/*  main func */
int main(int argc, char** argv){
    int n;
    if (argc < MIN_ARGS) {
        printf("not enough args, received: %d, min allowed: %d\n", argc, MIN_ARGS);
        return -1;
    }
    n = loadIndexArg(argv[1], argv);
    if (n == -1) return n;
    printf("looking for char at idx: %d\n==================\n", n);
    runner(argc, argv, n);
    printf("Done, exiting.");
    return 0;
}

/* checks that entered idx is valid */
int loadIndexArg(char * number, char** argv){
    char *end;
    int i = 0;
    if (number[i] == '-') {
        printf("ERROR\n");
        return -1;
    }
    for (i = 0; i < (int)strlen(number); i++){
        if (!isdigit(number[i])) return 1;
    }
    i = (int) strtod(argv[1], &end);
    if (i == 0) {
        printf("zero index, ERROR\n");
        return -1;
    }
    return i;
}

/* checks that file was opened properly and can be accessed */
int loadProperFile(char** argv, int fileCounter, long currPointer, int n){
    FILE * filepointer = fopen(path,"r");
    if (!filepointer){
        perror("cant open file");
        exit(0);
    }
    else {
        fseek(filepointer, 0, SEEK_END);
        currPointer = ftell(filepointer);
        if (currPointer < n-1) {
            printf("file length is: %p smaller than given idx: %d\n==================\n",(void *)&currPointer, n);
            return -1;
        }
    }
    printf("found file: %s\n", argv[fileCounter]);
    return 0;
}

/* main runner func that runs in a loop and checks for (n-1)th idx in file converts to ASCII and prints to stdout*/
void runner(int argc, char** argv, int n){
    int res;
    long currPointer = 0;
    FILE * filepointer;
    for (int fileCounter = 2; fileCounter < argc; fileCounter++){
        filepointer = fopen(argv[fileCounter], "r");
        res = loadProperFile(currFile, argv, fileCounter, currPointer, n);
        if (res == -1) continue;
        fseek(filepointer, n-1, SEEK_SET);
        currPointer = ftell(filepointer);
        printf("pointer at: %p (due to zero based n-1)\n",(void *)&currPointer);
        printf("ASCII representation is: %d\n==================\n", (int) getc(filepointer));
    }
}
