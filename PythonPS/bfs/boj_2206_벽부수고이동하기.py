import sys
from collections import deque
dx = [0,0,-1,1]
dy = [-1,1,0,0]

n,m = map(int,sys.stdin.readline().strip().split())
arr = []
for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().strip())))
q =deque()
visited = [[list([0 for i in range(2)]) for _ in range(m)] for _ in range(n)]
# print(visited)
visited[0][0][0]= 1
q.append([0,0,0])
while q:
    y,x,w = q.popleft()
    
    if(y == n-1 and x == m-1):
        print(visited[y][x][w])
        # printf(visited)
        exit(0)
    
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if ny<0 or nx <0 or ny >= n or nx >= m :
            continue
        if arr[ny][nx] == 1 and w == 0 :
            
            visited[ny][nx][1] = visited[y][x][0]+1
            q.append([ny,nx,1])
        if arr[ny][nx]==0 and visited[ny][nx][w] == 0:
            visited[ny][nx][w]= visited[y][x][w]+1
            q.append([ny,nx,w])
print(-1)