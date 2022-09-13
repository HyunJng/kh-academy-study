-- DDL (Data Definition Language) : 데이터 정의어
-- Oracle은 mySQL과 달리 속성이름 다음에 데이터타입이 들어감
-------------------------- 테이블 생성 ------------------------------
-- 1. 한 세트(삭제, 생성)를 만들어놔야함
-- newbook table 삭제
drop table newbook;
-- newbook table 생성
create table NewBook(
    bookid  number,
    bookname    varchar2(20),
    publisher   varchar2(20),
    price   number
);
select * from newBook;

-- 2. 기본키 지정(2가지)
-- primary key에 들어가는 속성이 여러게 존재하면 반드시 별도로 primary key를 선언(윗 방법)해야한다.
create table NewBook(
    bookid  number,
    bookname    varchar2(20),
    publisher   varchar2(20),
    price   number,
    primary key(bookid)
);
create table NewBook(
    bookid  number primary key,
    bookname    varchar2(20),
    publisher   varchar2(20),
    price   number
);
-- 3. 제약사항(constraints) 추가: not null, unique, default, check
drop table newbook;
create table NewBook(
    bookid varchar(20) not null, -- 속성값으로 null가능, 중복 가능
    bookname    varchar2(20) not null, -- 속성값으로 null을 입력하면 error발생, 
    publisher   varchar2(20) unique, --속성값이 다른행의 값과 중복되면 error발생.
    price   number default 10000 check(price > 1000),  -- 속성값으로 null이 입력되면 기본 값 10000을 저장, 최소 1000원 이상 되지 않으면 error발생.
    primary key(bookname, publisher) -- 두 개의 속성 bookname, publisher가 기본키. 복합키.
);

-- 4. 외래키(Forign key) : 속성 중 하나, 아래 예시는 자식이 삭제되면 부모도 삭제한다는 뜻.
CREATE TABLE NewOrders (
orderid NUMBER,
custid NUMBER NOT NULL,
bookid NUMBER NOT NULL,
saleprice NUMBER,
orderdate DATE,
PRIMARY KEY (orderid),
FOREIGN KEY (custid) REFERENCES NewCustomer(custid) ON DELETE CASCADE );

-- 5. create문
-- 6. alter문
-- 7. drop문

