/*Matrix size definition*/
#define N 10

/*2D array definition*/
typedef int Matrix[N][N];

/*All of the below methods are explained in the magic.c source file*/

int createMatrix(Matrix m);

int sumRows(Matrix m, int row, int col, int currSum);

int sumCols(Matrix m, int row, int col, int currSum);

int sumDiag(Matrix m, int row, int col, int currSum);

int assertResults(int results[]);

void checkMatrix(Matrix matrix, int results[]);

void printMatrix(Matrix m);