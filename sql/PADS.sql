SELECT concat(name, case 
    when o.occupation = 'Doctor' then '(D)'
    when o.occupation = 'Actor' then '(A)'
    when o.occupation = 'Singer' then '(S)'
    when o.occupation = 'Professor' then '(P)'
    end)
from occupations as o
order by o.name asc; 
select concat('There are a total of ',count(*),' ', lower(occupation),'s.') 
from occupations as o
group by occupation
order by count(*);