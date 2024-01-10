-- 코드를 입력하세요
-- 헤비 유저(공간을 둘 이상 등록한 사람)의 등록 공간 정보
-- 아이디 순으로 조회

SELECT *
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID
                 FROM PLACES
                 GROUP BY HOST_ID
                 HAVING COUNT(ID) > 1)
ORDER BY ID;