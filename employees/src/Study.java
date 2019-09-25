
public class Study 
{
/*
 	@insert  delete  update
 	
 	
 	@select limit as	- select에 연산자 사용
 	select (salary/10) as pay from employees limit 10
 	select (salary/10) "페이" from employees limit 10
 	
 	select mod(5,2) from dual	--	5/2의 나머지를 구함
 	
 	@select 컬럼에 적용가능한 함수
 	select round(salary/12) from departments	--	급여 반올림
 	select floor(salary/12) from departments	--	급여 소수점버림
 	select sign(salary) from salaries limit 10  --	양수면1 음수면 -1 0이면0 이나온다
 	
 	select lower(dept_name) from departments		--	소문자 출력
 	select upper(dept_name) from departments		--	대문자 출력
 	select length(dept_name) from departments		--	문자열길이
 	select substr(dept_name,1,2) from departments	--	문자를 자름 1번째 부터 2개자른다
 	select trim(dept_name) from departments			--	앞뒤 공백제거
 	select rtrim(dept_name) from departments	
 	select ltrim(dept_name) from departments
 	select replace(dept_name,'GOODEE','gd') from departments
 	select substr(dept_no,3,2) from departments	
 	select concat(substr(dept_no,3,2),'**') from departments --합침  49***
 	
 	@select 날짜 함수
 	
 	select now() from dual	--	현재시간을 구한다
 	select date_add(now(), interval 1000 day)from dual; 날짜에 더한다
 	select emp_np,year(birth_date) from enployss limit 10;
 	select emp_np,month(birth_date) from enployss limit 10;
 	select emp_np,day(birth_date) from enployss limit 10;
 	select emp_no, datediff(now(),hire_date) "근속일" from employees limit 10
 	select(case gender ='M' then '남자' else'여자' end) "성별" from employees limit 10;
 	
 	select dept_no , dept_name from departments
 	select (case when dept_no='d001' then dept_name end) from departments
 	
 	select
 	(case when dept_no ='d001' then dept_name else null end)"d001")
 	(case when dept_no ='d002' then dept_name else null end)"d002")
 	(case when dept_no ='d003' then dept_name else null end)"d003")
 	(case when dept_no ='d004' then dept_name else null end)"d004")
 	(case when dept_no ='d005' then dept_name else null end)"d005")
 	(case when dept_no ='d006' then dept_name else null end)"d006")
 	(case when dept_no ='d007' then dept_name else null end)"d007")
 	(case when dept_no ='d008' then dept_name else null end)"d008")
 	(case when dept_no ='d009' then dept_name else null end)"d009")
 	from departments 
 	
  	where : 등호 부등호 adn or between and in like'
  	
  	select emp_no from enployees where gender = 'M'
  	union
  	select emp_no from employees where gender = 'F'
 
 	in >> not in

		Liske 연산자/

*/
}
