select * from emp;
select * from dept;

-- 1. 비교 연산자
select empno, ename, sal from emp where sal >= 3000;
select empno, ename, sal from emp where sal <> 3000; -- sal != 3000
select * from emp where deptno = 10;
select * from emp where deptno = 10;

-- 급여가 1500 이하인 사원의 사원번호, 사원 이름, 급여를 출력하는 SQL 문을 작성해 보시오.
select empno, ename, sal from emp where sal <= 1500;

-- 2. 문자 데이터 조회
--    명령문은 대소문자 구분되지 않지만 데이터 value는 대소문자 구별됨을 주의해야한다.
select empno, ename, sal from emp where ename = 'FORD';

-- 사원이름이 SCOTT 인 사원의 사원번호, 사원 이름, 급여를 출력하는 SQL문을 작성해 보시오
select empno, ename, sal from emp where ename = 'SCOTT';

-- 3. 날짜 데이터 조회
--    오라클에서 date타입에서도 문자열로 비교 가능하도록 지원.
select * from emp where hiredate <= '1982/01/01';
select * from emp where hiredate <= '1982-01-01';
select * from emp where hiredate <= to_date('1982/01/01', 'yyyy/mm/dd');


-------------------- 연산자는 항상 null을 제외함
-- 4. 논리 연산자
select * from emp where deptno = 10 and job = 'MANAGER';
select * from emp where deptno = 10 or job = 'MANAGER';
select * from emp where not deptno = 10;

select * from emp where not deptno = 10 or job = 'MANAGER';
select * from emp where deptno = 10 or not job = 'MANAGER';

-- 2000에서 3000 사이의 급여를 받는 사원을 조회해 봅시다.
select * from emp where 2000 <= sal and sal <= 3000;
-- 커미션이 300 이거나 500 이거나 1400 인 사원을 검색해 봅시다. 
select * from emp where comm=300 or comm = 500 or comm =1400;

select empno, sal from emp where empno = 7521 or empno = 7844 or empno = 7654;

-- 5. between and 연산자 : 이상/이하, 숫자와 날짜에 사용 가능
select * from emp where sal between 2000 and 3000;
select * from emp where hiredate between '1987/01/01' and '1987/12 31';

-- 6. in 연산자
select * from emp where comm in (300, 500, 1400);
select empno, sal from emp where empno in(7521, 7654, 7844);
select * from emp where comm <> 300 and comm<> 500 and comm<>1400;
select * from emp where comm not in(300, 500, 1400);

select empno, ename from emp where empno not in(7521, 7654, 7844);
select empno, ename from emp where empno <> 7521 and empno <> 7654 and empno <> 7844;

-- 7. like와 wild카드
select * from emp where ename like 'F%';
select * from emp where ename like 'J%';
select * from emp where ename like '%A%';
select * from emp where ename like '_A%';

-- 8. Null위한 연산자 : NULL이 저장되어 있는 경우에는 = 연산자로 판단할 수 없다.
select * from emp where comm is null;
select * from emp where mgr is null;

-- 9. order by : 숫자, 문자, 날짜를 기준으로 정렬 가능. null은 무한대라고 간주하기.
select * from emp order by sal;
select empno, ename from emp order by empno ASC;
select * from emp where regexp_like(ename, 'F');
select * from emp order by hiredate desc;
select * from emp order by hiredate desc, ename asc;

-- 부서본호가 빠르 사원부터 출력하되, 같은 부서내의 사원인 경우 최근 입력한 사원부터 출력.
select empno, hiredate, ename, sal, deptno from emp order by deptno, hiredate desc;

select * from emp where regexp_like(ename, 'TH|ER');
-- 10. desc + table이름 : table의 속성과 데이터타입, 속성 constraint정보 제공, describe의 약자
desc dual;
desc emp; -- primary key : not null이면서 unique;

-- 11. 숫자함수
------1. trunc(숫자, 자리수) : 특정 자리수 이하를 버린 결과. truncate약자
select trunc(34.5678, 2), trunc(34.5678, -1), trunc(34.5678) from dual;
select mod(27, 2), mod(27, 5), mod(27, 7) from dual;

