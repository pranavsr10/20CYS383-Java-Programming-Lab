#include<iostream>
using namespace std;

int main(){
    int n,a=0,b=0,c;
    cin>>n;
    c=n;
    while (n>0) {
        a = n % 10;
        b = b * 10 + a;
        n /= 10;
    }

    if(b==c){
        cout<<c<<" is palindrome"<<endl;
    }
    else{
        cout<<c<<" is not palindrome"<<endl;
    }

}