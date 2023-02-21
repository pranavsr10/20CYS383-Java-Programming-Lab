#include<stdio.h>
int main()
{
    int a[10],i;
    int*p;
    p=a;
    for(i=0;i<3;i++)
    {
        scanf("%d",(a+i));
    }
       for(i=0;i<3;i++)
    {
        printf("%d",(*(a+i)));
    }


}