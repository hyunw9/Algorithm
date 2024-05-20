def solution(want, number, discount):
    map = {}
    answer = 0
    for i in range(0 , len(number)):
        map[want[i]] = number[i]

    # 10개 뺀 만큼 반복하면서 
    # 10개 돌면서 dict 에 채운다. 
    # 값이 모두 일치하면 걔를 리턴 
    
    for i in range(0, len(discount)-9):
        basket = {}
        for j in range(0, 10):
            key = discount[i+j]
            if key in basket :
                basket[key] +=1
            else:
                basket[key] =1
        
        if map == basket :
            answer += 1
    if answer >0 : return answer
    return 0