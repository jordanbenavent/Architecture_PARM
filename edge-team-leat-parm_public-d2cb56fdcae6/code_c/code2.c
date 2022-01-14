#include <parm.h>

void run(){
    BEGIN();

    int a = 0;

    if(1){
        a=1;
    }
    int b=3;
    (a>b) ? b++ : a++;

    int c=8;
    c/=2;

    END();
}