#include<stdio.h>
#include<stdlib.h>
int main()
{
    int*p,i,n=2;
    p=(int*)calloc(n,sizeof(int));
    for(i=0;i<=n;i++)
    {
        scanf("%d\n",(p+i));
    }
    
      for(i=0;i<=n;i++)
    {
        printf("%c",(*(p+i)));
    }
    free (p);
}