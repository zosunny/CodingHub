-- 코드를 작성해주세요
-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력
-- 분화된 연도별 대장균 크기의 편차 = 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
-- 연도에 대해 오름차순, 대장균 크기의 편차에 대해 오름차순

WITH MAX_SIZE AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
)

SELECT M.YEAR, (M.MAX_SIZE - E.SIZE_OF_COLONY) AS YEAR_DEV, E.ID
FROM ECOLI_DATA E JOIN MAX_SIZE M
ON YEAR(E.DIFFERENTIATION_DATE) = M.YEAR
ORDER BY 1, 2;