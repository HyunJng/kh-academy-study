---------------------<컬럼레벨로 제약조건 지정>---------------------
---------- 1. NOT NULL 제약조건
-- 1.1 NOT NULL: 반드시 입력하는 컬럼, 중복은 허용
create table emp01(
empno number(4) NOT NULL,
ename varchar2(10) NOT NULL,
job varchar2(9),
deptno number(2)
);

insert into emp01 -- ERROR
values(null, null, 'SALESMAN', 10);

desc emp01;

---------------- 2. UNIQUE 제약조건
-- 2.1 unique : 중복되는 로우가 없는 컬럼, 단 NULL은 입력과 중복 가능
create table emp03(
-- UNIQUE의 constraint name : SYS_C007017 (오라클에서 자동 생성)
empno number(4) UNIQUE,
ename varchar2(10) not null,
job varchar2(9),
deptno number(2)
);
desc emp03;
insert into emp03
values(7499, 'ALLEN', 'SALESMAN', 30);
insert into emp03 -- error
values(7499, 'ALLEN', 'SALESMAN', 30);

insert into emp03
values(null, 'JONES', 'MANAGER', 20);
insert into emp03
values(null, 'JONES', 'MANAGER', 20);

select * from emp03;
------------------- 3. CONSTRAINT 이름부여
-- 3.1 view를 이용하여 constraints 이름 확인
select constraint_name, constraint_type, table_name from user_constraints;

-- 3.2 constraint + constraint이름 + constraint타입
create table emp04(
empno number(4) constraint emp04_empno_uk UNIQUE,
ename varchar2(10) constraint emp04_ename_nn not null,
job varchar2(9),
deptno number(2)
);

insert into emp04
values(7499, 'ALLEN', 'SALESMAN', 30);
insert into emp04 -- error이름으로 EMP04_EMPNO_UK 출력
values(7499, 'ALLEN', 'SALESMAN', 30);

------------------ 4. PRIMARY KEY 제약조건
-- 4.1 primary key : unique + not null인 컬럼
create table emp05(
empno number(4) constraint emp05_empno_pk PRIMARY KEY,
ename varchar2(10) constraint emp05_ename_nn NOT NULL,
job varchar2(9),
deptno number(2)
);

insert into emp05
values(7499, 'ALLEN', 'SALESMAN', 30);
insert into emp05 -- error
values(7499, 'ALLEN', 'SALESMAN', 30);
insert into emp05 -- error
values(Null, 'JONES', 'SALESMAN', 30);

-------------------- 5. FOREIGN KEY 제약조건
-- 5.1 references 부모테이블(부모컬럼) : 제약조건에 넣음. 컬럼 이름은 동일하게 하는 것을 권장
create table emp06(
empno number(4) constraint emp06_empno_pk primary key,
ename varchar2(10)constraint emp06_ename_nn not null,
job varchar2(9),
deptno number(2) constraint emp06_depno_fk references dept(deptno)
);

insert into emp06
values(7499, 'ALLEN', 'SALESMAN', 30);

insert into emp06 -- 오류: 50이 부모 키의 도메인에 없음 
values(7566, 'JONES', 'MANAGER', 50);

select * from emp06;

------------------ 6. CHECK 제약조건
-- 6.1 check(컬럼이름 제약조건) : 조건에 맞아야 insert가능
create table emp07(
empno number(4) constraint emp07_empno_pk primary key,
ename varchar2(10)constraint emp07_ename_nn not null,
sal number(7, 2) constraint emp07_sal_ck check(sal between 500 and 5000),
gender varchar2(1) constraint emp07_gender_ck check(gender in('M', 'F'))
);
desc emp07;

insert into emp07 -- check에러, sal이 200이라 안됨
values(7499, 'ALLEN', 200, 'M');

insert into emp07 -- check에러, gender이 A 라서 안됨
values(7499, 'ALLEN', 2000, 'A');

insert into emp07
values(7499, 'ALLEN', 2000, 'M');

----------------- 7. DEFAULT 제약조건
-- 7.1 default 디폴트할값 : null로 isnert하면 defualt값으로 자동 지정. null이 생기지 않도록 함
create table dept01(
deptno number(2) primary key,
dname varchar2(14),
loc varchar2(13) default 'SEOUL'
);

insert into dept01 (deptno, dname)
values(10, 'ACCOUNTING');

select * from dept01;
--------------------------<테이블레벨로 제약조건 지정>--------------------
-------------------------- 더 표준적인 방법 ----------------------
-- 반드시 테이블레벨로 해야하는 경우
-- 1. PK를 복합키로 지정하고싶을 때, 
-- 2. ALTER TABLE로 제약조건 추가할 때
-- *단, not null은 컬럼 레벨로만 지정 가능
drop table emp01;

------------------------ 1. create 시 지정방법 기초
-- 1.1. create 시에 지정 방법
create table emp01(
empno number(4),
ename varchar2(10) not null,
job varchar2(9),
deptno number(4),
--- table level constraints 지정방법
primary key(empno),
unique(job),
foreign key(deptno) references dept(deptno)
);
drop table emp03;

-- 1.2 constraint 이름 지정
create table emp03(
empno number(4),
ename varchar2(10) constraint emp03_ename_nn not null,
job varchar2(9),
deptno number(4),
--- table level constraints 지정방법
constraint emp03_empno_pk primary key(empno),
constraint emp03_job_uk unique(job),
constraint emp03_deptno_fk foreign key(deptno) references dept(deptno)
);

----------------------- 2. 복합키(composite key) 지정
-- 2.1 복합키 : primarykey로 여러개의 column 지정
create table member01(
name varchar2(10),
address varchar2(30),
hphone varchar2(16),
constraint member01_combo_PK primary key(name, hphone) --복합키
);
-- 어떤 컬럼이 pk에 포함되는지는 보이지 않음
select constraint_name, constraint_type, table_name from user_constraints;
-- 보고싶으면
select * from user_cons_columns where table_name='MEMBER01';

------------------------ 2. ALTER 시 지정 방법
drop table emp01;
create table emp01(
empno number(4), -- primary key
ename varchar2(10), -- not null
job varchar2(9),
deptno number(4) -- foreign key
);
-- 2.1 primary key, foreign key 지정: add 사용
alter table emp01
add constraint emp01_empno_PK primary key(empno);

alter table emp01
add constraint emp01_empno_fk foreign key(deptno) references dept(deptno);
-- 2.2 not null 지정: modify를 사용
alter table emp01
modify ename constraint emp01_ename_nn not null;

select constraint_name, constraint_type, table_name from user_constraints;

-------------------- 3. 제약조건 삭제
-- 3.1. alter table drop 이용한 삭제
alter table emp05
drop constraint emp05_empno_pk;

alter table emp05
drop constraint emp05_ename_nn;

select constraint_name, constraint_type, table_name from user_constraints;

---------------------------넘어간부분 ppt보기-------------------------------
-- 회사에서 DB 관련 새로운 시스템 개발
-- 예: shopping system(application) 한국만-> 전세계 web appllication
-- 1. data migration
--  - 기존 application에서 사용했던 테이블과 테이블 안의 data를 새로운 applicatoin의 테이블로 옮겨야함.
--  - 기존 colum에 없던 제약조건을 추가하면 제약조건에 안 맞는 로우가 생겨 에러 발생
--  - migration을 위해 새로운 시스템의 제약조건을 비활성화 가능
---------------------------------------------------------------------------


