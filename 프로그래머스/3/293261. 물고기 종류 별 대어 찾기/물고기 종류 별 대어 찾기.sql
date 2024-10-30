-- 코드를 작성해주세요
-- 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력
-- 물고기의 ID에 대해 오름차순

WITH MAX_LENGTH AS (SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
                    FROM FISH_INFO
                    GROUP BY FISH_TYPE)

SELECT D.ID, C.FISH_NAME, D.LENGTH
FROM FISH_NAME_INFO C JOIN (SELECT A.ID, A.LENGTH, A.FISH_TYPE
                            FROM FISH_INFO A JOIN MAX_LENGTH B
                            ON A.FISH_TYPE = B.FISH_TYPE AND A.LENGTH = B.LENGTH) D
ON C.FISH_TYPE = D.FISH_TYPE
ORDER BY 1;

