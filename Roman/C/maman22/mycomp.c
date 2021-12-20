#include <stdio.h>
#include "complex.h"
#include "parser.h"

int main(){
    Complex array[6];
    array[0] = readComp(0, 0);
    array[1] = readComp(0, 0);
    array[2] = readComp(0, 0);
    array[3] = readComp(0, 0);
    array[4] = readComp(0, 0);
    array[5] = readComp(0, 0);

    /* get input till \n */
    callParser(array);
    printf("error - did not receive stop cmd");
    return -1;
}