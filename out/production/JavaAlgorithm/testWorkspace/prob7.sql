-- 코드를 입력하세요
set @minValue =99999999, @maxValueName = "";
SELECT *
FROM EMPLOYEES
where name= (
select name, IF(@minvalue>(select round(avg(salary)))-salary),SET @MINVALUE=(select round(avg(salary)))-salary,)
from employees)