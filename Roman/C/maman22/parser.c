#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include "complex.h"
#include "parser.h"

char * commands[9][14] = {"read_comp", "print_comp", "add_comp", "sub_comp", "mult_comp_real",
                        "mult_comp_img", "mult_comp_comp", "abs_comp", "stop"};

void callParser(Complex * array){
    char curr;
    size_t size = 1;
    int cmdLen = 0;
    int i = 0;
    int j = -1;
    int foundCmd = 0;
    int canRun = 0;
    int cmdNum = -1;
    int cmdBegin = 0;
    char *cmd = malloc(size* sizeof(char));
    char command[CMD_LENGTH];

    while ((curr = getchar()) != EOF){
        if (cmdBegin == 0 && curr == ' ') continue;

        if (curr != '\n') {
            cmd = contReadLine(&cmdBegin, &cmdLen, &size, cmd, &canRun, curr);
            continue;
        }
        else {
            cmd[cmdLen] = '\0'; /* set end of cmd in chararray*/
            printf("Received command: %s\n", cmd);
            /* command fully caught - print and parse ->  */
        }
        for (i = 0; i <= cmdLen; i++) {
            if (i > CMD_LENGTH) {
                break;
            }
            if (isspace(cmd[i]) || cmd[i] == '\0') { /* found command name, let's parse it*/
                foundCmd = 1;
                cmdNum = checkCMD(commands, command);
                if (j == -1) j = i;
            }
            if (foundCmd == 0 ) { /* keep looking for cmd name*/
                command[i] = cmd[i];
            }
        }
        if (cmdNum != -1) { /* if parsed proper command let's parse rest of the input args*/
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'm') != -1) {
                argsParser(cmdNum, &j, cmdLen, cmd, array);
            }
        }
        else { /* invalid command error */
            if (i != 0) errorHandle(3);
        }
        cmd = resetForNextLine(&size, &cmdLen, &cmdBegin, &cmdNum, &foundCmd, cmd, command, &j); /* reset cmd with malloc - to begin parsing next line */
    }
}

