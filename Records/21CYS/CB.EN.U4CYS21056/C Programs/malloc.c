#include<stdio.h>
#include<stdlib.h>
struct node
{
    int val;
};

int main()
{
    struct val*p;
    p=(struct node *)malloc(sizeof(struct node));
    p->val=9;
    printf("%d",p->val);
    return 0;
}