
select name
from (select name, s.id, salary
     from packages as p , students as s
     where p.id = s.id) as stu 
     inner join 
     (select f.id, salary 
      from packages as p, friends as f
      where f.friend_id = p.id) as fri
      on stu.id = fri.id
where fri.salary > stu.salary
order by fri.salary;
;
/*
Enter your query here.
*/