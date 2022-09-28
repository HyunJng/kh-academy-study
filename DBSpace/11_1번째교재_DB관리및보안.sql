-- 데이터베이스의 보안과 관리
--  -DBA(Data Base Administrator)의 일
--  >> 일반 개발자의 역할은 아니다.

-- p8. login을 통해서 DBMS사용하기 위한 접근제한(authorization)
--     사용자별로 특정자원(테이블)의 접근 제한(authentication)

-- system 계정에서 할 것
-- 1. table space만들기 : 오라클에서 테이블을 저장할 때 사용하는 논리적 저장공간 
create tablespace md_tbs
    datafile 'C:\oraclexe\app\oracle\oradata\XE\md_tba_data01.dbf'
    size 10M;

create tablespace md_test
    datafile 'C:\oraclexe\app\oracle\oradata\XE\md_test_data01.dbf'
    size 10M;
-- including contents: dbf 파일 안에 있는 모든 ocntents를 제거하고, datafiles: md_test_data.dbf 자체를 삭제
drop tablespace md_test
    including contents and datafiles;

-- 2. 사용자 계정 생성
-- 2.1 계정 생성
create user mdguest -- 아이디
        identified by mdguest; -- password
        
-- 2.2 계정생성과 table과 연결
create user mdguest2
    identified by mdguest2
    default tablespace md_tbs;
    
 -- 생성한 계정으로는 테이블 생성시 로그인 안됨. 테이블 생성권한을 만들어줘야함.
 -- 3. 권한부여(DCL중 하나에 해당)
 --     - connect : session(login접속 권한)
 --     - resource 권한: create table, create index 의 권한 부여
 --     - sys admin 계정이 mdguest사용자에게 권한을 부여하는 것
 grant connect, resource to mdguest;
 grant connect, resource to mdguest2;
 
 -- 4. 계정 삭제
 drop user mdguest cascade;
 ------------------------<위까지는 system계정/ 아래부턴 madang계정>----------
 -- 1.1 mdguest 계정에서 madang의 book table select
 select * from madang.book; --안됨
 -- 1.2. madang이 mdguest에게 book table에 select 권한 부여
 grant select on book to mdguest;
 -- 1.3. mdguest에서도 select성공
 select * from madang.book;
 
 -- 2.1
 select * from madang.customer; -- 실패 
 -- 2.2 customer table에 대하여 select, update 권한을 mdguest에 부여
 --    with grant option: mdguest가 madang으로부터 부여받은 권한을 다른 사용자에게 권한 부여 할 수 있도록 승인
 grant select, update on customer to mdguest with grant option;
 -- 2.3 mdguest가 mdguest2에게 madang customer에 대한 권한부여
 grant select, update on madang.customer to mdguest2;
 -- 2.4 mdguest2에서 권한 확인
 select * from madang.customer;
 
 -- 3.1 madang계정에서 모든 사용자에게 orders table의 select에 대한 권한 부여
 grant select on orders to public;
 -- 3.2 mdguest에서 orders select 수행
 select * from madang.orders;
 
 -- 4.1 revoke : madang계정에서 권한 철회
 revoke select on book from mdguest;
 -- 4.2 mdguest에서 book select 권한 없는 것을 확인
 select * from madang.book; -- error
 
 ----------------------------------------------
 -- 백업 : DB에서 전혀 예상하지 못한 장애에 대비하여 DB를 복제하여 보관하는 작업
 -- - 최소 1일에 1번(회사규모가 아주 큰 경우는 1일 2~3회)
 
 
 
 