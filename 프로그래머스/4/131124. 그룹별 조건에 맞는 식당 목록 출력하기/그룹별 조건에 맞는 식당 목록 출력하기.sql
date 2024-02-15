-- 코드를 입력하세요
-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력
-- 리뷰 작성일을 기준으로 오름차순, 리뷰 텍스트를 기준으로 오름차순

SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE P JOIN REST_REVIEW R
USING(MEMBER_ID)
WHERE MEMBER_ID IN (SELECT MEMBER_ID
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                    HAVING COUNT(REVIEW_ID) = (SELECT COUNT(REVIEW_ID)
                                              FROM REST_REVIEW
                                              GROUP BY MEMBER_ID
                                              ORDER BY COUNT(REVIEW_ID) DESC
                                              LIMIT 1))
ORDER BY 3, 2;