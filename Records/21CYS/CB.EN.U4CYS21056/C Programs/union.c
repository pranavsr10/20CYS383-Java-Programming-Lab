#include <stdio.h>
int main()
{
    union 
    {
        int a;
        int b;
    }u;
    u.a=10;
   printf("%d",u.a);
   u.b=20;
    printf("%d",u.b);
    return 0;
} 
