/* complex number struct defintion + typdef for easier use */
typedef struct {
    double real;
    double imag;
    char i;
    double abs;
} Complex;

/* function to assign complex number to its variable */
Complex readComp(double real, double imag);

/* prints the desired complex number */
void printComp(Complex comp, char caseToPrint);

/* sums 2 complex numbers */
void addComp(Complex c1, Complex c2);

/* subtracts 2 complex numbers: c1 from c2 */
void subComp(Complex c1, Complex c2);

/* multiply a complex number by a real number */
void multiplyCompReal(Complex c, double real);

/* multiply a complex number by an imaginary number */
void multiplyCompImag(Complex c, double imag);

/* multiply one complex number by another complex number */
void multiplyCompComp(Complex c1, Complex c2);

/* print absolute of a given complex number */
void absComp(Complex c);