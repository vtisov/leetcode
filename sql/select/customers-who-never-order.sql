-- https://leetcode.com/problems/customers-who-never-order
select name as 'Customers' from customers where customers.id not in
(select customerId from orders);