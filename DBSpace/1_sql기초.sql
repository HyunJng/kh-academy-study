-- comment
-- SQL 명령어가 끝나는 기호는 ;
-- SELECT : 테이블 데이터 조회하는 SQL명령어
-- * : 모든 속성 정보를 가져오라는 의미
-- FROM customer : customer 테이블로부터 (from + 테이블)
SELECT * FROM customer;

-- 1.selection명령어(sigma 명령어 : 행을 선택하는 명령어)
--      "where + 조건문" 형태로 표현
-- 한줄 실행 단축키 ctrl + enter
-- 처음은 FROM customer부터 실행한 후, for문을 돌아 조건 맞는걸 찾아서 보여줌
SELECT * FROM customer WHERE custid >= 3;

-- 2. projection 명령어 : 속성을 선택하는 명령어
--      -> select name, address  (select + 원하는 속성 이름)
select name, address from customer where custid>=3;

-- 자바에서는 String은 ""였지만 SQL은 ''임
select phone from customer where name='김연아';

-- 3. distict : 중복을 없애주는 명령어
select distinct publisher from book;

-- 4. 비교연산자 : =(한개인거 주의), <>(!=와 동일), <-, >, >-
-- > BETWEEN 10000 AND 20000  : 10000=- price <= 20000 와 동일한 의미( = 포함된 것 주의)
-- > price IN(100000, 20000, 30000) : price = 10000 or price =20000 or price=
-- > bookname LIKE '축구의 역사' : 어느 문자열이 포함되어 있는지 체크할 때 사용
-- > AND, OR, NOT : 말그대로.

-- 5. 와일드문자(wild character)
-- > % : 0개 이상의 문자열과 일치. 자리에 무슨 단어가 와도 된다는 뜻.
--      ex) where booname like'%축구%': __축구__인 책을 찾으라.
-- > _ : 특정 위치의 1개의 문자와 일치.
--      ex) where bookname like '_구%': 두번쨰 문자가 '구'인 책을 찾으라.
-- > []: 1개이 문자와 일치
--      ex) where bookname like '[0-5]%': 0-5 사이의 숫자로 시작하는 문자열
-- > [^]: 1개의 문자와 불일치
--      ex) where bookname like '[^0-5]%': 0-5 사이의 숫자로 시작하지 않는 문자열
-- > + : 문자열을 연결

-- 6. 정렬
-- > order by : 기본이 오름차순 정렬
--      ex) select * from book order by price, bookname : price로 정렬한뒤 같으면 bookname으로 정렬
--  - 내림차순으로 하고 싶으면 DESC, 오름차순은 ASC
--      ex) order by price DESC, bookname ASC : price는 내림차순, bookname은 오름차순으로 정렬

-- 7. 집계 : 모드 행을 하나의 행으로 표현
-- # 주의. 집계함수, distinct 등 여러개의 행을 압축하여 1개 혹은 단축 행으로 변환되는 속성들은 
--         일반적인 다른 속성과 같이 사용할 수 없다.
--         단, projection할 속성들이 모두 집계함수인 경우는 같이 사용 가능.
-- > sum([all|distinct] 속성이름): 합계
-- > AS 'name': 속성 이름의 별칭을 지칭하는 키워드, AS 안써도 됨.
--      ex) select sum(salesprice) AS 총매출 from orders;
--      ex) select sum(salesprice) 총매출 from orders;
-- > sum(), avg(), count(), max(), min()

-- 8. GROUP BY 속성
-- 속성으로  그룹화한다는 의미, 집계함수와 같이 사용하면 group별로 집계해준다.
-- group by를 적용한 속성은 집계함수와 함께 projection 속성으로 사용 가능, 하지만 나머지는 안됨.

-- 9.HAVING 
-- group by 결과를 filtering하는 조건절
--    -> having 조건절에서 사용할 수 있는 속성은 select에 있는 속성들만 가능.
-- from의 where과 비슷한 기능을하는 조건절이다.
 
-- 순서 암기하기 select > from > where > groupby > having

-- <문제>
-- 가격이 20000원 미만인 도서를 검색하시오
select * from Book where price < 20000;
-- 가격이 10000원 이상 200000원 이하인 도서를 검색하시오
select * from book where price between 10000 and 20000;
select * from book where price >= 10000 and price <= 20000;
-- 가격이 10000원 이상 200000원 이하가 아닌 도서를 검색하시오
select * from book where price not between 10000 and 20000;

-- 출판사가 '굿스포츠'혹은 '대한미디어'인 도서를 검색하시오
select * from book where publisher in('굿스포츠', '대한미디어');
select * from book where publisher = '굿스포츠' or  publisher = '대한미디어';
-- 출판사가 '굿스포츠'혹은 '대한미디어'가 아닌 도서를 검색하시오
select * from book where publisher not in('굿스포츠', '대한미디어');
select * from book where publisher <> '굿스포츠' and  publisher <> '대한미디어';

-- '축구의 역사'를 출간한 출판사를 검색하시오
select bookname, publisher from book where bookname like '축구의 역사';
-- 도서이름에 '축구'가 포함된 출판사를 검색하시오
select bookname, publisher from book where bookname like '%축구%';
select bookname, publisher from book where bookname like '%의%';
select bookname, publisher from book where bookname like '축구%';
select bookname, publisher from book where bookname like '%축구';

