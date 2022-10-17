-- error. deptno가 unique constraint이기 때문에 deptno= 10이 중복이라 넣을 수 없다.
insert into dept
values(10, 'TEST', 'SEOUL'); 

select * from dept;
-- deptno가 not null만 확인되고 있음.
desc dept;
-- data dictionary : user_tables(테이블에 대한 정보), user_constraints (data integrity(객체)정보 관리)
-- >> user_constraints의 constratin_type : P(primary key), R (foreign key)
-- >> 한계 : 어느 테이블에 primary key, foreign key가 존재하는 지는 알려주지만 
--          어느 column이 primary key, foreign key인지에 대한 정보는 없음
select constraint_name, constraint_type, table_name from user_constraints;

-- user_cons_columns : primary key, foreign key가 table의 어느 column에 지정되어있는지 확인 가능
desc user_cons_columns;
select * from user_cons_columns;
select * from user_cons_columns where constraint_name like ('%PK%');
select * from user_cons_columns where constraint_name like ('%FK%');

-- A. Not Null constraints
drop table emp01;

create table emp01(
empno number(4),
ename varchar2(10),
job varchar2(9),
deptno number(2)
);

select * from emp01;

insert into emp01
values(null,null, 'SALESMAN', 30); -- PK 지정 안했기 때문에 null이 들어감

drop table emp02;
create table emp02(
empno number(4) not null,
ename varchar2(10) not null,
job varchar2(9),
deptno number(2)
);

insert into emp02
values(null,null, 'SALESMAN', 30); -- not null지정해주었기 때문에 constraint 오류

insert into emp02
values(7839, 'BLACKE', 'SALESMAN', 30);

select * from emp02;

insert into emp02
values(7839, 'SCOTT', 'CLERK', 40); -- EMPNO가 중복 삽입이 가능함. 이것도 제한해주어야함.