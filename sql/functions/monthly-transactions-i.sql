-- Write your PostgreSQL query statement below
select
    TO_CHAR(trans_date, 'YYYY-MM') AS month,
    country,
    count(*) as trans_count,
    SUM(CASE WHEN state = 'approved' then 1 else 0 end) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(CASE WHEN state = 'approved' then amount else 0 end) as approved_total_amount
from Transactions t
group by month , country
