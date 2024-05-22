import math

n = int(input())

def eratosthenes(n):
    
    filter = [True for i in range(n+1)]
    filter[0] = filter[1] = False
    for i in range(2, int(math.sqrt(n))+1):
        if filter[i]:
            for j in range(i*i, n+1, i):
                filter[j]= False
    num = [i for i in range(n+1) if filter[i]]
    return num

if n <2:  
    print(0)
    exit(0)

nums= eratosthenes(n)
    
l , r = 0,0
answer =0
while r <= len(nums):
    cnt = sum(nums[l:r])
    # print(l , r , cnt)
    if cnt == n :
        answer+=1
        l +=1
    elif cnt < n : 
        r+=1
    else :
        l+=1
        
print(answer)