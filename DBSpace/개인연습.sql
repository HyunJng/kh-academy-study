select * from book;
select * from book where price >= 10000 and publisher = '대한미디어';
select distinct custid from orders;
select bookname, bookid from book where mod(bookid, 2) = 0;
select count(*) - count(distinct custid) from orders;

select bookname, length(bookname)from book where length(bookname) = max(length(bookname));
--///////////////////////연습문제//////////////////////
-- <기본>
-- 1.1. 도서번호가 1인 도서의 이름
select bookid, bookname
from book
where bookid = 1;

-- 1.2. 가격이 20000원 이상인 도서의 이름
select bookname, price
from book
where price >= 20000;

-- 1.3. 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
select * from orders order by custid; -- 39000원
select sum(salesprice) from orders where custid = 1;

select custid, sum(salesprice)
from orders
group by custid;

-- 1.4. 박지성이 구매한 도서의 수 (박지성 고객 번호는 1번으로 놓고 작성)
select count(*)
from orders
where custid = 1;

-- 2.1. 마당서점 도서의 총 개수
select * from book;-- 확인용 10개
select count(*) 도서개수
from book;

-- 2.2. 마당서점에 도서를 출고하는 출판사의 총 개수
select distinct publisher   -- 확인용. 6개
from book;

select count(distinct publisher) as 출판사의총개수
from book;


-- 2.3. 모든 고객의 이름, 주소
select name, address
from customer;

-- 2.4. 2014.07.04 ~ 07.07 사이에 주문받은 도서의 주문번호
select * from orders order by orderdate; -- 확인용, 4개
select orderid, orderdate
from orders
where orderdate between '2014-07-04' and '2014-07-07';

-- 2.5.  2014.07.04 ~ 07.07 사이에 주문받은 도서를 제외한 도서의 주문번호
select orderid, orderdate
from orders
where orderdate not between'2014-07-04' and '2014-07-07';

-- 2.6. 성이 '김'씨인 고객의 이름과 주소
select * from customer; -- 확인용, 김연아 한개
select name, address
from customer
where name like('김%');

-- 2.7. 성이 '김'씨이고 이름이 '아'로 끝나는 고객의 이름과 주소
select name, address
from customer
where name like('김%아');

-- <join>
-- 3.1. 박지성이 구매한 도서의 출판사 수
select name
from customer, orders, book
where customer.custid = orders.custid and orders.bookid = book.bookid;
-- ////모르겠음
-- 3.2. 박지성이 구매한 도서의 이름, 가격, 정가와의 판매가격의 차이
-- 3.3. 박지성이 구매하지 않은 도서의 이름


---///////////////////////////수업예제복습////////////////////

-- 3-5 가격이 10,000원 이상 20,000 이하인 도서를 검색하시오
select *
from book
where price between 10000 and 20000;

-- 3-6 출판사가 ‘굿스포츠’ 혹은 ‘대한미디어’인 도서를 검색하시오
select *
from book
where price between 10000 and 20000;
select *
from book
where publisher ='굿스포츠' or publisher = '대한미디어';

-- 3-7 ‘축구의 역사’를 출간한 출판사를 검색하시오
select bookname, publisher
from book
where bookname like('축구의 역사');

-- 3-8 도서이름에 ‘축구’가 포함된 출판사를 검색하시오
select bookname, publisher
from book
where bookname like('%축구%');

-- 3-9 도서이름의 왼쪽 두 번째 위치에 ‘구’라는 문자열을 갖는 도서를 검색하시오.
select bookname
from book
where bookname like('_구%');

-- 3-10 축구에 관한 도서 중 가격이 20,000원 이상인 도서를 검색하시오.
select *
from book
where bookname like('%축구%') and price >= 20000;

-- 3-11 출판사가 ‘굿스포츠’ 혹은 ‘대한미디어’인 도서를 검색하시오.
select *
from book
where publisher in('굿스포츠', '대한미디어');

-- 3-12 도서를 이름순으로 검색하시오.
select *
from book
order by bookname;

-- 3-13 도서를 가격순으로 검색하고, 가격이 같으면 이름순으로 검색하시오
select *
from book
order by price, bookname;

--  3-14 도서를 가격의 내림차순으로 검색하시오. 만약 가격이 같다면 출판사의 오름차순으로 검색한다.
select *
from book
order by price DESC, publisher ASC;

-- 3-15 고객이 주문한 도서의 총 판매액을 구하시오.
select sum(salesprice)
from orders;

-- 3-16 2번 김연아 고객이 주문한 도서의 총 판매액을 구하시오
select sum(salesprice)
from orders
where custid = 2;

-- 3-17 고객이 주문한 도서의 총 판매액, 평균값, 최저가, 최고가를 구하시오.
select sum(salesprice)총판매액, avg(salesprice)평균값, min(salesprice)최저가, max(salesprice)최고가
from orders;

-- 3-18 마당서점의 도서 판매 건수를 구하시오
select count(*)
from orders;

-- 3-19 고객별로 주문한 도서의 총 수량과 총 판매액을 구하시오.
select custid, count(*) 주문개수, sum(salesprice)총판매액
from orders
group by custid;

-- 3-20 가격이 8,000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총
-- 수량을 구하시오. 단, 두 권 이상 구매한 고객만 구한다
select custid, count(*)
from orders
where salesprice >= 8000
group by custid
having count(*) >= 2;

-- 3-21 고객과 고객의 주문에 관한 데이터를 모두 보이시오
select *
from customer, orders
where orders.custid = customer.custid;
-- 만약 고객이름과 고객별 총 매출을 알고 싶다면?
select name, sum(salesprice)
from customer, orders
where orders.custid = customer.custid
group by customer.name;

-- 3-22 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬하여 보이시오
select *
from customer, orders
where orders.custid = customer.custid
order by customer.custid;

-- 3-23 고객의 이름과 고객이 주문한 도서의 판매가격을 검색하시오.
select name, salesprice
from customer, orders
where orders.custid = customer.custid
order by customer.name;

-- 3-24 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬하시오.
select name, sum(salesprice)
from customer, orders
where customer.custid = orders.custid
group by customer.name
order by customer.name;

-- 3-25 고객의 이름과 고객이 주문한 도서의 이름을 구하시오
select name, bookname
from customer, orders, book
where orders.custid = customer.custid and orders.bookid = book.bookid;

-- 3-26 가격이 20,000원 이상의 도서를 주문한 고객의 이름과 도서의 이름을 구하시오
select name, bookname, salesprice
from orders, customer, book
where orders.custid = customer.custid and orders.bookid = book.bookid
and salesprice >= 20000

