#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	char par=' ';
	int countOpen=0, countClosed=0;

	printf("Please enter nested parentheses\n");
	do
	{
		scanf("%c", &par);

		if (par == '(') {
			countOpen++;
		}
		else if (par == ')') {
			countClosed++;
			if (countClosed > countOpen) break;
		}
		else if (par != '(' && par != ')' && par != '\n') break;
		else continue;
	} while (par != '\n');

	if (countOpen != countClosed || par != '(' && par != ')' && par != '\n') printf("Illegal\n");
	else if (countOpen == countClosed ) printf("Legal\n");
}