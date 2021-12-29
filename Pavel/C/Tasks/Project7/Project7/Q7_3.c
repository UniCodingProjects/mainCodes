#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define SIZE 6

int halfReverseHalfDifferent(char arr1[], char arr2[]);
void confusedArray(char grid[][SIZE]);

void main() {
    char grid[SIZE][SIZE];
    printf("Enter 36 letters (a-z or A-Z):\n");
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            scanf(" %c", &grid[i][j]);
            if (!((grid[i][j] >= 'a' && grid[i][j] <= 'z') || (grid[i][j] >= 'A' && grid[i][j] <= 'Z'))) {
                printf("Incorrect character, Enter a letter: ");
                j--;
            }
        }
    }
    confusedArray(grid);
}

void confusedArray(char grid[][SIZE]) {
    int i, j, row, col, match = 0;
    char arr1[SIZE], arr2[SIZE]; 
    for (i = 0; i < SIZE / 2; i++) {   
        for (j = 0; j < SIZE; j++) {
            arr1[j] = grid[i][j];
            arr2[j] = grid[SIZE - 1 - i][j];
        }
        match = halfReverseHalfDifferent(arr1, arr2);
        if (!match)
            break;
    }
    if (match == 1)
        printf("The array of letters is confused");
    else
        printf("The array of letters is not confused");
}

int halfReverseHalfDifferent(char arr1[], char arr2[]) {
    int i, j;
    for (j = 0; j < SIZE / 2; j++) { // check if half reversed
        if (arr1[SIZE - 1 - j] != arr2[j])
            return 0;
    }
    for (i = 0; i < SIZE / 2; i++) { // check if half different
        for (j = SIZE / 2; j < SIZE; j++)
            if (arr1[i] == arr2[j])
                return 0;
    }
    return 1;
}