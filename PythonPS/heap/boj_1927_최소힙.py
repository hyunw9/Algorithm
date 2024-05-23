import heapq
import sys
n = int(sys.stdin.readline())

pq = []

for i in range(n):
    
    now = int(sys.stdin.readline())
    if now == 0 :
        if pq:
            print(heapq.heappop(pq))
        else:
            print(0)
    else:
        heapq.heappush(pq,now)
