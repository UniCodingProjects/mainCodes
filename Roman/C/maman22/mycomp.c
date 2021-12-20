#include <stdio.h>
#include "complex.h"
#include "parser.h"

int main(){
    Complex A = readComp(0, 0);
    Complex B = readComp(0, 0);
    Complex C = readComp(0, 0);
    Complex D = readComp(0, 0);
    Complex E = readComp(0, 0);
    Complex F = readComp(0, 0);

    Complex array[] = {A, B, C, D, E, F};

    /* get input till \n */
    callParser(array);
    printf("error - did not receive stop cmd");
    return -1;
}