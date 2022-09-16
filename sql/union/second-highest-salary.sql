-- https://leetcode.com/problems/second-highest-salary
select ifnull((select salary
         from employee
         order by salary desc
         limit 1 offset 1), null) as SecondHighestSalary