-- 사번이 홀수인 사람들을 검색해보시오
select * from emp where mod(empno, 2) = 1;

-----------------------------------<4. 문자처리함수>------------------------------------------
-- 4.1 Upper함수 : 대문자로 변환
--     Lower함수 : 소문자로 변환
--     Initcap함수 : 이니셜만 대문자로 하고 나머지는 소문자로 변환, 한글이 들어가도 사용은 가능(다만 효과는 없음)
select 'Welcome to Oracle', upper('welcome to Oracle') from dual;
select 'Welcome to Oracle', lower('welcome to Oracle') from dual;
select 'Welcome to Oracle', INITCAP('welcome to oracle') from dual;
select 'Welcome to Oracle', INITCAP('WELCOME TO ORACLE') from dual;

select empno, ename, job from emp where job = 'manager'; -- 안나옴, MANAGER이기 때문
select empno, ename, job from emp where lower(job) = 'manager';

-- 4.2 Length 함수 : 길이 알려줌
--     LengthB 함수: byte길이 알려줌 (거의 안 씀)
select length('Oracle'), length('오라클') from dual;
select lengthb('Oracle'), lengthb('오라클') from dual;

-- 4.3 SUBSTR : 문자열 출력 함수, 오라클은 1부터 시작함을 잊지 말자
select substr('Welcome to Oracle', 4, 3) from dual;
select substr('Welcome to Oracle', -4, 3) from dual; -- 시작위치에서 음수는 뒤쪽에서부터 시작.

select substr(hiredate, 1, 2)년도 , substr(hiredate, 4, 2) 달, substr(hiredate, 7, 2) 일 from emp; -- 99/11/18이런 형태였음
---- 9월이 입사한 사원을 출력하시오
select * from emp where substr(hiredate, 4, 2) = 09;
---- 87년도에 입사한 직원울 추출하시오
select * from emp where substr(hiredate, 1, 2) = 87;
---- 이름이 E로 끝나는 사원을 추출하시오
select ename from emp where substr(ename, -1, 1) = 'E';
select ename from emp where ename like('%E');

-- 4.4 INSTR : 문자가 나타나는 위치를 알려준다.
--     InSTR(문자열, 찾을대상) : 시작위치 1, 발견 1로 간주
--     instr(문자열, 찾을대상, 시작위치, 몇번째 발견)
select instr('welcome to oracle', 'o') from dual; -- 첫번째 매칭 되는 것을 알려준다.
select instr('welcome to oracle', 'o', 6, 2)from dual; -- m부터 시작, 2번째인 Oracle의 o를 발견

-- 4.5 lpad : 문자열에 명시된 자리수에서 오른쪽에 나타내고, 왼쪽 자리는 특정 기호로 채움 left padding
select lpad('oracle', 20, '#') from dual; -- ##############oracle
select rpad('oracle', 20, '#') from dual; -- oracle##############

-- 4.6 rtrim  : 오른쪽 공백문자를 삭제
select length('    oracle     ') from dual;
select length(rtrim('     oracle     ')) from dual;
select length(ltrim('     oracle     ')) from dual;

-- 4.7 trim : 특정 문자가 첫번째나 마지막에 있는 글자일 때 삭제, 문자 지정 안하면 공백문자 삭제
select trim('a' from 'aaaaOracleaaaa') from dual;
select length(trim(' Oracle ')) from dual;

---------------------------------------<5.날짜 함수>--------------------------------
-- 5.1 sysdate : 현재 날짜 반환
select sysdate from dual;
select sysdate-1 어제, sysdate 오늘, sysdate + 1 내일 from dual;

------ 각 사원 수의 현재까지 근무 일수
select sysdate - hiredate 근무일수 from emp;
select round(sysdate-hiredate, 3) from emp; -- 3자리까지 출력

-- 5.2 round(date, format) : 날짜를 특정 기준으로 반올림 할 수 있다.
select hiredate, round(hiredate, 'mon') from emp;
select round(sysdate, 'day') from dual;

-- 5.3 trunc(date, format) : 날짜를 자를 수도 있다
---- 입사일을 달을 기준을 절삭하시오
select hiredate, trunc(hiredate, 'month')from emp;

