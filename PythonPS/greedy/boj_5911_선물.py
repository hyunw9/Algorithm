import sys

n, b = map(int, sys.stdin.readline().strip().split())

g = []
for i in range(n):
    g.append(list(map(int, sys.stdin.readline().strip().split())))

g.sort(key=lambda x: sum(x))
ans = 0

for i in range(n):
    left=b
    left-=g[i][1]/2
    if left < 0 :
        continue 
    avail=1
    for j in range(n):
        if i != j :
            curr= g[j][0] + g[j][1]
            if left-curr >=0:
                left-=curr
                avail+=1
    ans = max(ans, avail)

print(ans)