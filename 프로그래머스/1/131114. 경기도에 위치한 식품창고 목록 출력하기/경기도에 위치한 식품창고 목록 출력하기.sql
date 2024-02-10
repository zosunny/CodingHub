-- 코드를 입력하세요
-- 경기도에 위치한 창고
-- ID, 이름, 주소, 냉동시설 여부
-- 냉동시설 여부가 NULL인 경우, 'N'으로 출력
-- 창고 ID를 기준으로 오름차순

SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N')
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;