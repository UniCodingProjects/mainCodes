flags = -Wall -pedantic -ansi
tar = complex.c complex.h parser.c parser.h mycomp.c 

mycomp: ${tar}
	gcc ${flags} -o mycomp complex.c parser.c mycomp.c -lm
