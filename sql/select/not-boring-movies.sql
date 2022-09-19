# https://leetcode.com/problems/not-boring-movies

select *
from cinema
where id % 2 and description != 'boring'
order by rating desc;