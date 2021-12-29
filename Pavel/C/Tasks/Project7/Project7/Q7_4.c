#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define ROWS 5
void printArray(int arr[][5], int rows);
void main()
{
	int arr[ROWS][ROWS] = { 0 };
	printArray(arr[1][5], ROWS);
}
void printArray(int arr[][5], int rows)
{
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			printf("%3d", arr[i][j]);
		}
		printf("\n");
	}
}
