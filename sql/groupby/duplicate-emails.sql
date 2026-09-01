-- https://leetcode.com/problems/duplicate-emails/

-- Write your PostgreSQL query statement below
select email
from Person
group by email
having count(*) > 1
