#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#include <stdalign.h>
#include <math.h>


#define Max_line 101
#define ERROR -1
#define Max_command 15
#define Num_Of_Comp 6

typedef struct n{
    float real ;
    float imaginary ;
} complex;

/* function prototype*/

/* Assigns a new memory space to the complex and initializes with default values*/
complex * complex_constructor();

/* The function return the index where there is the nearest comma starting from the index that sent to the function */
int is_comma(char parameteres[], int lastIndex);

/**/
int is_number(char parameteres[], int lastIndex, int before);

/*

*/
int is_comp(char parameteres[], int lastIndex, int before);

/* run the function acording to what the user entered */
void run_function(char *, char command[Max_line],complex *comp[6]);

/* return the command and the rest of the line that the user entered */
char ** return_command(char line[]);

/* check if there is extra tabs after the command */
int check_rest(char parameters[], int lastIndex);

/*int check(int a,char *parm, char *arranged_par[Max_parmeters]);*/

/*
* Placing a composite value in a variable.
* The first real number is the real part, and the second real number is the imaginary part
*/
complex * read_comp(complex *, float,float);

/* Prints the complex number*/
int print_comp(complex *);

/* Connection of the two composite numbers that the function receives*/
complex * add_comp(complex *,complex *);

/* Connection of the two composite numbers that the function receives*/
complex * sub_comp(complex *, complex *);

/* Multiplication of the complex number and the real number that the function receives*/
complex * mult_comp_real(complex *,float);

/* Multiplication of the complex number and the imaginary number that the function receives*/
complex * mult_comp_img(complex *,float);

/* Multiplication of the two complex numbers that the function receives*/
complex * mult_comp_comp(complex *,complex *);

/* The absolute value of the composite variable that the function receives is calculated*/
float abs_comp(complex *);

/* returns the appropriate complex according to what is in the submitted index*/
complex* return_comp(char parameters[Max_line],complex *comp[6],int lastIndex);
