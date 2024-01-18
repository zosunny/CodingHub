-- 코드를 입력하세요
-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량
-- 총주문량이 작은 순서대로 조회
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER

SELECT I.INGREDIENT_TYPE, SUM(H.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF H JOIN ICECREAM_INFO I
USING(FLAVOR)
GROUP BY I.INGREDIENT_TYPE
ORDER BY 2;