import sys
import math
from collections import deque



def find(x):
    global arr
    if arr[x] == x:
        return x
    return find(arr[x])

def union(a,b):
    pa= find(a)
    pb = find(b)
    if pa!=pb :
        if pa<pb:
            arr[pb]=pa
        else:
            arr[pa]=pb
            
n = int(sys.stdin.readline().strip())
arr = [i for i in range(n)]

nodes= []
for i in range(n):
    x,y = map(float,sys.stdin.readline().strip().split())
    nodes.append([x,y])
costs =[]
for i in range(len(nodes)):
    for j in range(len(nodes)):
        if i != j : 
            distance =math.sqrt((nodes[j][0] - nodes[i][0]) ** 2 + (nodes[j][1] - nodes[i][1]) ** 2)
            costs.append([i,j,round(distance,2)])
costs.sort(key = lambda x:x[2])
costs = deque(costs)
answer = 0
# print(costs)
while costs:
    curr = costs.popleft()
    a,b,c = curr[0],curr[1],curr[2]
    
    if find(a) != find(b):
        union(a,b)
        answer+=c
    # print(arr)
print(answer)
