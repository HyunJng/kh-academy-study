-- PL/SQL : Oracle's Procedural Language extension to SQL
-- PL: 절차 언어는 통상 C언어를 의미(Java : OOP)
-- SQL명령어를 사용해서 if/while 제어문 변수 선언 등을 사용하여 코딩할 수 있다.

---------------------<1. 기본설정>-------------------
-- 1.1 오라클 PL/SQL로 짠 프로그램 결과값을 console에 출력하려고 설정하는 명령어.
--     디폴트가 off임
set serveroutput on

begin -- ='('
-- 1.2 dbms_output.put)line : System.out.println과 같은 기능
--    ** 명령어마다 끝에 ';'을 붙여야한다.
dbms_output.put_line('Hello World!');
end; -- = ')'
/
-- 1.3 / : PL/SQL 프로그램이 종료된다는 기호

----------------------<2. 변수선언>------------------------
-- 2.1 declare : 변수 선언할 떄 사용하는 키워드
-- v + table의 컬럼이름
-- = 은 :=임
-- declare ~ begin ~ end;/ 뼈대 만든 뒤 작성하면 좋다.

-- 2.2 스칼라변수 선언
set serveroutput on
declare
-- 변수이름 변수데이터타입
    vempno number(4); -- 스칼라 변수 : 직접선언
    vename varchar2(10);
begin
    vempno := 7788;
    vename := 'SCOTT';
    dbms_output.put_line('사번 / 이름');
    dbms_output.put_line('-------------------');
    dbms_output.put_line(vempno || '/' || vename);    
end;
/


-- 2.3 레퍼런스변수 선언(추천)
-- 2.3.1 type : 칼럼단위로 데이터 타입 참조
declare
    vempno emp.empno%type; -- 레퍼런스 변수
    vename emp.ename%type;
begin
    vempno := 7788;
    vename := 'SCOTT';
    dbms_output.put_line('사번 / 이름');
    dbms_output.put_line('-------------------');
    dbms_output.put_line(vempno || '/' || vename);    
end;
/

-- 2.3.2 %rowtype: 행 단위로 데이터 타입 참조
-- vemp를 emp(table)로 선언하면 emp 테이블에 있는 모든 컬럼을 선언한 것과 동일한 효과를 가짐
-- ex) vemp emp%rowtype 은 vempno emp.empno $type, vename emp.ename%type ...vdeptno emp.deptno%type 과 같다.
declare
    vempno emp.empno%type;
    vename emp.ename%type;
begin
    dbms_output.put_line('사번 / 이름');
    dbms_output.put_line('------------------');
    select empno, ename into vempno, vename
        from emp
        where ename = 'SMITH';
    dbms_output.put_line(vempno || ' / ' || vename);
end;
/

------------------------------