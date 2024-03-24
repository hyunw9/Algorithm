
arr = [x for x in input()]
used = [False for x in range(len(arr))]
ans = set([])
for i in range(len(arr)):
    a = arr[i]
    ans.add(a)
    for j in range(i+1,len(arr)):
        a += arr[j]
        ans.add(a)

print(len(ans))


