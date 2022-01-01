#include <stdio.h>
#include <unistd.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

/* min args allowed*/
#define MIN_ARGS 3

/* checks that entered idx is valid */
int assertIndexArg(char * number, char * argv[]);

/* checks that file was opened properly and can be accessed */
int assertProperFile(FILE * currFile, char * argv[], int fileCounter, long currPointer, int n);

/* main runner func that runs in a loop and checks for (n-1)th idx in file converts to ASCII and prints to stdout*/

void runner(int argc, char * argv[], int n);