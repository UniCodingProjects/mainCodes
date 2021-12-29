#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define ROWS 3
#define COLS 4

void weightedAverage(float sets[ROWS][COLS], float weight[COLS], float res[ROWS]);

void main() {
	float sets[ROWS][COLS], res[ROWS], weight[COLS];
	printf("Please enter 12 decimal numbers:\n");
	for (int i = 0; i < ROWS; i++) {
		for (int j = 0; j < COLS; j++) {
			scanf("%f", &sets[i][j]);
		}
	}
	printf("Please enter 4 weights:\n");
	for (int k = 0; k < COLS; k++) {
		scanf("%f", &weight[k]);
	}
	printf("The weighted averages are:\n");
	weightedAverage(sets, weight, res);
	for (int l = 0; l < ROWS; l++) {
		printf("For the set of values at position %d: %f\n", l, res[l]);
	}
}

void weightedAverage(float sets[ROWS][COLS], float weight[COLS], float res[ROWS]) {
	float total;
	for (int i = 0; i < ROWS; i++) {
		res[i] = 0;
		total = 0;
		for (int j = 0; j < COLS; j++) {
			res[i] += (sets[i][j] * weight[j]);
			total += weight[j];
		}
		res[i] = res[i] / total;
	}
}