-- 5.4 Month_between(day1, day2) : 두 날짜 사이의 개월 수를 구해줌
---- 각 직원이 근무한 개월 수를 구해줌
select ename, sysdate, hiredate, months_between(sysdate, hiredate) from emp;

-- 5.5 add_months(date, plusNum) : 특정 개월수를 더한 날짜를 구함
----입사 날짜에서 6개월 추가
select ename, hiredate, add_months(hiredate, 6) from emp;

-- 5.6 next_day(date, 요일) : 해당 날짜를 기준으로 최초로 도래하는 요일에 해당하는 날짜 반환 
--                         각 국가마다 지원되는 언어로 사용
select sysdate, next_day(sysdate, '수요일') from dual;
select sysdate, next_day(sysdate, '일요일') from dual;

-- 5.7 last_day(date) : 해당 날짜갓 속한 달의 마지막 날짜를 반환
select hiredate, last_day(hiredate) from emp;

-----------------------------------<6. 형변환함수>-----------------------------------
-- to_date <-> to_char <-> to_number

-- 6.1 to_char
-- 6.1.1 to_char(date, 형식) : 날짜를 문자형으로 변환
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;
select hiredate, to_char(hiredate, 'yyyy/mm/dd day') from emp;
select hiredate, to_char(hiredate, 'yyyy/mm/dd dy') from emp;
select sysdate, to_char(sysdate, 'yyyy/mm/dd, AM hh24:mi:ss') from dual;

-- 6.1.2 to_char(숫자) : 숫자를 문자형으로 변환
select to_char(12300000) from dual;
select ename, sal, to_Char(sal, 'L999,999')from emp;
select ename, sal, to_Char(sal, 'L000,000')from emp;

-- 6.2 to_date('문자', '형식') : 문자를 날짜로 변환
select ename, hiredate from emp where hiredate = to_date(19810220, 'yyyymmdd');
select trunc(sysdate-to_date('2008/01/01', 'yyyy/mm/dd')) from dual;

-- 6.3 to_number(숫자문자, 문자의 형식) : 문자형을 숫자형으로 변환
select to_number('20,000', '99,999') - to_number('10,000', '99,999') from dual;

-------------------------------------<7. NULL을 다루는 함수>-----------------------
-- 7.1 NVL(속성, 대체값) : Null이 나오면 대체값으로 변경, 속성과 대체값의 형은 동일해야한다.
select ename, sal, comm, sal*12+comm 제대로X, nvl(comm,0) Null은0으로, sal*12 + nvl(comm,0) 연봉 from emp order by job; -- null은 덧셈해도 0이라서 다른 값이 있어도 null이 됨.

---- 
select empno, ename, nvl(to_char(mgr), 'CEO') MANAGER from emp;

--------------------------------------<8. 조건문 >--------------------------------
-- 1. DECODE(표현식, 조건1, 결과1, 조건2, 결과2 ..., 기본결과) : switch문과 동일
SELECT ENAME, DEPTNO,
        DECODE(DEPTNO, 10, 'ACCOUNTING',
                        20, 'RESEARCH',
                        30, 'SALES',
                        40, 'OPERATIONS' )
        AS DNAME
FROM EMP;
select * from emp;
----- 직급에 따라 급여를 인상. ANAIYST인 사원은 5%, SALESMAN인 사원은 10%, MANAGER인 사원은 15%, CLERK인 사원은 20%dlstkd
select empno, ename, job, sal, 
        decode(job, 'ANAIYST', sal * 1.05,
                    'SALSMAN', sal * 1.1,
                    'MANAGER', sal * 1.15,
                    'CLERK', sal * 1.2,
                    sal)
        AS UPSAL
from emp;

-- 2. case 표현식 when 조건1 then 결과1 when 조건2 then 결과2 ... end :decode가 조건이 일치한 경우에만 적용되지만 case는 다양한 연산자 가능
select ename, deptno,
    case when deptno = 10 then 'ACCOUNTING'
         when deptno = 20 then 'RESEARCH'
         when deptno = 30 then 'SALES'
         when deptno = 40 then 'OPERATOIONS'
    end as DNAME
