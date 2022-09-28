-- 1. store procedure (Procedure: java에서 method와 return type이 void인 경우)
drop table emp01;

create table emp01
as
select * from emp;

select * from emp01;

-- procedure를 데이터베이스에 저장하는 명령어
@C:\Users\1\Desktop\Coding_Study\KHclass_Java\DBSpace\procedure01.sql; 

-- 저장된 프로시져의 이름으로 실행
execute del_all;
rollback;

-- error를 보고 싶으면 이 명령어 쓰면 된다.
show error;

-- 저장 프로시져 조회
desc user_source;
select name, TEXT from user_source;

---------------------------[procedure2]-----------------------------------
drop table emp01;

create table emp01
as
select * from emp;

select * from emp01;

@C:\Users\1\Desktop\Coding_Study\KHclass_Java\DBSpace\procedure02.sql; 

execute del_name('SMITH');

select * from emp01;
rollback;
--------------------------[procedure3]---------------------------------
@C:\Users\1\Desktop\Coding_Study\KHclass_Java\DBSpace\procedure03.sql; 

variable var_ename varchar2(15);
variable var_sal number;
variable var_job varchar2(9);

execute sel_empno(7788, :var_ename, :var_sal, :var_job); -- in은 그대로 씀, out은 :변수이름 으로 해야함

print var_ename;
print var_sal;
print var_job;

--------------------------[Function]----------------------
-- procedure : 없음
-- function : return 타입이 있음
@C:\Users\1\Desktop\Coding_Study\KHclass_Java\DBSpace\function01.sql; 

variable var_res number;

execute :var_res := cal_bonus(7369);

print var_res;
-- function은 select문에도 넣을 수 있다.
select sal, cal_bonus(7369)
from emp
where empno = 7369;

-----------------------------[cursor(커서)]--------------------------
-- cursor : 여러 행을 가져올 때 사용
select * from emp;
select * from book;
select bookname, publisher price from book where bookname like '%축구%';

create or replace procedure cursor_sample01
is
    vdept dept%rowtype; -- row전체를 타입으로 지정
    cursor c1 -- c1 : cursor변수 이름
    is
    select * from dept; -- cursor은 select문으로 지정
begin
    dbms_output.put_line('부서번호 / 부서명 / 지역명');
    dbms_output.put_line('-------------------------');
    open c1; -- c1으로 정의된 select문을 실행(select * from dept)
    loop
        fetch c1 into vdept.deptno, vdept.dname, vdept.loc; --fetch는 한행씩 조회/제거
        exit when c1%notfound; -- 발견되지 않으면 loop나옴
        dbms_output.put_line(vdept.deptno||
            ' ' || vdept.dname|| ' ' || vdept.loc);
    end loop;
    close c1; -- open과 짝.
end;
/
execute cursor_sample01;
---------------------[cursor2: 더 자주 쓰임]-----------------------------------
set serveroutput on;

create or replace procedure cursor_sample02
is
    vdept dept%rowtype;
    cursor c1
    is
    select * from dept;
begin
    dbms_output.put_line('부서번호 / 부서명 / 지역명');
    dbms_output.put_line('------------------------');
    for vdept in c1 loop
        exit when c1%notfound;
        dbms_output.put_line(vdept.deptno||
            ' ' || vdept.dname|| ' '||vdept.loc);
    end loop;
end;
/

execute cursor_sample02;