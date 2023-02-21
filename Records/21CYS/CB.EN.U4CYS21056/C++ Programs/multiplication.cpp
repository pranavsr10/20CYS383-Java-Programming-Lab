#include <iostream>
using namespace std;
int main()
{
 int a,b,i;
 cin>>a;
 cout<<"Print the multiplication table of a number upto 10:\n";
 for(i=1;i<=10;i++)
  {
    b=0;
    b=a*i;
    cout<<a<<" x "<<i<<" = "<<b<<"\n";
  }

 return 0; 
}
