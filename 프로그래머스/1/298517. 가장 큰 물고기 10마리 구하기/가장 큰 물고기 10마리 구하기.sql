-- 코드를 작성해주세요
-- 가장 큰 물고기 10마리의 ID와 길이를 출력
-- 길이를 기준으로 내림차순, 물고기의 ID에 대해 오름차순

SELECT ID, LENGTH
FROM FISH_INFO
ORDER BY 2 DESC, ID
LIMIT 10;