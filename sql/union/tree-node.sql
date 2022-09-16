-- https://leetcode.com/problems/tree-node
select id, 'Root' as type
from tree
where p_id is null

union

select id, 'Leaf' as type
from tree
where id not in (select distinct p_id from tree where p_id is not null) and p_id is not null

union

select id, 'Inner' as type
from tree
where id in (select distinct p_id from tree where p_id is not null) and p_id is not null

order by id;

-- Using flow control statement CASE

select id,
    case
        when tree.id = (select atree.id from tree atree where p_id is null)
            then 'Root'
        when tree.id in (select distinct atree.p_id from tree atree)
            then 'Inner'
        else 'Leaf'
    end as type

from tree
order by id;