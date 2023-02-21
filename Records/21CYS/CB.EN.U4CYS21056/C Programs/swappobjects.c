#include <stdio.h>
struct student
{
    int roll;
    float mark;
    
};
void swap(struct student*a, struct student*b)
{
    int temp_roll; float temp_mark;
    temp_roll=a->roll;
    a->roll=b->roll;
    b->roll=temp_roll;
    temp_mark=a->mark;
    a->mark=b->mark;
    b->mark=temp_mark;
}
int main()
{
    struct student c,d;
    c.roll=56;
    d.roll=50;
    c.mark=50;
    d.mark=68;
    swap(&c,&d);
    printf("%d %f",c.roll,c.mark);
    printf("%d %f",d.roll,d.mark);
    return 0;
}