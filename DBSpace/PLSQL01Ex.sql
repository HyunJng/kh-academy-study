set serveroutput on

declare
    -- 테이블 타입(Java에서 array)을 선언         int[] arr = new int[100];
    type ename_table_type is table of emp.ename%type index by binary_integer;
    type job_table_type is table of emp.job%type index by binary_integer;
    ename_table ename_table_type;
    job_table job_table_type;
    i binary_integer := 0;
begin
    -- emp 테이블에서 사원명과 직급을 얻어옴
    for k in(select ename, job from emp) loop
        i := i + 1;
        ename_table(i) := k.ename;
        job_table(i) := k.job;
    end loop;
    
    -- 테이블 변수에 저장되는 값 출력
    for j in 1..i loop
        dbms_output.put_line( rpad(ename_table(j), 12) || ' / ' ||
            rpad(job_table(j), 9) );
    end loop;
end;
/
---------------------------------for문 연습-----------------------
set serveroutput on

declare
begin
    for n in 1..5 loop
    dbms_output.put_line( n );
    end loop;
end;
/
-------------------------------------------------------------------
-- pl/sql 문 실행 @ 키워드 사용
@C:\Users\1\Desktop\코딩 공부\KHclass_Java\DBSpace\PLSQL01Ex.sql;

@C:\Users\1\Desktop\코딩 공부\KHclass_Java\DBSpace\PLSQL02Ex.sql;

@C:\Users\1\Desktop\코딩 공부\KHclass_Java\DBSpace\PLSQL03Ex.sql;
--------------------------------------------------------
