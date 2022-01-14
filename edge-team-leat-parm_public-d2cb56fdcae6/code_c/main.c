#include <parm.h>

void run(){
    BEGIN();
    int a = 5;
    int b = 8;
    a += b;
    //a = 13
    int i = 0;
    while(i<2){
        i++;
    }
    int c = a-b; // c = 5
    c = c*5; // c=25
    END();
}