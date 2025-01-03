-- 코드를 작성해주세요
-- 각 분기(QUARTER)별 분화된 대장균의 개체의 총 수(ECOLI_COUNT)
-- 각 분기에는 'Q' 를 붙이고 분기에 대해 오름차순

# WITH QUARTER AS (
#     SELECT *, (CASE WHEN MONTH(DIFFERENTIATION_DATE) IN (1, 2, 3) THEN 1
#                WHEN MONTH(DIFFERENTIATION_DATE) IN (4, 5, 6) THEN 2
#                WHEN MONTH(DIFFERENTIATION_DATE) IN (7, 8, 9) THEN 3
#                ELSE 4
#                END) AS QUARTER
#     FROM ECOLI_DATA
# )

SELECT (CASE WHEN MONTH(DIFFERENTIATION_DATE) IN (1, 2, 3) THEN '1Q'
               WHEN MONTH(DIFFERENTIATION_DATE) IN (4, 5, 6) THEN '2Q'
               WHEN MONTH(DIFFERENTIATION_DATE) IN (7, 8, 9) THEN '3Q'
               ELSE '4Q'
           END) AS QUARTER, COUNT(ID) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY 1;