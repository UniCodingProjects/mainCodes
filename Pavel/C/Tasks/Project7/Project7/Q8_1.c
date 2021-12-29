#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define SIZE 10

void main() {
	char str[SIZE], str2[SIZE];
	printf("Please enter a string:\n");
	scanf(" %s", str);
	printf("Please enter another string\n");
	scanf(" %s", str2);

	if(stringsTheSame(str,str2) != 0) printf("The value of %s and %s is equal\n", str, str2);
	else printf("The value of %s and %s is not equal\n", str, str2);
}

int stringsTheSame(char str[], char str2[]) {
	for (int i = 0; i < strlen(str); i++) {
		if (str[i] == str2[i] || str[i] == str2[i]+32 || str[i] == str2[i]-32 ) continue;
		else return 0;
	}
	return 1;
}