import sys
from collections import deque

n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))
st = []
ans = []
ans.append(-1)
st.append(arr[len(arr)-1])

# print(st) 
for i in arr[len(arr)-2::-1]:
    
    while st and st[-1] <= i:
        st.pop()
    if st :
        ans.append(st[-1])
    else :
        ans.append(-1)
    st.append(i)

if len(arr) == 1:
    print(ans[-1])
else:
    print(' '.join(map(str,ans[::-1])))    
# 4
# 3 5 2 7
# 3 넣고 5 넣고 2는 top 보다 작으니까 무시하고 7 넣기 
# 처음거 스택에 넣음 3
# 3 5 2 7 
# 5 7 7 -1 



