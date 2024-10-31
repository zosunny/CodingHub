-- 코드를 작성해주세요
-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회
-- 점수, 사번, 성명, 직책, 이메일을 조회
-- 2022년도의 평가 점수는 상,하반기 점수의 합

# SELECT EMP_NO, SUM(SCORE)
# FROM HR_GRADE
# GROUP BY EMP_NO
# ORDER BY 2 DESC
# LIMIT 1;

SELECT S.SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_EMPLOYEES E JOIN (SELECT EMP_NO, SUM(SCORE) AS SCORE
                          FROM HR_GRADE
                          GROUP BY EMP_NO
                          ORDER BY 2 DESC
                          LIMIT 1) S
USING(EMP_NO);