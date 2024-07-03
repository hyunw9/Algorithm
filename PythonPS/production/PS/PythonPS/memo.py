arr = [('사과', 2), ('바나나', 2), ('체리asd', 2)]
arr.sort(key=lambda x : (-x[1],-len(x[0])))
print(arr)
