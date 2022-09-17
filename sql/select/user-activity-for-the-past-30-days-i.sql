-- https://leetcode.com/problems/user-activity-for-the-past-30-days-i

select activity_date as day, count(distinct user_id) as active_users
from activity
where datediff('2019-07-27', activity_date) < 30 AND activity_date <= '2019-07-27'
group by activity_date

-- select activity_date as day, count(distinct user_id) as active_users
-- from activity
-- where activity_date between ('2019-07-27' - interval 29 day) AND '2019-07-27'
-- group by activity_date;