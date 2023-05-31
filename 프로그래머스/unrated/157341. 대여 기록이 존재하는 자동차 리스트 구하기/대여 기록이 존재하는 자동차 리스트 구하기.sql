-- 코드를 입력하세요
SELECT distinct a.car_id
from car_rental_company_car a join car_rental_company_rental_history b
using(car_id)
where  a.car_type = '세단' and month(b.start_date) in (10)
order by a.car_id desc;