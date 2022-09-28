-- view : 가상(virtual) 테이블
-- 가상테이블이라는 것은 실제 테이블이 아니라, 기존의 다른 테이블을 참조하는 테이블
-- 보고싶은 것(테이블의 일부)만 참조해서 보는 것.
-- view table을 쓰면 좋은점
--  1. 여러개의 원본 테이블에 대하여 동등 join등 
--     복잡한 subquery문을 단순화 시키는 효과
--    >> IT전공자가 아닌 인사팀, 경리팀 직원들이 사용하는데 단순화된S QL문을 사용할 수 있도록
--  2. 보안에 유리함. - 외부스키마로 view를 사용.
--    >> 각 부서마다 적절한 view table을 만들어 제공
create table dept_copy
as
select * from dept;

create table emp_copy
as
select * from emp;

----------------------- 1. create view 생성
-- 1.1 생성문
create view emp_view30
as
select empno, ename, deptno
from emp_copy
where deptno=30;
-- emp_view30을 select를 통해 본다는 뜻은 아래 실행문을 매번 실행한다는 의미
-- select empno, ename, deptno from emp_copy where deptno=30;
select * from emp_view30; -- emp_copy를 참조하는 뷰
select * from emp_copy; -- 원본 

-- 따라서 원본이 변경되면 view도 변경
insert into emp_copy (empno, ename, job, deptno)
values(8200, 'TEST', 'TEST', 30);

select * from emp_copy;  
select * from emp_view30;
-- view는 테이블과 똑같이 select가능
select empno, ename from emp_view30 where ename = 'ALLEN';

create view emp_view20
as
select empno, ename, deptno
from emp_copy
where deptno=20;

-- view안의 text에는 select문이 있는 것을 확인가능
select view_name, text from user_views;

----------------------2. view에 insert
-- 2.1 view에 insert하는 것은 원본 테이블에 insert하는 것과 동일. 나머지에는 null들어감
insert into emp_view30
values(1111, 'AAAA', 30);

select * from emp_view30;
select * from emp_copy;
-- 2.2 만약 나머지 컬럼이 not null과 같은 제약조건이 있다면 error발생
--------------------3. replace
-- 3.1 create or replace(속성이름) : view에는 새롭게 속성이름 생성 가능
--    기존에 없으면 create, 기존에 존재하면 replace함.
create or replace
view emp_view(사원번호, 사원명, 급여, 부서번호)
as
select empno, ename, sal, deptno
from emp_copy;

select * from emp_view;
-- 주의: query문을 작성할 떄 변경된 속성 이름을 사용해야함.
select * from emp_view where 부서번호 = 30;
select * from emp_view where deptno =30; error

create or replace -- sal 삭제, drop 없어도 replace가 자동 됨
view emp_view(사원번호, 사원명, 부서번호)
as
select empno, ename, deptno
from emp_copy;

select * from emp_view where 부서번호 = 30;

--------------------------- 4. Drop view
-- 4.1 drop view : 뷰 삭제
drop view emp_view20;

--------------------------- 5. view에 group 함수 사용
create or replace view view_sal
as
select deptno, sum(sal) as "SalSum", avg(sal) as "SalAvg"
from emp_copy
group by deptno;

-- 5.1 그룹함수에 Alias를 설정하지 않으면 error이 생김
create or replace view view_sal 
as
select deptno, sum(sal), avg(sal)
from emp_copy
group by deptno;

select * from view_sal;
-- 5.2 그룹함수로 만든 view는 insert 불가
-- 이유: view에 insert하는 것은 원본 테이블에 insert하는 것인데, 그룹함수인 경우는 변경된 테이블이라 불가
-- insert외에도 DML(insert, delete, update)불가
insert into view_sal
values(20, 9000, 2800);

-- 5.3 원본 속성에 없는 속성에 insert하는 것은 error
create or replace view emp_annualsal
as
select empno, ename, sal*12 as "AnnualSal"
from emp_copy;

select * from emp_annualsal;

insert into emp_annualsal -- AnnualSal은 원본에 없는 속성이기 때문에 error 
values(2222, 'BBBB', 18000);

--------------------------6. 복합뷰
-- 6.1 복합뷰 생성 : 한번 view생성하면 sql이 훨신 단순해짐
create or replace view emp_view_dept
as
select E.empno, e.ename, e.sal, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
order by empno desc;

select * from emp_view_dept where loc = 'CHICAGO';

------------------------- 7. FORCE옵션
-- force : 원본 테이블이 없더라도 view 생성
-- noforce : 원본 테이블이 없으면 view 생성 불가 << 기본옵션

-- 7.1. force사용 : 사용하지 말기. 있다만 알기.
create or replace force view notable_view
as
select empno, ename, deptno
from employes
where deptno = 30;
-- select 에 error발생
select * from notable_view;

---------------------------- 8. check option
-- 8.1 체크 제약조건 없을경우
create or replace view view_chk30
as
select empno, ename, deptno, sal
from emp_copy
where deptno = 30;

select * from emp_view30;

-- emp_view30의 정의 : deptno = 30인 행들
-- 문제점: update문에 의해서 deptno를 수정할 수 있음 < 결과는 원하는대로 안나옴
update view_chk30 set deptno = 20
where sal >= 1200;

rollback;  -- create or replace view를 해도 commit되어서 rollback안됨

drop table emp_copy;
create table emp_copy
as
select * from emp;

-- 8.2. with check option: 수정할 수 없도록 하는 제약조건
-- view table을 update, delete, insert할 때 많은 문제 야기
-- * 원본 table의 column 데이터들의 일부가 insert되고 나머지는 null되는 것도 문제
-- * 원본 table을 행들을 삭제 수정할 수 있는 것이 문제.
-- * view table을 사용하는 가장 큰 목적은 select SQL명령어 사용하기 위함.
create or replace view view_chk30
as
select empno, ename, sal, comm, deptno
from emp_copy
where deptno = 30
with check option; -- deptno를 수정할 수 없도록 하는 제한조건

select * from view_chk30;

update view_chk30 set deptno = 20 -- error. deptno를 변경하려 함
where sal >= 1200;

update view_chk30 set comm = 1000;
----------------------- 9. with read only
rollback;
-- 9.1 with read only : view테이블을 DML(insert, update, delete)불가
create or replace view view_read30
as
select empno, ename, sal, comm, deptno
from emp_copy
where deptno = 30
with read only;

select * from view_read30;

update view_read30 set comm=1000; -- error
insert into view_read30
values(1234, 'TEST', 1300, 20, 30);-- error
------------------------- 10. INLINE view
-- 10.1 rownum특성
select rownum, empno, ename, hiredate from emp;

select rownum, empno, ename, hiredate from emp -- 순서 바뀌어 있음
order by hiredate desc;

-- rownum은 order by에 영향 안받으므로 from에서 inline subquery사용
select rownum, empno, ename, hiredate
from (select * from emp order by hiredate desc)
where rownum <= 3;

-- 10.2 view table에서 rownum사용
-- 원본 테이블에서 subquery에서 order by 등을 사용하여 view table을 생성하면
-- order by가 적용된 새로운 rownum을 생성
create or replace view view_hire
as
select empno, ename, hiredate
from emp
order by hiredate;

select rownum, v.* from view_hire v;
