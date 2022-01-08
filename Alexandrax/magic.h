#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#include <stdalign.h>

/* function prototype*/
int main ();

/*Receives numbers from the user and checks if enough numbers have been entered
and if they are indeed numbers not letters or other signs*/
int input(int *magicSquare[]);


int printSquare(int *magicSquare[]);

int checkingSquare(int *magicSquare[]);

/*the function checks if there are two equal numbers or more in the square
 or if there is a number that goes beyond the limits */
int checkValue(int *magicSquare[]);

/* represent the size of the square*/
#define N 4
#define minimalRange 1
#define maximumRange N*N