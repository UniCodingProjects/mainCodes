#include <stdio.h>
#include "header.h"

/*driver code for the assignment*/
int main(){
    Matrix matrix; /* 5x5 matrix, 2D array type. */
    int res = createMatrix(matrix);
    int results[N*2+1];
    if (res == 1) return 1;
    printMatrix(matrix);
    checkMatrix(matrix, results);
    res = assertResults(results);
    if (res == 0) printf("Matrix is a magic square, congratulations!\n");
    else printf("The given matrix is not a magic square\n");
    return 0;
}


/* get input from user and assign to the matrix by order from left to right */
int createMatrix(Matrix m){
    int row = 0;
    int col = 0;
    int counter = 0;
    printf("Please enter %d numbers for %dx%d matrix: \n", N*N, N, N);
    while (scanf("%d", &m[row][col]) != EOF) {
        counter++;
        if (counter > N*N){
            printf("Received: >%d, Max: %d, or received non-integer input", counter, N*N);
            return 1;
        }
        if (col + 1 == N){
            col = 0;
            row++;
        }
        else{
            col++;
        }
    }
    if (counter < N*N){
        printf("Received: %d, required: %d, aborting.\n", counter, N*N);
        return 1;
    }
    else{
        printf("Received proper values for matrix.\n");
    }
    return 0;
}

/*print the matrix*/
void printMatrix(Matrix m){
    int row, col;
    for (row=0; row < N; row++){
        for (col=0; col < N; col++){
            printf("%d ", m[row][col]);
            if (col + 1 == N){
                printf("\n");
            }
        }
    }
}

/*calculate the sum of each row values*/
int sumRows(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (col +1 >= N){
        return currSum;
    }
    return sumRows(m, row, col +1, currSum);
}

/*calculate the sum of each col values*/
int sumCols(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (row +1 >= N){
        return currSum;
    }
    return sumCols(m, row+1, col, currSum);
}

/*calculate the sum of the diagonal values*/
int sumDiag(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (row +1 >= N && col +1 >= N){
        return currSum;
    }
    return sumDiag(m, row+1, col+1, currSum);
}

/*gather the sums for the matrix to assert if its a magic square according to the definition*/
void checkMatrix(Matrix matrix, int results[]){
    int a = 0;
    int rows;
    int cols;
    int resCounter = 0;
    for (rows = N-1; rows >= 0; rows--){
        a = sumRows(matrix, rows, 0, 0);
        results[resCounter] = a;
        resCounter++;
    }
    for (cols = N-1; cols >= 0; cols--){
        a = sumCols(matrix, 0, cols, 0);
        results[resCounter] = a;
        resCounter++;
    }
    results[resCounter] = sumDiag(matrix, 0, 0, 0);
}

/*check if the matrix is indeed a magic square*/
int assertResults(int results[]){
    int i;
    for (i = 0; i < N*2; i++){
        if (results[i] != results[i+1]){
            return 1;
        }
    }
    return 0;
}