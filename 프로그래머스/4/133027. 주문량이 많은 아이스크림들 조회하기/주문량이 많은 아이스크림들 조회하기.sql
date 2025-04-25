-- 코드를 입력하세요
-- 7월 아이스크림 총 주문량 + 상반기의 아이스크림 총 주문량
-- 상위 3개의 맛


SELECT A.FLAVOR
FROM FIRST_HALF A JOIN (SELECT *, SUM(TOTAL_ORDER) AS TOTAL
                        FROM JULY
                        GROUP BY FLAVOR) B
USING(SHIPMENT_ID)
GROUP BY A.FLAVOR
ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL) DESC
LIMIT 3;