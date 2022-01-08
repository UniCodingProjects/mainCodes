#include "complex.h"

/* Assigns a new memory space to the complex and initializes with default values*/
complex * complex_constructor()
{
    complex *temp=(complex *)malloc(sizeof(complex));
    /* integrity check*/
    if(temp==NULL)
    {
        printf("ERROR : memory allocation failed\n");
        exit(1);
    }
    temp->real=0;
    temp->imaginary=0;
    return(temp);
}

/*
* Placing a composite value in a variable.
* The first real number is the real part, and the second real number is the imaginary part
*/
complex * read_comp(complex *number, float x,float y)
{
    number->real=x;
    number->imaginary=y;
    return number;
}

/* Prints the complex number*/
int print_comp(complex *number)
{
    printf("\n%.2f", number->real);
    if(number->imaginary >=0) printf("+(%.2f)i",number->imaginary);
    /* if the imaginary part is bigger or equal to 0*/
    else printf("-(%.2f)i",number->imaginary);
    return 0;
}

/* Addition of the two composite numbers that the function receives*/
complex * add_comp(complex *number1,complex *number2)
{
    complex * add=complex_constructor();/*temp */
    /* (a+bi)+(c+di)=(a+c)+(b+d)i */
    add->real= number1->real+number2->real;
    add->imaginary=number1->imaginary+number2->imaginary;
    return add;
}

/* Subtraction of the two composite numbers that the function receives*/
complex * sub_comp(complex *number1, complex *number2)
{
    complex * sub=complex_constructor();/*temp*/
    /* (a+bi)-(c+di)=(a-c)+(b-d)i */
    sub->real= number1->real - number2->real;
    sub->imaginary=number1->imaginary-number2->imaginary;
    return sub;

}

/* Multiplication of the complex number and the real number that the function receives*/
complex * mult_comp_real(complex *number,float x)
{
    complex * mult=complex_constructor();/*temp*/
    /* s(a+bi)=sa+sbi */
    mult->real=x*number->real;
    mult->imaginary=x*number->imaginary;
    return mult;

}

/* Multiplication of the complex number and the imaginary number that the function receives*/
complex * mult_comp_img(complex *number,float x)
{
    complex * mult=complex_constructor();/*temp*/
    /* si(a+bi)=sai+sbi*i=-sb+sai */
    mult->real=number->imaginary*(-x);
    mult->imaginary=number->real*x;
    return mult;

}

/* Multiplication of the two complex numbers that the function receives*/
complex * mult_comp_comp(complex *number1,complex *number2)
{
    complex * mult=complex_constructor();/*temp*/
    /*(a+bi)(c+di)=ac+bci+adi+bdi*i=(ac-bd)+(ad+bc)i*/
    mult->real=(number1->real*number2->real)-(number1->imaginary*number2->imaginary);
    mult->imaginary=(number1->real*number2->imaginary)+(number1->imaginary*number2->real);
    return mult;

}

/* The absolute value of the composite variable that the function receives is calculated*/
float abs_comp(complex *number){
    float num ;
    /*sqrt(real^2+img^2) */
    num =sqrt(pow(number->real,2)+pow(number->imaginary,2));
    return num;

}
