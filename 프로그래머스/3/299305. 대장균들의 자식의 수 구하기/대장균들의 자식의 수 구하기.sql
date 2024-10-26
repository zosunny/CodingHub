-- 코드를 작성해주세요
-- 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력
-- 자식이 없다면 자식의 수는 0
-- 개체의 ID 에 대해 오름차순

SELECT A.ID, COUNT(B.ID) AS CHILD_COUNT
FROM ECOLI_DATA A LEFT JOIN ECOLI_DATA B
ON A.ID = B.PARENT_ID
GROUP BY A.ID
ORDER BY 1;