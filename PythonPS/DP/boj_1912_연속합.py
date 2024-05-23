import sys
n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split(' ')))

dp = [0 for i in range(n)]

# 10 -4 3 1 5 6 -35 12 21 -1
dp[0] = arr[0]
for i in range(1,n):
    dp[i] = max(dp[i-1]+arr[i],arr[i])
print(max(dp))