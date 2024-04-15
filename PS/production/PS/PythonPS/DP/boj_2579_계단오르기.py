import sys
a = int(sys.stdin.readline())

arr = [int(sys.stdin.readline().strip()) for n in range(a)]
dp= [0 for a in range(a+1)]
arr  = [0] + arr
if a ==1 :
    print(arr[1])
elif a==2 :
    print(arr[1]+arr[2])
else:
    dp[1] = arr[1]
    dp[2] = arr[2]+arr[1]
    dp[3] = max(arr[2],arr[1])+arr[3]

    for i in range(4,a+1):
        dp[i] = max(dp[i-3]+arr[i-1],dp[i-2])+arr[i]

    print(dp[a])