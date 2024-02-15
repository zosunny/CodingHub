-- 코드를 입력하세요
-- 동일한 회원이 동일한 상품을 재구매한 데이터
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력
-- 회원 ID를 기준으로 오름차순, 상품 ID를 기준으로 내림차순

SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID) >= 2
ORDER BY 1, 2 DESC;