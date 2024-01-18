-- 코드를 입력하세요
-- 2022년 5월에 예약한 환자 수
-- 진료과코드 별로 조회
-- 컬럼명은 '진료과 코드', '5월예약건수'로 지정
-- 환자 수를 기준으로 오름차순, 진료과 코드를 기준으로 오름차순

SELECT MCDP_CD AS '진료과코드', COUNT(PT_NO) AS '5월예약건수'
FROM APPOINTMENT
WHERE MONTH(APNT_YMD) IN (5)
GROUP BY MCDP_CD
ORDER BY 2, 1;