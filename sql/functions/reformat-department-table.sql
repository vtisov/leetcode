# https://leetcode.com/problems/reformat-department-table
select id,
       max(IF(month = 'Jan', revenue, null)) as Jan_Revenue,
       max(IF(month = 'Feb', revenue, null)) as Feb_Revenue,
       max(IF(month = 'Mar', revenue, null)) as Mar_Revenue,
       max(IF(month = 'Apr', revenue, null)) as Apr_Revenue,
       max(IF(month = 'May', revenue, null)) as May_Revenue,
       max(IF(month = 'Jun', revenue, null)) as Jun_Revenue,
       max(IF(month = 'Jul', revenue, null)) as Jul_Revenue,
       max(IF(month = 'Aug', revenue, null)) as Aug_Revenue,
       max(IF(month = 'Sep', revenue, null)) as Sep_Revenue,
       max(IF(month = 'Oct', revenue, null)) as Oct_Revenue,
       max(IF(month = 'Nov', revenue, null)) as Nov_Revenue,
       max(IF(month = 'Dec', revenue, null)) as Dec_Revenue
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