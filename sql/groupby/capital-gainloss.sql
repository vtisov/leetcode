-- https://leetcode.com/problems/capital-gainloss

select stock_name, sum(p.price) as capital_gain_loss
from (select s.stock_name, s.operation,
        (case
            when s.operation = 'BUY'
                then (-1 * s.price)
            else s.price
         end) as price
     from stocks s) p
group by p.stock_name;