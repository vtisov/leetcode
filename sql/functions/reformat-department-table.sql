# https://leetcode.com/problems/reformat-department-table
select id,

       max(case when month = 'Jan' then revenue else null end) as Jan_Revenue,
       max(case when month = 'Feb' then revenue else null end) as Feb_Revenue,
       max(case when month = 'Mar' then revenue else null end) as Mar_Revenue,
       max(case when month = 'Apr' then revenue else null end) as Apr_Revenue,
       max(case when month = 'May' then revenue else null end) as May_Revenue,
       max(case when month = 'Jun' then revenue else null end) as Jun_Revenue,
       max(case when month = 'Jul' then revenue else null end) as Jul_Revenue,
       max(case when month = 'Aug' then revenue else null end) as Aug_Revenue,
       max(case when month = 'Sep' then revenue else null end) as Sep_Revenue,
       max(case when month = 'Oct' then revenue else null end) as Oct_Revenue,
       max(case when month = 'Nov' then revenue else null end) as Nov_Revenue,
       max(case when month = 'Dec' then revenue else null end) as Dec_Revenue

from
    Department
group by 1

# SELECT id, JAN AS Jan_Revenue,
#     FEB AS Feb_Revenue,
#     MAR AS Mar_Revenue,
#     APR AS Apr_Revenue,
#     MAY AS May_Revenue,
#     JUN AS Jun_Revenue,
#     JUL AS Jul_Revenue,
#     AUG AS Aug_Revenue,
#     SEP AS Sep_Revenue,
#     OCT AS Oct_Revenue,
#     NOV AS Nov_Revenue,
#     DEC AS Dec_Revenue
# FROM Department
# PIVOT
# (
#     SUM(revenue)
#     FOR month IN (JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV,DEC)
# ) P