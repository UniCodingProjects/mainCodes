#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define SIZE 50

void swapPairChs(char* str);

void main() {
	char str[SIZE];
	char* ptstr = &str;
	printf("Please enter a text: ");
	scanf("%s", str);
	swapPairChs(ptstr);
	puts(str);
}

void swapPairChs(char* str) {
	char* pointStr;
	char tmp;
	for (pointStr = str; pointStr < str + strlen(str); pointStr+=2) {
		if (*pointStr == '\0') {
			break;
		}
		else if (*(pointStr+1) == '\0') {
			*pointStr == '\0';
		}
		tmp = *pointStr;
		*pointStr = *(pointStr+1);
		*(pointStr +1) = tmp;
	}
}