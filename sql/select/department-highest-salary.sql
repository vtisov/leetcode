# https://leetcode.com/problems/department-highest-salary

select
    department.name as Department,
    employee.name as Employee,
    salary
from employee join department on employee.departmentId = department.Id
WHERE
        (employee.departmentId , salary) IN
        (   select departmentId, max(salary)
            from employee
            group by departmentId
        );

# select d.name as Department, e.name as Employee, e.salary as Salary
# from employee e, department d,
# (
# select max(salary) as salary, departmentId
# from employee
# group by departmentId
# order by salary
# ) t
# where e.departmentId = d.id and e.salary = t.salary and e.departmentId = t.departmentId;

