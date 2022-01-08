mycomp: complex.o mycomp.o complex_input.o
	gcc -g -Wall -ansi -pedantic complex.o mycomp.o complex_input.o -o mycomp -lm
complex.o: complex.c complex.h
	gcc -c -Wall -ansi -pedantic complex.c -o complex.o -lm 
mycomp.o: mycomp.c complex.h
	gcc -c -Wall -ansi -pedantic mycomp.c -o mycomp.o
complex_input.o: complex_input.c complex.h
	gcc -c -Wall -ansi -pedantic complex_input.c -o complex_input.o
clean: rm *~