-- 도서이름의 왼쪽 두 번째 위치에 ‘구’라는 문자열을 갖는 도서를 검색하시오
select * from book where bookname like '_구%';
select * from book where bookname like '__의%';
select * from book where bookname like '%기_';

-- 축구에 관한 도서 중 가격이 20000원 이상인 도서를 검색하시오
select * from book where bookname like '%축구%' and price >= 20000;

-- 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색하시오
select * from book where publisher  in('굿스포츠', '대한미디어');
select * from book where publisher like '굿스포츠';

-- 도서의 이름 순으로 검색하시오
select * from book order by bookname;
-- 도서의 가격 순으로 검색하고, 가격이 같으면 이름순으로 검색하시오
select * from book order by price, bookname;
select * from book order by price;  -- 동일
select * from book order by price, publisher;

-- 도서의 가격을 내림차순으로 검색하시오. 만약 가격이 같다면 출판사의 오름차순으로 검색한다.
select * from book order by price desc, publisher asc;

-- 고개이 주문한 도서의 총 판매액을 고하시오
select * from orders;
select sum(salesprice) from orders;
select sum(salesprice) 총매출 from orders;

-- 2번 김연아 고객이 주문한 도서의 총 판매액을 구하시오
select * from orders order by custid;
select sum(salesprice) 총매출 from orders where custid = 2;

-- 고객이 주문한 도서의 총 판매액, 평균값, 최저가, 최고가를 구하시오
SELECT SUM(saleprice) AS Total,
AVG(saleprice) AS Average,
MIN(saleprice) AS Minimum,
MAX(saleprice) AS Maximum
FROM Orders;

-- 마당 서점의 도서 판매 건수를 구하시오.
select * from orders;
select count(*) from orders;
select count(*), custid from orders; -- 오류, 집계는 기준속성 혹은 집계와 함께 쓸 수 있음

-- 고객별로 주문한 도서의 총 수량과 총 판매액을 구하시오.
-- 그룹을 지정해주면 집계는 그룹별로 해줌
select custid, count(*) as 도서수량, sum(salesprice) as 총액 -- id가 몇번 나오는지, 각 salesprice의 합 
from orders
group by custid;

select bookid, count(*) as 도서수량, sum(salesprice) as 총액
from orders
group by bookid order by bookid;

-- 가격이 8000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총 수량을 구하라. 단, 두권이상 구매한 고객만 구한다
select custid, count(*) as 도서수량
from orders -- 1. 10개의 행을 가져옴
where salesprice >= 8000    -- 2. 8000원 이상인 행 7개만 가져옴
group by custid --3. custid별로 group by한 행 4개만 가져옴
having count(*) >= 2;   --4. group by 결과 중 도서수량이 2개 이상인 행 3개만 남김

select custid, count(*) as 도서수량
from orders
where salesprice >= 8000
group by custid
having count(*) >= 2;

----------------------[join]-------------------------------
-- catersian product
select * from customer, orders; -- 50개(5 * 10)
select * from customer; -- 10개
select * from orders;   -- 5개

-- equi join (동등 조인)
select *
from customer, orders
where customer.custid = orders.custid;

-- <join 문제>
-- 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬해보이시오
select *
from customer, orders
where customer.custid = orders.custid
order by customer.custid;

-- 고객의 이름과 고객이 주문한 도서의 판매가격을 검색하시오
select name, salesprice -- 중첩이 안되면 그냥 써도 됨.
from customer, orders
where customer.custid = orders.custid;

-- 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬하시오
select name, sum(salesprice)
from customer, orders       -- 1. 50개의 행을 가져옴
where customer.custid = orders.custid   -- 2. custid를 동일한 것을 맞춰 정렬
group by customer.name      --3. 이름으로 group화하여 salesprice의 sum을 구함
order by customer.name;     --4. 이름별로 정렬

-- 고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
select name, bookname
from customer, book, orders -- 1. 500개의 행이 올라옴
where customer.custid = orders.custid and book.bookid = orders.bookid -- 2. 매칭되는 것만 남김
order by customer.custid;   -- 3. 이름별로 정렬

-- 가격이 200000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오
select name, bookname
from book, customer, orders     
where customer.custid = orders.custid and orders.bookid = book.bookid
and book.price = 20000;

-- 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격을 구하시오
select name, salesprice
from customer, orders
where customer.custid = orders.custid
order by customer.custid;

-- 외부조인 : matching 안되는 정보까지 보여줌
-- ANSI(앤씨) : American National Standard Institute (미국표준협회)
-- ANSI SQL문 : 모든 DBMS에서 지원하는 SQL명령어
SELECT name, salesprice
FROM Customer LEFT OUTER JOIN   -- LEFT OUTER JOIN : 왼쪽 외부조인
Orders ON Customer.custid = Orders.custid    -- ON : WHERE
order by customer.custid;

SELECT name, salesprice
FROM Customer RIGHT OUTER JOIN   -- LEFT OUTER JOIN : 왼쪽 외부조인
Orders ON Customer.custid = Orders.custid    -- ON : WHERE
order by customer.custid;