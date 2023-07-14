// find 3rd heighst salary of each deptment.
/*
Using 'with' we can create a new temporary table and run the query on that. 
Using rank() method we can assign number to table based of groupby .

*/
with salariesRank as (
SELECT empId,salary,rank() over(partition by dept order by salary desc) as salaryRank from EMPLOYEE) 
select * from salariesRank where salaryRank=1


With salaryRank(
select name,id, salary, rank(partition by dept order by salary desc) as ranky from employee)
select slary , name from salaryRank where ranky=3
