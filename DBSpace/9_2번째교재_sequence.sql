select * from orders; -- orderid
select * from book; -- bookid 이 번호를 입력할때 직접 입력했음. 
-- 1. sequence: book table의 primary key인 bookid처럼 unique한 숫자를 자동 생성해주는 것
create sequence dept_deptno_seq
increment by 10
start with 10;
drop sequence dept_deptno_seq;

-- 2. sequence와 관련된 data dictionary
desc user_sequences;
select * from user_sequences;
-- 3.1 nextval : sequence의 다음값을 가져옴(sequence에서 최초로 사용할 경우는 최초값 가져옴)
select dept_deptno_seq.nextval from dual;
-- 3.2 curval: 현재 sequence값
select dept_deptno_seq.currval from dual;

-- 4. sequence 예시
-- 4.1 기본
create sequence emp_seq
start with 1
increment by 1
maxvalue 10000;

drop table emp01;

create table emp01(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR(10),
hIREDATE DATE
 );

select * from emp01;

insert into emp01
values(emp_seq.nextval, 'JULIA', sysdate);
 insert into emp01
 values(emp_seq.nextval, 'SCOTT', sysdate);
 insert into emp01
 values(emp_seq.nextval, 'JAMES', sysdate);
 
 -- 4.2 sequence가 10씩 증가
create sequence dept_seq
start with 10
increment by 10
maxvalue 10000;

create table dept_example(
deptno number(4) primary key,
dname varchar(15),
loc varchar(15)
);

insert into dept_example
values(dept_seq.nextval, 'AAA', 'AAAA');
insert into dept_example
values(dept_seq.nextval, 'BBB', 'BBBB');
insert into dept_example
values(dept_seq.nextval, 'CCC', 'CCCC');

select * from dept_example;
-- 5. drop
drop sequence dept_seq;

-- 6. sequence 수정
drop sequence dept_deptno_seq;
create sequence dept_deptno_seq
start with 10
increment by 10
maxvalue 30;

select dept_deptno_seq.nextval from dual; -- max가너무 적음

alter sequence dept_deptno_seq
maxvalue 1000;

--확인
select sequence_name, max_value, increment_by, cycle_flag
from user_sequences;