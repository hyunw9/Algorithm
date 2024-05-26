import sys
from collections import deque

t = int(sys.stdin.readline())
answer =[]
for i in range(t):
    
    n,k = map(int,sys.stdin.readline().split())
    adj= {i:[] for i in range(1,n+1)}

    cost = list(map(int,sys.stdin.readline().split()))
    inDegree = [int(0)] * int(n+1)
    for i in range(k) :
        start,end = map(int,sys.stdin.readline().split())
        adj[start].append(end)
        inDegree[end]+=1
    target = int(sys.stdin.readline())

    q = deque()
    dp = [0] *(n+1)

    for i in range(1,n+1):
        if inDegree[i] == 0:
            dp[i] = cost[i-1]
            q.append(i)
    while q:
        curr = q.popleft()
        c = cost[curr-1]
        maxcost = 0
        for i in adj[curr]:
            inDegree[i]-=1
            dp[i] = max(dp[i],dp[curr]+cost[i-1])
            
            if inDegree[i] == 0 :
                q.append(i) 
        
        if inDegree[target] == 0:
            # print(dp[target])
            print(dp[target])
            # answer.append(dp[target])
            break
    # 10 1 100 10
    # 10 110 120
# print[' '.join(int(dp[target]))]