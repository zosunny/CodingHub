-- 코드를 입력하세요
-- 5월 1일을 기준으로 ORDER_ID, PRODUCT_ID, OUT_DATE, 출고여부
-- 출고여부는 5월 1일까지 출고완료, 이 후 날짜는 출고 대기, 미정이면 출고미정으로 출력
-- 주문 ID를 기준으로 오름차순 정렬

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'), (CASE
WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
ELSE '출고미정'
END) AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;