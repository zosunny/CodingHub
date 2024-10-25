-- 코드를 작성해주세요
-- 대장균 개체의 ID(ID) 와 분류(SIZE)를 출력
-- ID 에 대해 오름차순

SELECT ID, (CASE WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
                WHEN SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
                ELSE 'HIGH' END) AS SIZE
FROM ECOLI_DATA
ORDER BY 1;