#include "utils.h"

/*  main func */
int main(int argc, char * argv[]){
    int n;
    if (argc < MIN_ARGS) {
        printf("not enough args, received: %d, min allowed: %d\n", argc, MIN_ARGS);
        return -1;
    }
    n = assertIndexArg(argv[1], argv);
    if (n == -1) return n;
    printf("looking for char at idx: %d\n==================\n", n);
    runner(argc, argv, n);
    printf("Done, exiting.");
    return 0;
}
