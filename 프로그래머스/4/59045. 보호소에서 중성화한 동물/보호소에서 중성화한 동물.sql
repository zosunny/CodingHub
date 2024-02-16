-- 코드를 입력하세요
-- 들어올 당시에는 중성화되지 않았지만,
-- 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회
-- 아이디 순

SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN (SELECT *
                        FROM ANIMAL_OUTS
                        WHERE SEX_UPON_OUTCOME LIKE 'SPAYED%' OR SEX_UPON_OUTCOME LIKE 'NEUTERED%') O
USING(ANIMAL_ID)
WHERE SEX_UPON_INTAKE LIKE 'INTACT%'
ORDER BY 1;