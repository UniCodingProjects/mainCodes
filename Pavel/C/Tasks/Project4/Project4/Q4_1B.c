#include <stdio.h>

int main()
{
	int x = 0;
	for (int i = 0; i < x + 1; i++) {
		++x;
		printf("i=%d, x=%d\n", i, x);
		if (x < 5)
			continue;
		else
			break;
	}
}