-- elsif문 연습
set serveroutput on

declare
    vempno number(4);
    vename varchar2(20);
    vdeptno emp.deptno%type;
    vdname varchar2(20) := null;    
begin
    select empno, ename, deptno into vempno, vename, vdeptno
        from emp
        where empno = 7369;
    if(vdeptno = 10) then 
         vdname := 'ACCOUNTING';
    elsif(vdeptno = 20) then 
        vdname := 'RESEARCH';
    elsif(vdeptno = 30) then 
        vdname := 'SALES';
    elsif(vdeptno = 40) then 
        vdname := 'OPERATIONS';
    end if;   
    dbms_output.put_line('사번    이름    부서명');
    dbms_output.put_line(vempno || ' ' || vename || ' ' || vdname);
end;
/