#include<iostream>
using namespace std;

int main(){
    int n,a[10],b,r;
    cin>>n;
    for(int i=0;i<10;i++){
        a[i]=0;

    }
    b=n;
    while(n>0){
        r=n%10;
        n/=10;
        a[r]++;
    }
    for(int i=0;i<10;i++){
        cout<<"Frequency of "<<i<<" is "<<a[i]<<endl;
    }

}