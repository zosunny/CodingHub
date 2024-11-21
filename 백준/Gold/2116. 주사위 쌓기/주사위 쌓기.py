n = int(input())
dice = []
for _ in range(n):
    dice.append(list(map(int, input().split())))
pair = {0: 5, 1: 3, 2: 4, 3: 1, 4: 2, 5: 0}

maxnum = 0

for i in range(6):
    max_side = []
    tmp = [1, 2, 3, 4, 5, 6]
    tmp.remove(dice[0][i])
    next = dice[0][pair[i]]
    tmp.remove(next)
    max_side.append(max(tmp))
    for j in range(1, n):
        tmp = [1, 2, 3, 4, 5, 6]
        tmp.remove(next)
        next = dice[j][pair[dice[j].index(next)]]
        tmp.remove(next)
        max_side.append(max(tmp))
    max_side = sum(max_side)
    if maxnum < max_side:
        maxnum = max_side

print(maxnum)