-- 코드를 작성해주세요
-- 아이템 희귀도 'RARE'인 아이템들의 모든 다음 업글 아이템의 ITEM_ID, ITEM_NAME, PARITY
-- ID 기준 내림차순
-- -> 부모가 'RARE'인 거

# select id
# from item_info
# where rarity = 'RARE';

select i.item_id, i.item_name, i.rarity
from item_tree t join item_info i
using(item_id)
where parent_item_id in(
    select item_info.item_id
    from item_info
    where rarity = 'RARE')
order by 1 desc;