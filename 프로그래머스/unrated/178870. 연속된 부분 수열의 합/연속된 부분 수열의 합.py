def solution(sequence, k):
    ans = []
    
    s = 0
    e = 0
    tmp = 0

    # 시작 인덱스
    for i in range(len(sequence)):
        # 현재 시작 인덱스부터 k보다 작은 부분 수열의 합 계산
        while tmp < k and e < len(sequence):
            tmp += sequence[e]
            e += 1

        # 이 값이 k와 같으면 추가
        if tmp == k:
            ans.append([e-i, i, e-1])

        # 시작 인덱스의 값은 제거
        tmp -= sequence[i]
    
    ans.sort()
    
    return ans[0][1:]