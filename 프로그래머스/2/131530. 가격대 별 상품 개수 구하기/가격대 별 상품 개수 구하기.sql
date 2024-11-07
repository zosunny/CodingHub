-- 코드를 입력하세요
-- 만원 단위의 가격대 별로 상품 개수를 출력
-- 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시
-- 가격대를 기준으로 오름차순

SELECT FLOOR(PRICE/10000)*10000 AS PRICE_GROUP, COUNT(PRICE) AS PRODUCTS
FROM PRODUCT A
GROUP BY 1
ORDER BY 1;