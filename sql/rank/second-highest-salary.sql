-- Write your PostgreSQL query statement below
-- select (
--     select distinct salary
--     from Employee e
--     order by salary desc
--     offset 1 limit 1
-- ) as SecondHighestSalary

select (
    select distinct salary
    from (
    select salary, DENSE_RANK() OVER (order by salary desc) AS rnk
    from Employee
    )
    where rnk = 2
) as SecondHighestSalary
