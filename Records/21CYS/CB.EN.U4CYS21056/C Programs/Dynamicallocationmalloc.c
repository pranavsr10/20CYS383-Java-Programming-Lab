#include<stdio.h>
#include<stdlib.h>
int main()
{
    int*p,i,n;
    n=5;
    p=(int*)malloc(n*sizeof(int));
    for(i=0;i<3;i++)
    {
        scanf("%d\n",(p+i));
    }
    
      for(i=0;i<3;i++)
    {
        printf("%d",(*(p+i)));
    }
    free (p);
}