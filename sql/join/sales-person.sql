-- https://leetcode.com/problems/sales-person/

select s.name
from SalesPerson s
where  sales_id not in (
    select distinct o.sales_id
    from Company c join Orders o
    on o.com_id = c.com_id and c.name = 'RED'
);