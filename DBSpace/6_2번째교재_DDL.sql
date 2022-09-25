SELECT rowid, empno, ename from emp;
----------------1. CREAT
-- 1.1 create : 기본
create table emp01(
empno number(4),
ename varchar2(20),
sal number(7,2)
);

desc emp01;

-- 1.2 create: 복사
create table emp02
as
select * from emp;

desc emp02;

-- 1.3 create : 일부 행만 복사
create table emp03
as
select empno, ename from emp;

desc emp03;
select * from emp03;
-- 1.3 create : where절 추가
create table emp05
as
select * from emp
where deptno = 10;

select * from emp05;

-- 1.4 create : 테이블의 구조만 복사
create table emp06
as
select * from emp
where 1=0; -- 항상 거짓. 가져오는 row가 없음

select * from emp06;

-------------------2. ALTER
-- 2.1 alter table add : 새로운 컬럼 추가
alter table emp01
add(job varchar2(9));

select * from emp01;
-- 2.2 alter table modify: 존재하는 컬럼 수정
alter table emp01
modify(job varchar2(30));

desc emp01;

-- 2.3 alter table drop column: 존재하는 컬럼 삭제
alter table emp01
drop column job;

desc emp01;

-- 2.4 set unused옵션 : drop column대신
alter table emp02
set unused(job);

desc emp02;

------------- 3. DROP
-- 3.1 drop table : 테이블 전체 삭제
drop table emp01;

------------- 4. TRUNCATE
-- 4.1 truncate table: 테이블의 모든 로우 제거
truncate table emp02;
select * from emp02;

------------- 5. RENAME
-- 5.1 rename ~ to ~ : 테이블의 이름을 변경
rename emp02 to test;
select * from test;

