drop table dept01;

create table dept01
as
select * from dept;

select * from dept01;

delete from dept01;
select * from dept01;
rollback;

-- Auto commit : commit 명령어를 사용하지 않아도 자동 commit이 되는 경우
-- 1. insert/update/delete등 DML 명령어와 CREATE, ALTER, DROP,  RENAME, TRUCATE를 사용하면
--    insert/update/delete한 내용을 rollback으로 복귀할 수 없음.

drop table dept02;
create table dept02
as
select * from dept;

select * from dept02;
delete from dept02 where deptno = 40; 

drop table dept03;

create table dept03
as
select * from dept; 

rollback;  -- 지운 것이 다시 돌아오지 않는다. dept03을 create했기 때문
--------------------------------------
drop table dept03;

create table dept03
as
select * from dept; 

delete from dept03 where deptno = 20;

select * from dept03;

truncate table depttttt;
rollback; -- truncate가 오류나도 auto commit 되어 rollback이 안돼, deptno=20인 행은 안 돌아온다.
----------------------------------------
-- save point실습
drop table dept01;

create table dept01
as
select * from dept;

-- 1. deptno 가 40인 행을 삭제하고 commit
delete from dept01 where deptno = 40;
commit;
select * from dept01;
rollback; -- 안 돌아옴
-- 2. deptno 가 30인 행을 삭제
delete from dept01 where deptno = 30;

-- 3. savepoint c1 지정
savepoint c1;

-- 4. deptno 가 20인 행을 삭제
delete from dept01 where deptno = 20;

-- 5. savepoint c2지정
savepoint c2;

-- 6. deptno가 10인 행을 삭제
delete from dept01 where deptno = 10;

select * from dept01;

-- 7. c2로 rollback;
rollback to c2; -- (6)이 취소

-- 8. c1로 rollback;
rollback to c1; -- (4)까지 취소

-- 9. rollback수행
rollback; -- (2)취소