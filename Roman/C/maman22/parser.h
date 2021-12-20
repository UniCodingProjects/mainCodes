#define CMD_LENGTH 14 /* max command name length */

/* array to hold the commands names */
char * commands[9];

/* check if any extra text left after parsing whole given line */
int checkForExtraText(char * cmd, int j, int cmdLen);

/* trigger error on error event */
void errorHandle(int errorNum);

/* get 1 number from command line */
double getSoleNum(char * cmd, int * j, int cmdLen);

/* reset vars and arrays used for command line parsing if there are more lines to check from input */
char * resetForNextLine(size_t *size, int *cmdLen, int *cmdBegin, int *cmdNum,
        int *foundCmd, char * cmd, char * command, int *j);

/* gather from stdin input until line is over */
char * contReadLine(int * cmdBegin, int * cmdLen, size_t * size, char * cmd, int * canRun, char curr);

/* check if command name that was received is proper */
int checkCMD(char * cmds[], char * command);

/* check if complex var name is proper A-F */
int isProperVar(char curr);

/* gather both nums for complex input */
int getBothNums(char * cmd,  Complex * array, char var, int * j, int cmdLen);

/* get which complex struct to use per received var name */
int varToComplexInArr(char var);

/* get the proper complex var to be used */
char getComplexVarName(int * j, int cmdLen, char * cmd);

/* parse read_comp command */
void parseCmdReadComp(int * j, int cmdLen, char * cmd, Complex * array);

/* run the desired command with the appropriate arguments received */
void runCMD(int num, Complex num1, Complex num2, double real, double imag);

/* after parsing the command name properly, parse rest of the received command */
void argsParser(int cmdNum, int * j, int cmdLen, char * cmd, Complex * array);

/* main parser function */
void callParser(Complex * array);

/* check if there are too many commas in command line */
int checkForExtraCommas(char * cmd,  int cmdLen, int maxAllowed, char c);

/* check if received NAN values in place of numbers */
int checkForNAN(char * cmd, int j, int cmdLen);