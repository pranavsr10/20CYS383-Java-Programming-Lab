def decrypt():
    n = 327
    s = str(n)
    c = []
    for i in range(len(s)):
        c.append(chr(ord(s[i])-2))
    return ("".join(c))

print("Points needed to get the flag:", decrypt())