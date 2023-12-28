-- 코드를 입력하세요
-- 아직 입양을 못 간 동물 중
-- 가장 오래 보호소에 있었던 동물 3마리의 이름, 보호 시작일을 조회
-- 보호 시작일 오름차순

SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS I LEFT OUTER JOIN ANIMAL_OUTS O
USING(ANIMAL_ID)
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
LIMIT 3;