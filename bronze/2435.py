"""첫째 줄에 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 주어진다. N은 온도를 측정한 전체 날짜의 수이다. N은 2이상, 100이하이다. K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다. 

둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수는 모두 -100이상, 100이하이다."""

length, value = map(int,input().split())
array =list(map(int,input().split()))
result= []
for i in range(0,length-value+1):
    result.append(sum(array[i:i+value]))
    
print(max(result))
