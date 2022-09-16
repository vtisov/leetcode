-- https://leetcode.com/problems/patients-with-a-condition
select *
from patients
where conditions LIKE 'DIAB1%' or conditions LIKE '% DIAB1%';