-- 코드를 작성해주세요
-- 월별 잡은 물고기의 수와 월을 출력
-- 월을 기준으로 오름차순

SELECT COUNT(ID) AS FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY 2;