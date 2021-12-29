#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	char firstLetter, secondLetter;
	printf("Enter two small letters:\n");
	scanf("%c %c", &firstLetter ,&secondLetter);
	printf("The letters are %c, %c, their gimatria value is %d", firstLetter, secondLetter, firstLetter-96+secondLetter-96);

}