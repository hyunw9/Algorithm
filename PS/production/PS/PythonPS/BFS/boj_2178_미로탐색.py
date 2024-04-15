dx = [0,0,-1,1]
dy = [-1,1,0,0]

n,m = map(int,input().split(" "))
arr=[[int(i) for i in input()] for j in range(n)]
q = []
used= [[False for i in range(m)] for j in range(n)]
q.append([0,0])
used[0][0] = True
while q:
    now = q.pop(0)

    if now[0] == n-1 and now[1] == m-1 :
        break

    for i in range(4):
        nx = dx[i] + now[1]
        ny = dy[i] + now[0]

        if ny< 0 or nx < 0 or ny >= n or nx >=m : continue
        if arr[ny][nx] == 0: continue
        if used[ny][nx]: continue

        used[ny][nx] = True
        arr[ny][nx] = arr[now[0]][now[1]]+1
        q.append([ny,nx])

print(arr[n-1][m-1])
