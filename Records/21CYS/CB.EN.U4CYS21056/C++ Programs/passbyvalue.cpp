#include <iostream>
using namespace std;
class complex{
float real,imagine;
public:
void getData();
void putData();
void sum (complex A, complex B);
};
void complex :: getData(){
cin>>real;
cin>>imagine;
}
void complex :: putData(){
if (imagine>=0){
cout<<real<<"+"<<imagine<<"i";
}
else{
cout<<real<<imagine<<"i";
}
}
void complex :: sum(complex input1, complex input2){
real = input1.real+input2.real;
imagine = input1.imagine+input2.imagine;
}
int main() {
complex X,Y,Z;
X.getData();
Y.getData();
Z.sum(X,Y);
Z.putData();
return 0;
}
