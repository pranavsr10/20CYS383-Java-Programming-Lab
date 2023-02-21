def findSeq(n_in):
    tempseq=[]
    temp=n_in
    while (temp!=1):
        tempseq.append(temp)
        if (temp%2==0):
            temp/=2
        else:
            temp=(3*temp)+1
    tempseq.append(temp)
    return tempseq


opt=int(input())
nMAIN=int(input())

seq=findSeq(nMAIN)

if opt==1:
    [print(int(x),end=" ") for x in seq]

elif opt==2:
    seqs=[]
    seqs.append(seq)


    for i in range(1,nMAIN):
        tempseq=findSeq(i)

        seqs.append(tempseq)
    max_len = -1

    for ele in seqs:
        if len(ele) > max_len:
            max_len = len(ele)
            res = ele
            num=ele[0]
    print(num,len(res))

