-- 코드를 입력하세요
-- 2022년 1월의 카테고리 별 도서 판매량을 합산
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
-- 카테고리명을 기준으로 오름차순 정렬
SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK B JOIN (SELECT *
                    FROM BOOK_SALES
                    WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31') BS
USING(BOOK_ID)
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;