
#define N 5

typedef int Matrix[N][N];

int getUserInput(Matrix m);

int sumRows(Matrix m, int row, int col, int currSum);

int sumCols(Matrix m, int row, int col, int currSum);

int sumDiag(Matrix m, int row, int col, int currSum);

int assertResults(int results[]);

void checkMatrix(Matrix matrix, int results[]);

void printMatrix(Matrix m);