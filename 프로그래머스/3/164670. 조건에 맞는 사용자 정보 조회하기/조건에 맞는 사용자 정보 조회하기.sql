-- 코드를 입력하세요
-- 중고 거래 게시물을 3건 이상 등록한 사용자
-- 사용자 ID, 닉네임, 전체주소, 전화번호
-- 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력
-- 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력
-- 회원 ID를 기준으로 내림차순

SELECT USER_ID, NICKNAME,
       CONCAT(CITY, SPACE(1), STREET_ADDRESS1, SPACE(1), STREET_ADDRESS2) AS '전체주소',
       CONCAT(LEFT(TLNO, 3), "-", MID(TLNO, 4, 4), "-", RIGHT(TLNO, 4)) AS TLNO
FROM USED_GOODS_USER
WHERE USER_ID IN (SELECT WRITER_ID
                  FROM USED_GOODS_BOARD
                  GROUP BY WRITER_ID
                  HAVING COUNT(WRITER_ID) >= 3)
ORDER BY 1 DESC;