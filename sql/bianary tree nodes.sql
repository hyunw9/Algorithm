select n , case 
    when b.p is null then 'Root'
    when exists( select 1 from bst as b2 where b.n = b2.p) then 'Inner'
    else 'Leaf'
    end 
from BST as b
-- group by n
order by n asc;
