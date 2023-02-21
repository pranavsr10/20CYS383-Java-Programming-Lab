n = list(map(int, input("\nEnter the numbers in order by leaving spaces in between ").strip().split()))
i=[]
j=[]
for x in n:
    if x>0:
     d = 1
     i.append(d)
    else:
     d= 0
     i.append(d)    
m=1
for x in i :
    m=m*x
for x in n:
 temp=x
 rev=0
 while(x>0):
    dig=x%10
    rev=rev*10+dig
    x=x//10
 if(temp==rev):
     d = 1
     j.append(d)
 else:
    d=0
    j.append(d)
y=0
for x in j:
  y=y+x
if (m==1):
    print("Condition 1 is satisfied")
else:
    print ("Condition 1 is not satisfied")
if (y>0):
    print("Condition 2 is satisfied ")
else:
    print("Condition 2 is not satisfied")
if(m*y>0):
    print("TRUE")
else:
    print("FALSE")     
    