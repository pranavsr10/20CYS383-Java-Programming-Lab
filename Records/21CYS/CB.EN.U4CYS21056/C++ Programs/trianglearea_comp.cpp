#include<iostream>
using namespace std;
class triangle
{
  public:
  int base;
  int height;
  int area;

};
int main ()
{
 int i;
 triangle t[2];
 cout<<"Enter the Height Of the Triangle\n";
 cin>>t[0].height;
 cout<<"Enter the Base Of the Triangle\n";
 cin>>t[0].base;
 t[0].area=0.5*t[0].height*t[0].base;
 cout<<"The Area Of the Triangle is\n";
 cout<<t[0].area;
 cout<<"\nEnter the Height Of the Second Triangle\n";
 cin>>t[1].height;
 cout<<"Enter the Base Of the Second Triangle\n";
 cin>>t[1].base;
 t[1].area=0.5*t[1].height*t[1].base;
 cout<<"The Area Of the Second Triangle is\n";
 cout<<t[1].area;  
  if(t[0].area<t[1].area)
 {
  cout<<"\nThe Second Triangle with the area of "<<t[1].area <<" is greater than First triangle with area of "<<t[0].area<<"\n";
 }
 
 else
 {
  cout<<"\nThe First Triangle with the area of "<<t[0].area <<" is greater than Second triangle with area of "<<t[1].area<<"\n";
 }
}
