#include <stdio.h>
#include <math.h>
#include "complex.h"

Complex readComp(double real, double imag) {
    Complex comp;
    comp.real = real;
    comp.imag = imag;
    comp.i = 'i';
    return comp;
}

void printComp(Complex comp, char caseToPrint){
    switch (caseToPrint){
        case 'a':
            printf("%.2f\n", comp.abs);
            break;
        case 'c':
            printf("%.2f + (%.2f)%c\n", comp.real, comp.imag, comp.i);
            break;
    }
}

void addComp(Complex c1, Complex c2){
    Complex result;
    result.real = c1.real + c2.real;
    result.imag = c1.imag + c2.imag;;
    result.i = 'i';
    printComp(result, 'c');
}

void subComp(Complex c1, Complex c2){
    Complex result;
    result.real = c1.real - c2.real;
    result.imag = c1.imag - c2.imag;;
    result.i = 'i';
    printComp(result, 'c');
}

void multiplyCompReal(Complex c, double real){
    Complex result;
    result.real = c.real * real;
    result.imag = c.imag * real;;
    result.i = 'i';
    printComp(result, 'c');
}

void multiplyCompImag(Complex c, double imag){
    Complex result;
    result.real = -1*imag * c.imag;
    result.imag = imag * c.real;
    result.i = 'i';
    printComp(result, 'c');
}

void multiplyCompComp(Complex c1, Complex c2){
    Complex result;
    result.real = c1.real * c2.real - c1.imag * c2.imag;
    result.imag = c1.real * c2.imag + c1.imag * c2.real;
    result.i = 'i';
    printComp(result, 'c');
}

void absComp(Complex c){
    Complex result;
    result.real = pow(c.real, 2);
    result.imag = pow(c.imag, 2);
    result.abs = sqrt(result.real + result.imag);
    printComp(result, 'a');
}
