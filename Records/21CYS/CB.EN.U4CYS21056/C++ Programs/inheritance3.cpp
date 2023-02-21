#include <iostream>
using namespace std;
class base
{
    public:
    int x;
    void exe()
    {
     cout<<"\nThe value is \n"<<x;
    }
};
class base1:public base 
{
    public:
    void fun()
    {
        cout<<"\nEnter the value\n";
        cin>>x;
    }
};
int main()
{
   base1 obj1;                                
   base obj;
   obj1.fun();
   obj.exe();
   return 0;
}