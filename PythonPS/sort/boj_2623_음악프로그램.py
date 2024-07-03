import sys

n,m = map(int,sys.stdin.readline().strip().split())

seq = {i:[] for i in range(m)}

# 1 2 3 4 5 6
# 0 2 2 2 1 1
# 1 
# for i in range(n):