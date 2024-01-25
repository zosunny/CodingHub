-- 코드를 입력하세요
-- 평균 대여 기간이 7일 이상인
-- 자동차 ID와 평균 대여 기간(컬럼명: AVERAGE_DURATION)
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림
-- 평균 대여 기간을 기준으로 내림차순, 자동차 ID를 기준으로 내림차순

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) >= 7
ORDER BY 2 DESC, 1 DESC;