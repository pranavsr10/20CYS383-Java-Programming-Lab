#include <iostream>
using namespace std;
class student
{
 public:
 int h;
 int b;
 int a;
};
int main()
{
 int i;
 student S[10];
 for (i=0;i<=9;i++);
  { 
     cout<<"Enter the Height Of the Triangle\n";
     cin>>S[i].h;
     cout<<"Enter the Base Of the Triangle\n";
     cin>>S[i].b;
     S[i].a=1/2*(S[i].h*S[i].b);
     cout<<"The Area Of the Triangle is\n";
     cout<<S[i].a;

   }
 cout<<"The Areas of the Triangles\n";
 for(i=0;i<=9;i++)
   {
        cout<<S[i].a<<"\n";
   }
    
   
}