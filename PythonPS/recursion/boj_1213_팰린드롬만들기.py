import sys

line =list(sys.stdin.readline().strip())

palinMap = {i:0 for i in line}
for i in line:
    palinMap[i]+=1

if len(line)//2 != 0 : #짝수인데 내부가 홀수개면 안됨 
    for k,v in palinMap :
        if v // 2 == 1  :
            print ("I'm Sorry Hansoo")
else : #홀수인데, 내부가 짝수개면 안됨 
    for k,v in palinMap :
        if v//2 == 0 :
            print ("I'm Sorry Hansoo")
# palindrome 만들기

