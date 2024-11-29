select c.company_code, founder, count(distinct lm.lead_manager_code), count(distinct sm.senior_manager_code), count(distinct m.manager_code),
count(distinct e.employee_code)
from company as c
left join lead_manager as lm on c.company_code = lm.company_code
left join senior_manager as sm on lm.lead_manager_code = sm.lead_manager_code
left join manager as m on sm.senior_manager_code = m.senior_manager_code
left join employee as e on m.manager_code = e.manager_code

group by c.company_code, c.founder 
order by c.company_code asc ;