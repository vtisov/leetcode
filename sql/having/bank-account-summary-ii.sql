# https://leetcode.com/problems/bank-account-summary-ii

select u.name, j.balance
from users u inner join
     (
         select t.account, sum(t.amount) as balance
         from transactions t
         group by t.account
         having sum(t.amount) > 10000
     ) j on u.account = j.account;