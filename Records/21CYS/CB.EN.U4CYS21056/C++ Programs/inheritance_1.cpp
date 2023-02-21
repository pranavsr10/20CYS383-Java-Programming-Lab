#include <iostream>
using namespace std;
class Vehicle
{
    public:
    int model_no;
    protected:
    int colour_variant;
    int engine_hp; 
    private:
    int ownership;
};
class four_wheeler:public Vehicle 
{
    public:
    void CAR()
    {
         
    }
};
int main()
{
    derived obj;
    obj.fun();
    return 0;
}