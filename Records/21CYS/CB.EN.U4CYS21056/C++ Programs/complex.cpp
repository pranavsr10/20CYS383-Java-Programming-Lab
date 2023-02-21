#include<iostream>
using namespace std;

class complex {
    private:
    int real;
    int img;

    public:
    void read(int x, int y){
            real=x;
            img=y;     
        }

    void display(int a, int b) {
    cout << real<<" + "<<img<<"i"<< endl;
    }
    
    void sum(complex a,complex b){
        int r=0, i=0;
        r = a.real + b.real;
        i = a.img + b.img;
        cout << r<<" + "<<i<<"i"<< endl;
    }
};

int main(){
    complex C[2];
    int i, a[2], b[2];
    for(i=0; i<2; i++){
        cin>>a[i];
        cin>>b[i];
        C[i].read(a[i],b[i]);
        C[i].display(a[i],b[i]);
        //C[i].sum(a,b);
    }
    C[1].sum(C[0], C[1]);
    return 0;
}