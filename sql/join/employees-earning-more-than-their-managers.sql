# https://leetcode.com/problems/employees-earning-more-than-their-managers

select e.name as employee
from employee e left join employee m on e.managerId = m.id
where e.salary > m.salary