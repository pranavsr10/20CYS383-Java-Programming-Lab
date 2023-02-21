n=int(input("Enter The Number:"))
m=n
count=0
while(n>0):

	if(n%2==0):
		count=int(count+1)
	n=int(n/10)	
print("Even Digit count is:",count)
o = len(str(m))
print("Odd Digit count is:",o-count)
