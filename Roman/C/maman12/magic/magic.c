#include <stdio.h>
#include "header.h"

int main(){
    Matrix matrix; /* 5x5 matrix, 2D array type. */
    int res = getUserInput(matrix);
    int results[N*2+1];
    if (res == 1) return 1;
    printMatrix(matrix);
    checkMatrix(matrix, results);
    res = assertResults(results);
    if (res == 0) printf("Matrix is a magic square, congratulations!");
    else printf("The given matrix is not a magic square");
    return 0;
}


/* get input from user and assign to the matrix by order frm left to right */
int getUserInput(Matrix m){
    int row = 0;
    int col = 0;
    printf("Please enter %d numbers for %dx%d matrix: \n", N*N, N, N);
    for (row=0; row < N; row++){
        for (col=0; col < N; col++){
            if (scanf("%d", &m[row][col]) == 0){
                printf("not enough input numbers for a 5x5 matrix / non integer value received");
                return 1;
            }
        }
    }
    printf("\n");
    return 0;
}


void printMatrix(Matrix m){
    int row, col;
    printf("Received proper values for matrix: \n");
    for (row=0; row < N; row++){
        for (col=0; col < N; col++){
            printf("%d ", m[row][col]);
            if (col + 1 == N){
                printf("\n");
            }
        }
    }
}

int sumRows(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (col +1 >= N){
        return currSum;
    }
    return sumRows(m, row, col +1, currSum);
}

int sumCols(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (row +1 >= N){
        return currSum;
    }
    return sumCols(m, row+1, col, currSum);
}


int sumDiag(Matrix m, int row, int col, int currSum){
    currSum = currSum + m[row][col];
    if (row +1 >= N && col +1 >= N){
        return currSum;
    }
    return sumDiag(m, row+1, col+1, currSum);
}

void checkMatrix(Matrix matrix, int results[]){
    int a = 0;
    int rows;
    int cols;
    int resCounter = 0;
    for (rows = N-1; rows >= 0; rows--){
        a = sumRows(matrix, rows, 0, 0);
        printf("ROWS rescOUNTER: %d, A: %d\n", resCounter, a);
        results[resCounter] = a;
        resCounter++;
    }
    for (cols = N-1; cols >= 0; cols--){
        a = sumCols(matrix, 0, cols, 0);
        printf("COLS rescOUNTER: %d, A: %d\n", resCounter, a);
        results[resCounter] = a;
        resCounter++;
    }
    results[resCounter] = sumDiag(matrix, 0, 0, 0);
    printf("diag rescOUNTER: %d\n", results[resCounter]);
}

int assertResults(int results[]){
    int i;
    for (i = 0; i < N*2; i++){
        if (results[i] != results[i+1]){
            return 1;
        }
    }
    return 0;
}