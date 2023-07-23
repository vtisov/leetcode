-- https://leetcode.com/problems/calculate-special-bonus
SELECT employee_id, IF(employee_id % 2 AND SUBSTR(name, 1, 1) <> "M", salary, 0) AS bonus
FROM Employees
ORDER BY employee_id;