import sys
from collections import deque

count = 0;
n = int(sys.stdin.readline())
arr =[]
for i in range(n):
    arr.append(int(sys.stdin.readline()))
st = deque()
st.append(arr[len(arr)-1])
for i in range(len(arr)-2,-1,-1):
    curr = arr[i]
    print(st)
    while st and st[-1] <= curr:
        st.pop()
    st.append(curr)
    count+=len(st)

print(count)
# 10,3,7,4,12,2 
# 날림수 저장해놓으면 된다.    


 