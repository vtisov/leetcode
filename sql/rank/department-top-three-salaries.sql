-- https://leetcode.com/problems/department-top-three-salaries/

-- Write your PostgreSQL query statement below
select Department, Employee, Salary
from (select d.name as Department,
    e.name as Employee,
    e.salary as Salary,
    DENSE_RANK() OVER (partition by d.id order by salary desc) as rnk
from Employee e join Department d on e.departmentId = d.id)
where rnk <= 3;
