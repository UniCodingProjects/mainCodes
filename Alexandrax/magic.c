#include "magic.h"

int main(){
    int **magicSquare ;
    int i;
    int numbers[maximumRange];

    magicSquare=(int *)malloc(N*sizeof(int)) ;
    for(i=0; i<N ;i++)
        magicSquare[i]= (int*)malloc(N*sizeof(int)) ;

    if(input(magicSquare)==0){
        printSquare(magicSquare);
        /* if the input is good and give a basic magic square */
        if(checkValue(magicSquare)==0 && checkingSquare(magicSquare)==0 )
            printf("\n The values you entered give a basic magic square \n");
        else printf("The values you entered dont give a basic magic square");
    }
    int a;
    for(a=0; a<N; a++)
        free(magicSquare[a]);

    free(magicSquare);
    return 0;
}
/*
the function prints the square
*/
int printSquare(int *magicSquare[])
{
    printf("\n");
    int i;
    int j;
    /* print every number in the square */
    for (i=0 ; i<N;i++){
        for(j=0 ; j<N;j++){
            printf(" %d",magicSquare[i][j]);
        }
        printf("\n");
    }
    return 0;
}
/*
 the function checks if there are two equal numbers or more in the square
 or if there is a number that goes beyond the limits
 */
int checkValue(int *magicSquare[]){
    int i;
    int j;

    /* In this array we mark 1 in the index of the number we met, if there was already 1,
    a sign that the number repeats itself, if there was not 1 and the number is correct then we will continue in a loop*/
    int help[maximumRange];

    /* initializes the array to zeros*/
    for(i=0;i<maximumRange;i++)
        help[i]=0;

    for(i=0;i<N;i++){
        for(j=0; j<N ; j++){
            int number= magicSquare[i][j];
            /* if the number is not in the range */
            if(number <minimalRange || number>maximumRange)
                return 1;
            else {
                /* if number was in magicSquare */
                if(help[number]==number)
                    return 1;
                else help[number]=number;
            }
        }
    }
    return 0;
}

//The function checks if the sum of the columns and diagonals is equal/
int checkingSquare(int *magicSquare[]){
    int count=0;
    int count2=0;
    int i=0;
    int j=0;


    while(i< N){
        count += magicSquare[0][i];
        i++;
    }

    /* checking the lines */
    for(i=0; i<N ; i++){
        count2=0;
        for(j=0; j<N; j++){
            count2+= magicSquare[i][j];
        }
        if(count2!= count){
            return 1;
        }
    }

    /* checking the rows */
    for(j=0; j<N ; j++){
        count2=0;
        for(i=0; i<N; i++){
            count2+= magicSquare[i][j];
        }
        if(count2 != count){
            return 1;
        }
    }

    //checks first diagonally from left to right//
    count2=0;
    for(i=0,j=0;j<N && i<N;i++,j++)
        count2+= magicSquare[i][j];
    if(count2!= count){
        return 1;
    }

    /*check second diagonally from right to left */
    count2=0;
    for(i=N-1,j=N-1; i>=0 && j>=0 ;i--,j--)
        count2 += magicSquare[i][j];
    if(count2!=count){
        return 1;
    }

    /*if the square is actually a magic square and we didnt return 1 */
    return 0;
}

/*Receives numbers from the user and checks if enough numbers have been entered
and if they are indeed numbers not letters or other signs*/
int input(int *magicSquare[])
{
    int i=0;
    int j=0;
    int  input;
    int error=1;
    printf("Please enter numbers to represent the %d by %d size magic square\n",N, N);
    /* As long as the input does not end and the place in the magic square does not end*/
    while(error!=0 && error!= EOF )
    {
        error=scanf("%d",&input);
        if(error== EOF){
            break;
        }
        /* if the input is not an int or a white tab */
        if(error==0){
            printf("you insert a character that cannot be received");
            return 1;
        }
        /* if there is to much numbers */
        if(i>N-1|| j> N-1){
            printf("\nyour input goes beyond the limits of the square");
            return 1;
        }

        magicSquare[j][i]=input;

        /* if its the end of the line*/
        if(i==(N-1) && j!=(N-1)){
            i=0;
            j++;
            continue;
        }
        i++;
    }
    /* if there isnt enough numbers */
    if((i<(N) && j<(N))|| i<N){
        printf("\nyou didnt entered enough numbers to the square");
        return 1;
    }
    /* if the input from the user is good */
    return 0;
}