from emp;

------------------------------------------<<<<<<9. JOIN>>>>>>>----------------------------------
-- 9.1. equi join : 공통되는 컬럼을 일치시키는 조인
select * from emp, dept where emp.deptno = dept.deptno;
select ename, sal from emp, dept where emp.deptno = dept.deptno and lower(loc) = 'new york';
select ename, hiredate from emp, dept where emp.deptno = dept.deptno and dname = 'ACCOUNTING';
select ename, dname from emp, dept where emp.deptno = dept.deptno and  job = upper('manager');

-- 9.2. non-equi join
select * from salgrade;-- 확인용
-- 사원들의 봉급 등급을 확인하라
select ename, sal, grade from emp, salgrade
where sal between losal and hisal; -- 처음에 카티잔프로덕트 되니까

-- 9.3. self join : 자기자신과 조인
---- manager가 king인 사원들의 이름과 직급을 출력하시오 >> king의 empno가 mgr인 사원을 출력
select employee.ename, employee.job 
from emp employee, emp manager
where employee.mgr = manager.empno and manager.ename = 'KING';
----- 다른방법
select employee.ename, employee.job 
from emp employee
where employee.mgr = (select manager.empno from emp manager where manager.ename = 'KING');

---- SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하시오.
select self.ename, friend.ename
from emp self, emp friend
where self.deptno = friend.deptno and self.ename = 'SCOTT' and self.ename <> friend.ename;

-- 9.4 outer join
select employee.ename 사원, manager.ename 상사 --KING의 상사는 없기 때문에 왼쪽에서 나타나지 않음, null인 것도 보고싶으면 outer join
from emp employee, emp manager
where employee.mgr = manager.empno;

-- 9.4.1 left outer join on : ANSI표준 
select employee.ename 사원, manager.ename 상사
from emp employee left outer join emp manager
on employee.mgr = manager.empno;

-- 9.4.2 '(+)': oracle의 outer join, 조인 조건에 null이 포함된 칼럼 이름 뒤에 덧붙임
SELECT employee.ename || '의 매니저는 '
|| manager.ename || '입니다.'
FROM emp employee, emp manager
WHERE employee.mgr = manager.empno(+); -- left outer join

select employee.ename, manager.ename
from emp employee, emp manager
where employee.mgr (+) = manager.empno; -- right outer join

-- 9.5 cross join : categian product
select * from emp cross join dept; -- ANSI형
select * from emp, dept; -- Oracle형

-- 9.6 ANSI Inner join : ANSI JOIN중 하나. equi join과 동일
select ename, dname
from emp inner join dept
on emp.deptno=dept.deptno
where ename = upper('scott');

-- 9.6.2 using(공통속성) :  
select emp.ename, dept.dname
from emp inner join dept
using(deptno);

-- 9.7 natural join : inner join이 기본으로 적용되고 중복된 속성은 제거
select * from emp natural join dept order by deptno;

------------------------------------------<10. 그룹함수>------------------------
-- 10.1. sum, avg, max, min 은 지나감
select max(hiredate) 가장최근사원, min(hiredate) 가장오래된사원 from emp;

-- 10.2. count : Null은 세지 않음
select count(comm) from emp;
select count(comm) from emp where deptno = 10;

---10.3 distinct : 중복값을 제거하고 카운트
select count(distinct job)업무수 from emp;

-- 10.4 group by절
select deptno from emp group by deptno;
select deptno, round(avg(sal), 3) from emp group by deptno;
---- 소속 부서별 최대 급여와 최소 급여를 구하시오
select deptno, max(sal), min(sal) from emp group by deptno;

-- 10.5 having조건: 집계함수의 결과를 제한할 때 사용
---- 집계함수에 대한 조건이므로 where이 아니라 having사용
select deptno, avg(sal) from emp group by deptno having avg(sal)>=2000;

---- 부서의 최대값 최소값을 구하되 최대 급여가 2900이상인 부서만 출력
select deptno, max(sal), min(sal) from emp group by deptno having max(sal) >= 2900;