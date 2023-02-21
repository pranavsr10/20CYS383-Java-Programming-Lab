
#include <stdio.h>
int main ()
{
    int *a[2][3],i,j;
    for(i=0;i<2;i++)
    {
    for (j=0;j<3;j++)
    {
        printf("Enter the values of array");
        scanf("%d\n",*(a+i)+j);

    }
    }
    for(i=0;i<2;i++)
    {
        for(j=0;j<3;j++)
    {
        printf("%p\t",*(a+i)+j);
        printf("%d\t",*(*(a+i)+j));


    }
    printf("\n");
    }
}
