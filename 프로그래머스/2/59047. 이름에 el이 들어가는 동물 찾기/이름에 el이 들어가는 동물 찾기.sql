-- 코드를 입력하세요
-- 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회
-- 결과는 이름 순으로 조회
-- 이름의 대소문자는 구분하지 않음

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%EL%'
AND ANIMAL_TYPE = 'Dog'
ORDER BY 2;