select x,y
from functions 
where x = y
group by x,y
having count(*) =2 

union 

select a.x  , a.y 
from functions as a inner join functions as b on a.x =b.y and a.y= b.x
where a.x < a.y
order by x;