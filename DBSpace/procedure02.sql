create or replace procedure
del_name(vename emp01.ename%type) --in 생략
-- del_name(vename in emp01.ename%type) -- in : 밖에서 받는다는 뜻
-- del_name(vename out emp01.ename%type) -- out : 밖에서 쓴다는 것
is
begin
    delete from emp01 where ename = vename;
end;