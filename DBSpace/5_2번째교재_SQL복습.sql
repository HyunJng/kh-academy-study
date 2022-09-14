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

-- 10. desc + table이름 : table의 속성과 데이터타입, 속성 constraint정보 제공
desc dual;
desc emp; -- primary key : not null이면서 unique;


select 