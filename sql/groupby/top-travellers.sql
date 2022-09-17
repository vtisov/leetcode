-- https://leetcode.com/problems/top-travellers

select u.name, ifnull(s.distance, 0) as travelled_distance
from users u left join (select r.user_id, sum(r.distance) as distance
    from rides r
    group by r.user_id) s on u.id = s.user_id
order by travelled_distance desc, name asc