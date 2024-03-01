-- 코드를 입력하세요
-- 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사
-- 이름, 의사ID, 진료과, 고용일자를 조회
-- 고용일자를 기준으로 내림차순
-- 이름을 기준으로 오름차순

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY 4 DESC, 1;