#include <iostream>
using namespace std;
class base
{
    public:
    int a=12;
    protected:
    int b=20;
    private:
    int c;

};
class derived:protected base 
{
    public:
    void fun()
    {
        cout<<a<<"\n";
        cout<<b;
        
    }
};
int main()
{
    derived obj;
    obj.fun();
    return 0;
}
Parent 
Child
Iam in parent process