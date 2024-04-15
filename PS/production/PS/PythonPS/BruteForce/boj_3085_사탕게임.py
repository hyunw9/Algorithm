n = int(input())
arr = [[a for a in input()] for b in range(n)]
print(arr)
q = []
max = 0
dx = [0,0,-1,1]
dy = [-1,1,0,0]
used = [[False for a in range(n)] for a in range(n)]

#가로로 바꾸고 탐색
for i in range(n):
    for j in range(n-1):
        tmp = arr[i][j]
        arr[i][j] = arr[i][j+1]
        arr[i][j+1] = tmp

        q.append([i,j])
        used[i][j] = True
        #팀색
        

#세로로 바꾸고 탐색