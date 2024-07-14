-- 코드를 입력하세요
-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력
-- 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순

SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE P JOIN (SELECT *
                            FROM REST_REVIEW
                            WHERE MEMBER_ID = (SELECT MEMBER_ID
                                                FROM REST_REVIEW
                                                GROUP BY MEMBER_ID
                                                ORDER BY COUNT(*) DESC
                                                LIMIT 1)) R
USING(MEMBER_ID)
ORDER BY 3, 2;