-- 코드를 입력하세요
-- 아이디와 이름 조회
-- 보호 시작일보다 입양일이 더 빠른 동물
-- 보호 시작일이 빠른 순으로 조회

SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
USING(ANIMAL_ID)
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME;