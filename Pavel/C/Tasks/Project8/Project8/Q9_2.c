#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define SIZE 50
#define SIZEWORD 10

void hidingWord(char* sent, char* word);

void main() {
	char word[SIZEWORD], sent[SIZE];
	printf("Please enter a sentence: ");
	gets(sent);
	printf("Please enter a word: ");
	gets(word);
	hidingWord(sent, word);
	printf("The new sentence is ");
	puts(sent);
}

void hidingWord(char* sent, char* word) {
	char* pointWord = word;
	char* pointSent;
	int flag;
	for (pointSent = sent; pointSent < sent + strlen(sent); pointSent++) {
		if (*pointSent == *pointWord) {
			flag=1;
			for (int i = 1; i < strlen(word); i++) {
				if (*(pointSent + i) == *(pointWord + i) && *(pointSent + strlen(word)) == ' ' || *(pointSent + strlen(word)) == '\n') flag++;
				else break;
			}
			if (flag == strlen(word)) {
				do
				{
					*(pointSent + flag-1) = '*';
					flag--;
				} while (flag);
			}
		}
	}
}