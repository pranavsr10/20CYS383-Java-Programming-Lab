n=int(input("Enter the number:"))
m=[int(i) for i in str(n)]
m.reverse()
y=[str(i) for i in m]
z=int("".join(y))
print("The Reversed Number:",z)

