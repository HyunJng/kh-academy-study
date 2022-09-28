-- record 연습
set serverout on

declare
    type emp_record_type is record( -- record : 구조체
        v_empno emp.empno%type,
        v_ename emp.ename%type,
        v_job emp.job%type,
        v_deptno emp.deptno%type
    );
    emp_record emp_record_type; -- 변수 선언
begin
    select empno, ename, job, deptno into emp_record
        from emp
        where upper(ename) = 'SMITH';
        
    dbms_output.put_line('사원번호 : ' || to_char(emp_record.v_empno)); -- int형은 char로 바꿔서 출력
    dbms_output.put_line('이   름: ' || emp_record.v_ename);
    dbms_output.put_line('담당업무: ' || emp_record.v_job);
    dbms_output.put_line('부서번호: ' || emp_record.v_deptno);
end;
/