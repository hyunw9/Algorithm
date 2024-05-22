import sys
from collections import deque

# 방향 벡터 정의 (상, 하, 좌, 우)
dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]

# 모든 요소가 0인지 확인하는 함수
def check_all_zero(map_data):
    for row in map_data:
        for cell in row:
            if cell != 1 or cell != -1:
                return False
    return True

# 입력 받기
m, n = map(int, sys.stdin.readline().split())  # n: 행, m: 열
map_data = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
used = [[False] * m for _ in range(n)]

q = deque()
answer = 0

# 모든 요소가 0인지 확인하고 그렇다면 0을 출력하고 종료
if check_all_zero(map_data):
    print(0)
    exit()

# 초기 상태 설정: 값이 1인 위치를 큐에 추가
for i in range(n):
    for j in range(m):
        if map_data[i][j] == 1:
            q.append([i, j])

# BFS 실행
while q:
    y, x = q.popleft()
    answer = max(answer, map_data[y][x])

    for i in range(4):
        ny = dy[i] + y
        nx = dx[i] + x

        # 인덱스 범위와 방문 여부 확인
        if nx < 0 or ny < 0 or nx >= m or ny >= n or used[ny][nx] == True:
            continue
        # 장애물 확인
        if map_data[ny][nx] == -1:
            continue
        if map_data[ny][nx] == 0:
            q.append([ny, nx])
            map_data[ny][nx] = map_data[y][x] + 1
            used[ny][nx] = True

# 모든 위치를 검사하여 전염되지 않은 0이 있는지 확인

for i in range(n):
    for j in range(m):
        if map_data[i][j] == 0:
            print(-1)
            exit(0)
        answer = max(answer, map_data[i][j])

# 최종 결과 출력 (초기값이 1이었으므로 1을 빼줌)
print(map_data)
print(answer - 1)
