-- 코드를 작성해주세요
-- 대장균 개체의 ID(ID) 와 분류된 이름(COLONY_NAME)을 출력
-- 개체의 ID 에 대해 오름차순

WITH COLONY_RANK AS (SELECT ID, NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS SIZE_RANK
                     FROM ECOLI_DATA)
                      
SELECT ID, CASE WHEN SIZE_RANK = 1 THEN 'CRITICAL'
                WHEN SIZE_RANK = 2 THEN 'HIGH'
                WHEN SIZE_RANK = 3 THEN 'MEDIUM'
                ELSE 'LOW' END AS COLONY_NAME
FROM COLONY_RANK
ORDER BY 1;