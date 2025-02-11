import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

def dfs(d):
    t[d] = -2
    for i in range(n):
        if d == t[i]:
            dfs(i)

n = int(input())
t = list(map(int, input().split()))
d = int(input())

dfs(d)

cnt = 0
for i in range(n):
    if t[i] != -2 and i not in t:
        cnt += 1

print(cnt)