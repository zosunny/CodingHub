-- 코드를 입력하세요
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계
-- 년, 월, 성별을 기준으로 오름차순
-- 성별 정보가 없는 경우 결과에서 제외

SELECT YEAR(S.SALES_DATE)AS YEAR, MONTH(S.SALES_DATE) AS MONTH, I.GENDER AS GENDER, COUNT(DISTINCT USER_ID) AS USERS
FROM USER_INFO I JOIN ONLINE_SALE S
USING(USER_ID)
WHERE I.GENDER IS NOT NULL
GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE), I.GENDER
ORDER BY 1, 2, 3;