void argsParser(int cmdNum, int * j, int cmdLen, char * cmd, Complex * array){
    printf("parsing: %s, cmd#: %d\n", cmd, cmdNum);
    char var1;
    char var2;
    double num1;
    switch (cmdNum){
        case 0:
            parseCmdReadComp(j, cmdLen, cmd, array);
            break;
        case 1:
            var1 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(1, array[varToComplexInArr(var1)], array[1], 0, 0);
            break;
        case 2:
            var1 = getComplexVarName(j, cmdLen, cmd);
            *j = *j + 1;
            var2 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z' || var2 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(2, array[varToComplexInArr(var1)], array[varToComplexInArr(var2)], 0 ,0);
            break;
        case 3:
            var1 = getComplexVarName(j, cmdLen, cmd);
            *j = *j + 1;
            var2 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z' || var2 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(3, array[varToComplexInArr(var1)], array[varToComplexInArr(var2)], 0 ,0);
            break;
        case 4:
            var1 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z') break;
            num1 = getSoleNum(cmd, j, cmdLen);
            if (num1 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(4, array[varToComplexInArr(var1)], array[1], num1, 0);
            break;
        case 5:
            var1 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z') break;
            num1 = getSoleNum(cmd, j, cmdLen);
            if (num1 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(5, array[varToComplexInArr(var1)], array[1], 0, num1);
            break;
        case 6:
            var1 = getComplexVarName(j, cmdLen, cmd);
            *j = *j + 1;
            var2 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z' || var2 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(6, array[varToComplexInArr(var1)], array[varToComplexInArr(var2)], 0 ,0);
            break;
        case 7:
            var1 = getComplexVarName(j, cmdLen, cmd);
            if (var1 == 'z') break;
            if (checkForExtraCommas(cmd, cmdLen, cmdNum, 'l') == -1) break;
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(7, array[varToComplexInArr(var1)], array[1], 0, 0);
            break;
        case 8:
            /* check if cmd is longer and has more stuff if got stop if so then its not stop but externous text error*/
            if (checkForExtraText(cmd, *j, cmdLen) == -1) errorHandle(6);
            else runCMD(8, array[0], array[0], 0, 0);
            break;
    }
}

char * resetForNextLine(size_t *size, int *cmdLen, int *cmdBegin, int *cmdNum,
        int *foundCmd, char * cmd, char * command, int * j){
    memset(command, 0, CMD_LENGTH);
    *j = -1;
    free(cmd);
    *size = 1;
    *cmdLen = 0;
    *cmdBegin = 0;
    *foundCmd = 0;
    cmd = malloc(*size * sizeof(char));
    *cmdNum = -1;
    return cmd;
}

char * contReadLine(int * cmdBegin, int * cmdLen, size_t * size, char * cmd, int * canRun, char curr){
    *cmdBegin = 1;
    cmd[*cmdLen] = curr;
    *cmdLen += 1;
    *size += 1;
    *canRun = 0;
    cmd = realloc(cmd, *size * sizeof(char));
    return cmd;
}

int isProperVar(char curr){
    if (((int)curr) > ((int)'F') || ((int)curr) < ((int)'A')){
        return 0;
    }
    return 1;
}

int getBothNums(char * cmd,  Complex * array, char var, int * j, int cmdLen) {
    double setNum1 = 0;
    double setNum2 = 0;

    setNum1 = getSoleNum(cmd, j, cmdLen);
    setNum2 = getSoleNum(cmd, j, cmdLen);
    if (setNum1 == 'z' || setNum2 == 'z') {
        return -1;
    }
    if (checkForExtraText(cmd, *j, cmdLen) == -1) {
        errorHandle(6);
        return -2;
    }
    else {
        switch (var) {
            case 'A':
                array[0] = readComp(setNum1, setNum2);
                break;
            case 'B':
                array[1] = readComp(setNum1, setNum2);
                break;
            case 'C':
                array[2] = readComp(setNum1, setNum2);
                break;
            case 'D':
                array[3] = readComp(setNum1, setNum2);
                break;
            case 'E':
                array[4] = readComp(setNum1, setNum2);
                break;
            case 'F':
                array[5] = readComp(setNum1, setNum2);
                break;
        }
    }
    return 1;
}

double getSoleNum(char * cmd, int * j, int cmdLen){
    int idx = 0;
    char *end;
    char *number1[80];
    int found = 0;
    if (isProperVar(cmd[*j]) == 1){
        *j=*j+1;
    }
    for (;*j<cmdLen-1;*j=*j+1) {
        if (cmd[*j] == ' ') continue;
        if (cmd[*j] == ',') {
            *j=*j+1;
            break;
        }
        else {
            *j=*j-1;
            break;
        }
    }
    for (;*j<cmdLen;*j=*j+1) {
        if (cmd[*j] == '-' && idx == 0){
            number1[idx] = &cmd[*j];
            found = 1;
            if (idx + 1 >= 80) break;
            idx++;
            continue;
        }
        if (isdigit(cmd[*j]) || cmd[*j] == '.') {
            number1[idx] = &cmd[*j];
            found = 1;
            if (idx + 1 >= 80) break;
            idx++;
        }
        if (cmd[*j] == ' ' && found == 1) break;
    }
    if (idx != 0 && (idx + 1 < 80)) {
        *j=*j+1;
        return strtod(*number1, &end);
    }
    else{
        return 'z';
    }
}

int varToComplexInArr(char var){
    switch (var){
        case 'A':
            return 0;
        case 'B':
            return 1;
        case 'C':
            return 2;
        case 'D':
            return 3;
        case 'E':
            return 4;
        case 'F':
            return 5;
    }
    return -1;
}

char getComplexVarName(int * j, int cmdLen, char * cmd){
    for (;*j<cmdLen;*j=*j+1){
        if (isspace(cmd[*j]) || cmd[*j] == ',') continue;
        if (cmd[*j] == '\0') errorHandle(5);
        if (isProperVar(cmd[*j]) == 1) return cmd[*j];
        else if (cmd[*j] != '\0'){
            errorHandle(2);
            return 'z';
        }
    }
    errorHandle(5);
    return 'z';
}

void parseCmdReadComp(int * j, int cmdLen, char * cmd, Complex * array){
    char var;
    int res1;
    int res2;
    /*get var name */
    var = getComplexVarName(j, cmdLen, cmd);
    if (var == 'z') return;
    res1 = checkForNAN(cmd, *j, cmdLen);
    /*get numbers*/
    res2 = getBothNums(cmd, array, var, j, cmdLen);
    if (res2 != -2 && res2 != -1 && res1 == -1){
        errorHandle(7);
    }
    if (res2 == -1) errorHandle(5);
    if (res1 == -1 || res2 == -1 || res2 == -2) return;
}

int checkForExtraText(char * cmd, int j, int cmdLen){
    j++;
    for (;cmdLen > j; cmdLen--){
        if (!isspace(cmd[cmdLen])) return -1;
    }
    return 1;
}

int checkForExtraCommas(char * cmd, int cmdLen, int cmdNum, char c){
    int maxAllowed = 0;
    int j = 0;
    switch (cmdNum){
        case 0:
            maxAllowed = 2;
            break;
        case 1:
            maxAllowed = 0;
            break;
        case 2:
            maxAllowed = 1;
            break;
        case 3:
            maxAllowed = 1;
            break;
        case 4:
            maxAllowed = 1;
            break;
        case 5:
            maxAllowed = 1;
            break;
        case 6:
            maxAllowed = 1;
            break;
        case 7:
            maxAllowed = 0;
            break;
        case 8:
            maxAllowed = 0;
            break;
    }
    int commaCount = 0;
    for (;j < cmdLen; j++){
        if (cmd[j] == ',') commaCount++;
    }
    switch (c) {
        case 'm':
            if (commaCount > maxAllowed) {
                errorHandle(8);
                return -1;
            }
            break;
        case 'l':
            if ((commaCount < maxAllowed)){
                errorHandle(9);
                return -1;
            }
            break;
    }
    return 1;
}

int checkForNAN(char * cmd, int j, int cmdLen){
    j++;
    for (;j < cmdLen; j++) {
        if (!isdigit(cmd[j]) && cmd[j] != '.' && cmd[j] != ',' && !isspace(cmd[j]) && cmd[j] != '-') {
            return -1;
        }
    }
    return 1;
}

void runCMD(int num, Complex num1, Complex num2, double real, double imag){
    switch (num){
        case 1:
            printComp(num1, 'c');
            break;
        case 2:
            addComp(num1, num2);
            break;
        case 3:
            subComp(num1, num2);
            break;
        case 4:
            multiplyCompReal(num1, real);
            break;
        case 5:
            multiplyCompImag(num1, imag);
            break;
        case 6:
            multiplyCompComp(num1, num2);
            break;
        case 7:
            absComp(num1);
            break;
        case 8:
            printf("Received stop command - thanks for using complex calculator\n"
                   "exiting...");
            exit(0);
    }
}

int checkCMD(char * cmds[9][14], char * command){
    int i;
    for (i = 0; i < 9; i++){
        if (strstr(command, cmds[0][i])){
            return i;
        }
    }
    return -1;
}

void errorHandle(int errorNum){
    switch (errorNum){
        case 2:
            printf("Undefined complex variable\n");
            break;
        case 3:
            printf("Undefined command name\n");
            break;
        case 4:
            printf("Illegal comma\n");
            break;
        case 5:
            printf("Missing parameter\n");
            break;
        case 6:
            printf("Extraneous text after end of command\n");
            break;
        case 7:
            printf("Invalid parameter – not a number\n");
            break;
        case 8:
            printf("Multiple consecutive commas\n");
            break;
        case 9:
            printf("Missing comma\n");
            break;
    }
}