#include<iostream>
using namespace std;
//BASE CLASS
class base 
{
public:
int x;
void getdata()
{
 cin>> x;
} 
};

//DERIVED CLASS FROM BASE
class derive1: public base 
{
public:
int y;
void readdata()
{
 cin >> y;
}
};
//DERIVED CLASS FROM DERIVE1
class derive2 : public derive1
{
private:
int z;
public:
void indata()
{
 cin >> z;
}
void product()
{
 cout<<"Product= " << x*y*z;
}
};
//Main
int main()
{
 derive2 a;
 a.getdata();
 a.readdata();
 a.indata();
 a.product();
 return 0;
}
