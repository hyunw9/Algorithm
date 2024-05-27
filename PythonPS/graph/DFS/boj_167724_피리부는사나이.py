import sys

def dfs(y,x,dir):
    global count
    cycle.append([y,x])
    
    visited[y][x] = True
    
    ny = dirMap[dir][0]+y
    nx = dirMap[dir][1]+x
    
    if visited[ny][nx] :
            if [ny,nx] in cycle:
                count+=1
                return
    else:
        dfs(ny,nx,keyMap[ny][nx])
    # print(dirMap[dir])
    # print(f"curr: {dir} next: {keyMap[ny][nx]} (ny,nx): {ny} {nx}")

n,m = map(int,sys.stdin.readline().split())
dirMap ={'U':(-1,0), 'D':(1,0),'L':(0,-1),'R':(0,1)}
keyMap = [list(sys.stdin.readline().strip()) for _ in range(n)]

# 사이클 판별하면 되는 문제다. 
visited = [[False for _ in range(m)] for _ in range(n)]
count = 0
for i in range(n):
    for j in range(m):
        if visited[i][j]==False:
            cycle = []
            dfs(i,j,keyMap[i][j])
            
print(count)
