-- cpu가 (main) memory에 write하는데 걸리는 시간 : 몇백 ns
-- cpu가 하드디스크에 wrtie하는데 걸리는 시간 : 1 ~ 10 ms
-- >> 최대 100만배 정도 차이

-- index : 데이터 테이블
select rowid, emp.* from emp;
-- index사용목적 : select문을 사용하여 검색 속도를 높이는데 목적
-- customer : 고객 수가 늘어날수록 속도를 느려짐. 속도문제를 해결할 떄 index를 사용
-- tree: data를 오름차순 정렬 형태로 저장을 함.
-- 오라클은 B-tree를 사용해서 index를 관리
-- insert할 때 마다 b-tree를 업데이트 << 오라클이 알아서 해줌
-- 단점: index를 위한 추가 공간이 필요해짐.(메모리 잡아먹고, 필요하면 하드디스크에도 저장)
--      변경작업(insert/update/delete)가 자주 일어나는 경우는 오히려 성능이 저하된다.
-- index 생성: 금융권, 고객이 많고 검색속도 등의 성능이 고객 서비스의 핵심일 때 생성
--            원인 분석해서 인덱스를 만들더라도 검색 속도가 제대로 나오지 않은 경우가 많음
--            그래서 전문가에게 맡김. 우리같은 일반 개발자가 함부로 인덱스를 만들지 않은 것이 좋다.
-- index는 언제 만드나?
-- - 개발단계에서는 만들지 않음
-- - 시스템을 개발완료 후 운영하면서 속도가 늦어지는 경우 속도가 늦어지는 ㅜㅇ너인 분석 후에 인덱스 생성
-- - where조건 등에서 특정 컬럼이 ㅁ낳이 사용되는 경우에 인덱스 생성>>운영하면서 파악


-- 1. user_ind_columns : data dictionary table
-- table을 생성할 때 primary key로 선언하면 오라클이 자동으로 index설정
-- 즉, primary key로 선언하면 B-tree가 내부적으로 만들어짐
-- 그래서 primary로 검색하면 검색속도가 빠르다.
select index_name, table_name, column_name
from user_ind_columns
where table_name in('EMP', 'DEPT');

desc user_cons_columns;

select constraint_name, table_name, column_name
from user_cons_columns
where table_name in('EMP', 'DEPT');

-- where조건문에서 primary key의 검색 속도가 더 높다.
select * from emp where empno = 7902; 
select * from emp where sal = 3000;

-- 2. 실습
drop table emp01;
-- sub쿼리를 사용하여 table을 복사할 때는 우너본 데이터의 구조와 데이터는 복사되지만,
-- 제약조건은 복사되지 않기 떄문에 index도 복사되지 않는다.
create table emp01
as
select * from emp;

select * from emp01;

select table_name, index_name, column_name
from user_ind_columns
where table_name in('EMP', 'EMP01');

insert into emp01 -- 개수 늘려주기 40만개까지
select * from emp01;

select * from emp01;
-- 검색용 행 생성
insert into emp01(empno, ename)
values(1111, 'SYJ');

set timing on;
-- index없이 검색하면 0.021초 걸림
select distinct empno, ename
from emp01
where ename = 'SYJ';
-- index생성 : emp01테이블의 ename컬럼에 index생성
-- create index 명령어를 통해 B-tree를 오라클 내부적으로 만듬.
create index IDX_EMP01_ENAME
on emp01(ename);

-- index로 실행하면 0.005초 걸림
select distinct empno, ename
from emp01
where ename = 'SYJ';

-- 3. index 삭제
drop index idx_emp01_ename;

-- 4. delete 문을 많이 실행하고 난 다음에       -- 쓸 일 없음. 알아만두기
--    rebuilt 사용 : B - tree를 다시 정리하여 만들때 사용
alter index idx_emp01_deptno rebuild;
