-- 반복문

-- 1. basic loop문
set serveroutput on

declare
    n number := 1;
begin -- loop와 if 둘 다 end 해줘야함.
    loop
    dbms_output.put_line( n );
    n := n+1;
    if n > 5 then 
    exit;
    end if;
    end loop;
end;
/
-- 2. while문
set serveroutput on
declare
    n number := 1;
begin
    while n <= 5 loop
        dbms_output.put_line(n);
        n := n+1;
    end loop;
end;
/
-- 다음 procedure배움