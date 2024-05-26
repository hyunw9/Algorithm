import sys

n = int(sys.stdin.readline())
nums = list(map(int,sys.stdin.readline().split()))
max = int(max(nums))
card = [False] * (max+1)
for i in nums:
    card[i] = True
score= [0 for i in range(max+1)]

for i in nums:
    
    for j in range(i*2,max+1,i):
        if card[j]:
            score[j]-=1
            score[i]+=1
print(' '.join(str(score[i]) for i in nums ))
            