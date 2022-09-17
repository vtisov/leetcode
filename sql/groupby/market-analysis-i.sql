-- https://leetcode.com/problems/market-analysis-i

select u.user_id as buyer_id, u.join_date, ifnull(c.orders_in_2019, 0) as orders_in_2019
from users u left join
(
    select o.buyer_id, count(*) as orders_in_2019
    from orders o
    where year(o.order_date) = 2019
    group by o.buyer_id
) c on u.user_id = c.buyer_id