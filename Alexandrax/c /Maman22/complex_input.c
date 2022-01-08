#include "complex.h"

/**
 * the function get a string and return in a 2D array of strings
 * which contains the command and the rest of the line that the user entered .
 * */
char **return_command(char line[])
{
    char **temp = (char **)malloc(2 * sizeof(char *));
    char skip[2] = " ";/*The character that separates the command from the rest of the line*/
    char *command;
    char *rest;
    /*char * copy =(char *)malloc(strlen(command)*sizeof(char *));*/

    command = strtok(line, skip);/* separate the command from the rest of the line*/
    rest = strtok(NULL,"");/* gte the rest*/

    /*if there is only one part in the line*/
    if (rest == NULL && strlen(command) > 0)
        command[strlen(command) - 1] = '\0';

    temp[0] = command;
    temp[1] = rest;

    return temp;
}

/* the function check if there isnt more tabs in the line from the user */
int check_rest(char parameters[], int lastIndex)
{
    /* while there is actuccly a line and we didnt went to the end of the line */
    while (parameters != NULL && parameters[lastIndex] != '\0')
    {
        /* if there is a tab that is not a */
        if (parameters[lastIndex] != '\n' && isspace(parameters[lastIndex]) == 0 && parameters[lastIndex] != '\0')
        {
            printf("Extraneous text after end of command\n ");
            return ERROR;
        }
        else
            lastIndex++;
    }
    return 1;
}

/*
* The function return the index where there is the nearest comma starting from the index that sent to the function,
* if there is a tab that is not white an error will show and the function return ERROR
* The function get an array of char and an int.
*/
int is_comma(char parameters[], int lastIndex)
{
    if(parameters==NULL)
        printf("Missing comma\n");
    while (parameters != NULL && lastIndex <= strlen(parameters) && parameters[lastIndex] != '\0')
    {
        /* if its like : add_comp A*/
        if (parameters[lastIndex] == '\n' || parameters[lastIndex] == '\0')
        {
            printf("Missing comma\n");
            return ERROR;
        }
        /* if its a white tab but not an enter (we checked in the first if)*/
        else if(isspace(parameters[lastIndex]) == 1)
        {
            lastIndex++;
            continue;
        }
        /* if the tab is a comma*/
        else if (parameters[lastIndex] == ',')
            return lastIndex;

        else if (parameters[lastIndex] == EOF)
        {
            printf("Improper stopping of the program\n");
            exit(1); /* exit the program*/
        }
        /* if its not a a white tab or a cooma or the and of the string */
        else
        {
            if (isspace(parameters[lastIndex]) == 0)
            {
                printf("Invalid char\n");
                return ERROR;
            }
        }
        lastIndex++;
    }
    /* if we went out of the while and we get to the end of the string*/
    if (parameters[lastIndex] == '\0')
    {
        printf("Missing comma\n");
        return ERROR;
    }
    return ERROR;
}

/**
* Returns the index in which the string number appears,if no number appears it will print the appropriate error
* the int before is to know if there was a comma before and print the appropriate error.
**/
int is_number(char parameters[], int lastIndex, int before)
{
    float parameter;
    char *rest;

    if (parameters == NULL){
        printf("Missing number\n");
        return ERROR;
    }
    /* */
    parameter = strtod(parameters + lastIndex, &rest);

    /* if there is a number*/
    if (parameter != 0)
        return lastIndex;

    /* if we did not found a number */
    else
    {
        /*if the string from atstod and the original string are not the same thats mean there was an actuclly number(0.0)*/
        while (lastIndex<strlen(parameters) && parameters[lastIndex] != '\0' && parameters!=NULL)
        {
            /* if the number is 0 and actually legal*/
            if (parameters[lastIndex] == '0')
                return lastIndex;

            /*if there is a comma*/
            else if (parameters[lastIndex] == ',')
            {
                /* if there was a comma before this comma*/
                if (before == 1)
                    printf("Multiple consecutive commas\n");
                else
                    printf("ERROR :Comma not needed or missing virabl\n");
                return ERROR;
            }

            /* if the line end before we meet an number*/
            else if (parameters[lastIndex] == '\n')
            {
                printf("Missing parameter\n");
                return ERROR;
            }
            /*if tis a white tab but not an enter*/
            else if (isspace(parameters[lastIndex]) == 1)
            {
                lastIndex++;
                continue;
            }

            else if (parameters[lastIndex] == EOF)
            {
                printf("Improper stopping of the program\n");
                exit(1);
            }
            else
            {
                if(isspace(parameters[lastIndex])==0)
                {
                    printf("Invalid parameter – not a number\n");
                    return ERROR;
                }
                else lastIndex++;
            }
        }
    }
    return ERROR;
}

int is_comp(char parameters[], int lastIndex, int before)
{
    if (parameters == NULL){
        printf("Missing parameter\n");
        return ERROR;
    }
    while (parameters != NULL && parameters[lastIndex] != '\0' && lastIndex <= strlen(parameters))
    {
        switch (parameters[lastIndex])
        {
            case '\n':
                case '\0':

                    printf("Missing parameter\n");
                    return ERROR;

                    case ',':

                        if (before == 1)
                            printf("Multiple consecutive commas\n");
                        else
                            printf("ERROR :Comma not needed\n");
                        return ERROR;

                        case EOF:

                            printf("Improper stopping of the program\n");
                            exit(1);

                            default:

                                if (parameters[lastIndex] >= 65 && parameters[lastIndex] <= 70) /* if the char resembale a complex*/
                                    return lastIndex;
                                    if (isspace(parameters[lastIndex]) == 0)
                                    {
                                        printf("Undefined complex variable\n");
                                        return ERROR;
                                    }
                                    else
                                        lastIndex++; /* if the char is white but not a '\n' */
                                        break;
        }
    }
    if (parameters[lastIndex] == '\0' || lastIndex > Max_line)
    {
        printf("Missing parameter\n");
        return ERROR;
    }
    return ERROR;
}
