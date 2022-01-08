/**
 * The program reads commands from the standard input, decodes and performs them.
 *  The commands deal with arithmetic operations on complex numbers.
 *  In this program, the input line is assumed to be less than 100.
 *  If the program reads an incorrect input line it will print the appropriate error
 **/
#include "complex.h"

int main()
{
    char *command=(char *)malloc(sizeof(char));//TODO need to check malloc;
    char parameters[Max_line];/* the line from the user */
    char ** input; /* for the return value from the function "return_command"*/

    complex *comp[Num_Of_Comp];
    complex *A = complex_constructor();
    complex *B = complex_constructor();
    complex *C = complex_constructor();
    complex *D = complex_constructor();
    complex *E = complex_constructor();
    complex *F = complex_constructor();
    comp[0]=A;
    comp[1]=B;
    comp[2]=C;
    comp[3]=D;
    comp[4]=E;
    comp[5]=F;
    input=(char **)malloc(2*sizeof(char *));
    input[0]=(char*)malloc(Max_command*sizeof(char));
    input[1]=(char*)malloc(Max_line*sizeof(char));

    /* a massege for the user to start write commands*/
    printf("Write your command :\n->");

    /* get a line from the standart input antil eof or the command stop*/
    while(fgets(parameters, Max_line, stdin)!=NULL)
    {
        printf("Your input is : %s\n",parameters);/* the line that the user entered*/
        input = return_command(parameters);/*the sparaite line */
        command=input[0];/*the command line*/
        run_function(input[1],command,comp);
        parameters[0]='\0';
        printf("\n->");
    }
    printf("Please enter 'stop' if you want to exit the program\n");

    free(A);
    free(B);
    free(C);
    free(D);
    free(E);
    free(F);
    free(input[1]);
    free(input);
    return 0;
}
/*
* Gets a string, an index in an array of complexes.
* and returns the appropriate complex according to what is in the submitted index
*/
complex* return_comp(char parameters[Max_line],complex *comp[6],int lastIndex)
{
    switch(parameters[lastIndex])
    {
        case 'A':
            return comp[0];
        case 'B':
            return comp[1];
        case 'C':
            return comp[2];
        case 'D':
            return comp[3];
        case 'E':
            return comp[4];
        default:
            return comp[5];
    }
}

/* run the correct function according to the command */
void run_function(char parameters[Max_line], char *command, complex *comp[6])
{
    int var1 =0, var2=0, var3=0,check=0;
    int comma1=0, comma2=0;
    float x,y;
    char *temp;
    complex * to_print;

    if(strlen(command)==0)
        return;/*empty line*/

        /*if the command is read_comp */
        if(strcmp(command,"read_comp")==0)
        {
            var1=is_comp(parameters,0,0);/* the index where there is a complex in the string*/
            if(var1!=ERROR)
            {
                comma1=is_comma(parameters,(var1+1));/* the index where there is a comma in the string*/
                if(comma1!=ERROR)
                {
                    var2=is_number(parameters,(comma1+1),1);/* the index where there is a number in the string*/
                    if(var2!=ERROR)
                    {
                        x=strtod(parameters+comma1+1,&temp);/* the number that show after the comma*/
                        comma2=is_comma(temp,0);/* the index where there is a comma in the string checking in temp*/
                        if(comma2!=ERROR)
                        {
                            var3=is_number(temp,(comma2+1),1);/* the index where there is a number in the string*/
                            if(var3!=ERROR)
                            {
                                y=strtod(temp+comma2+1,&temp);/* the number that show after the second comma*/
                                check=check_rest(temp,0);/* check if there are nothing after the command*/
                                if(check!=ERROR)
                                {
                                    to_print=read_comp(return_comp(parameters,comp,var1),x,y);
                                    print_comp(to_print);/* print the result*/
                                }
                            }
                        }
                    }
                }
            }
        }
        /* if the command is print_comp*/
        else if(strcmp(command,"print_comp")==0)
        {
            var1=is_comp(parameters,0,0);/* the index where there is a complex in the string*/
            if(var1!=ERROR)
            {
                check=check_rest(parameters,var1+1);/* check if there are nothing after the command*/
                if(check!=ERROR)
                {
                    to_print=return_comp(parameters,comp,var1);
                    print_comp(to_print);/* run the function print_comp*/
                }
            }
        }
        /* if the command is add_comp , sub_comp or mult_comp_comp*/
        else if(strcmp(command, "add_comp")==0 || strcmp(command,"sub_comp")==0||strcmp(command, "mult_comp_comp")==0)
        {
            var1=is_comp(parameters,0,0);/* the index where there is a complex in the string*/
            if(var1!=ERROR)
            {
                comma1=is_comma(parameters,var1+1);/* the index where there is a comma in the string*/
                if(comma1!=ERROR)
                {
                    var2=is_comp(parameters,comma1+1,1);/* the index where there is a complex in the string*/
                    if(var2!=ERROR)
                    {
                        check=check_rest(parameters,var2+1);/* check if there are nothing after the command*/
                        if(check!=ERROR)
                        {
                            /* if the command is add_comp*/
                            if(strcmp(command,"add_comp")==0)
                                to_print = add_comp(return_comp(parameters,comp,var1),return_comp(parameters,comp,var2));

                            /* if the command is mult_comp_comp */
                            else if(strcmp(command,"mult_comp_comp")==0)
                                to_print = mult_comp_comp(return_comp(parameters,comp,var1),return_comp(parameters,comp,var2));

                            else to_print = sub_comp(return_comp(parameters,comp,var1),return_comp(parameters,comp,var2));

                            print_comp(to_print);/*print the result*/
                        }
                    }
                }
            }
        }
        /*if the command is mult_comp or mult_comp_img*/
        else if(strcmp(command, "mult_comp_real")==0||strcmp( command,"mult_comp_img")==0)
        {
            var1=is_comp(parameters,0,0);/* the index where there is a complex in the string*/
            if(var1!=ERROR)
            {
                comma1=is_comma(parameters,var1+1);/* the index where there is a comma */
                if(comma1!=ERROR)
                {
                    var2=is_number(parameters,comma1+1,1);/* the index where there is a number in the string*/
                    if(var2!=ERROR)
                    {
                        y=strtod(parameters+(comma1+1),&temp);/* the number that show after the comma*/
                        check=check_rest(temp,0);/* check if there are nothing after the command*/
                        if(check!=ERROR)
                        {
                            /* if the command is mult_comp_img*/
                            if(strcmp(command,"mult_comp_img")==0)
                                to_print=mult_comp_img(return_comp(parameters,comp,var1),y);

                            else to_print=mult_comp_real(return_comp(parameters,comp,var1),y);

                            print_comp(to_print);/* print the result*/
                        }
                    }
                }
            }
        }
        /* if the command is abs_comp */
        else if(strcmp(command,"abs_comp")==0)
        {
            var1=is_comp(parameters,0,0);/* the index where there is an complex in the string*/
            check=check_rest(parameters,var1+1);/* check if there are nothing after the command*/
            if(var1!=ERROR && check!=ERROR)
            {
                x=abs_comp(return_comp(parameters,comp,var1));/*run the function*/
                printf("%.2f + (0.00)i\n", x);/* print the result*/
            }
        }
        /* if the command is stop*/
        else if(strcmp(command,"stop")==0)
        {
            check=check_rest(parameters,0);
            if(check!=ERROR)
                exit(0);/* exit the program*/
                else printf("Extraneous text after end of command\n");
        }

        else if(isspace(command[0])==0)
            printf("Undefined command name\n");

        temp='\0';

}
