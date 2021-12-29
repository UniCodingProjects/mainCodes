#include <stdio.h> 
int main()
{
	for (int i = 0, j = 0, k = 0; i < 4; i++, j += 2, k += 3)
	{
		printf("%d %d %d\n", i, j, k);
	}
	return 0;
}