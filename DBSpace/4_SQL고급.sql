-- -------------------< 1. 숫자 함수 >----------------------------------
---1.1 ABS(숫자) : 절대값을 구하는 함수
select abs(-78), abs(78) from dual; -- dual: dummy table

---1.2 ROUND(숫자, 기준자리) : 반올림한 값을 구하는 함수, 기준자리: 양수(소주점자리), 음수(소수점이상자리)
select round(4.879, 1) from dual;
select round(562, -2) from dual;

---- 고객별 평균 주문 금액을 백 원 단위로 반올림한 값을 구하시오
select custid "고객번호", round(sum(salesprice)/count(*), -2) "평균금액"
from orders 
group by custid;

-------------------------------< 2. 문자함수>------------------------------------
---2.1 replace(속성, 이전속성, 바뀐 속성) : 문자열을 치환하는 함수
select bookid, replace(bookname, '야구', '농구') bookname, publisher, price
from book;

---2.2 length : 글자수를 세어주는 함수(단위가 바이트가아닌 문자 단위)
------length : 한글이든 영문이든 한 문자는 한 개로 인식
------lengthb: 한글은 2바이트(or 3바이트), 영문은 1바이트로 인식
select bookname "제목", length(bookname)"글자수", lengthb(bookname)"바이트수"
from book
where publisher = '굿스포츠';

---2.3 substr(문자열, 시작인덱스, 길이): 지정한 길이만큼 문자열을 반환하는 함수
------ 주의 : 시작인덱스는 1부터 시작
select substr(name, 1, 1) "성", count(*) "인원"
from customer
group by substr(name, 1, 1);

select substr(name, 1, 1) "성", count(*) "인원"
from customer
group by substr(name, 1, 1)
order by substr(name, 1, 1); -- order by는 select에 있는 것만 가능

----------------------------------< 3. 날짜 시간함수>---------------------
select orderid "주문번호" , orderdate "주문일", orderdate + 10 "확정"
from orders;
select orderid "주문번호" , orderdate "주문일", orderdate + 1 "확정"
from orders;

---3.1 to_date : 문자형을 date 형으로 변환하는 함수
---    to_char : date 형을 문자형으로 변환하는 함수
select orderid "주문번호", to_char(orderdate, 'yyyy-mm-dd dy') "주문일",
    custid "고객번호", bookid "도서번호"
from orders
where orderdate = to_date('20140707', 'yyyymmdd');

select orderid "주문번호", to_char(orderdate, 'yyyy-mm-dd dy') "주문일",
    custid "고객번호", bookid "도서번호"
from orders
where orderdate = to_date('2014/07/07', 'yyyy/mm/dd');

---3.2 sysdate : 현재 날짜와 시간을 반환
select sysdate, to_char(sysdate, 'yyy/mm/dd day hh24:mi:ss') "SYSDATE_1"
from dual;

-- ------------------------------<4. Null값 처리>---------------------
select * from book;

insert into book values(11, 'Olympic Champions2', 'Pearson', null);

---4.1 sum, avg 등 집계함수를 처리할 때 null값은 제외
select price + 10 "10더한가격"
from book;

select sum(price), avg(price), count(*), count(price)
from book;
--- 4.2.1 동작하지 않는 sql명령어 : null은 =로 비교 불가.
select * from book
where price = null;
--- 4.2.2 is null : null의 값을 가져올 수 있는 키워드
select * from book
where price is null;
--- 4.2.3 is not null : null이 아닌 값을 가져오는 키워드
select * from book
where price is not null;

--- 4.3 nvl : Null값을 다른 값으로 대치하여 연산하거나 다른 값으로 출력
select name "이름", NVL(phone, '연락처없음') "전화번호"
from customer;
-------------------------<<<<<<<<부속질의 & 추가명령문 >>>>>>------------------------------------------------
-- 1. ROWNUM : select문에서 'where조건문을 통과한 행'들에 대하여 동적으로 순번을 매김(1부터 시작)
--- 사용처 : 테이블을 정렬하여 상위, 하위 개수를 구할 때 사용
select rownum "순번", custid, name, phone
from customer
where rownum <= 2;

select rownum, custid, name, address, phone
from customer
where custid >= 4;

----- rownum은 where조건문에서 결정이 되고 order by로는 rownum에 영향이 없다.
select rownum, bookid, bookname, price from book where rownum <= 5;
select * from book
where rownum <= 5 order by price;

-- 2. from (select문) -> SQL은 내부적으로 table로 간주함
-- 가격이 가장 낮은 책부터 5개를 가져옴.
select rownum, b.*
from (select*from book order by price) b
where rownum <= 5;

---- 책 중에서 가격이 가장 높은 상위 3개의 행을 가져오라
select * 
from (select * from book where price is not null order by price DESC)
where rownum <= 3;

-- 3. 용어 inline : dynamic 하게 생성된 table(create table로 생성되지 않은 테이블)
select custid, sum(salesprice)
from Orders od
group by custid;
-----group by 로 행이 몇개인지는 결정이 남. 그러니 od.custid는 결정난 뒤 select문 돌아간다 생각.
select custid,(select name from customer cs where cs.custid = od.custid) name, sum(salesprice)
from Orders od
group by custid;

---- 고객 번호가 2 이하인 고객의 판매액을 보이시오(결과는 고객이름과 고객별 판매액 출력)
select cs.name, sum(od.salesprice) "total"
from (select custid, name
     from customer
     where custid <= 2) cs,
     orders od
where cs.custid = od.custid
group by cs.name;

select name, sum(salesprice) "total"
from customer cs, orders od
where cs.custid = od.custid and cs.custid <= 2
group by cs.name;

-- 4. where 부속질의 : 비교연산자
-- 평균 주문 금액 이하의 주문에 대해서 주문번호와 금액을 보이시오
select orderid, salesprice
from orders
where salesprice <= (select avg(salesprice)from orders);

---- 각 고객의 평균 주문 금액보다 큰 금액의 주문 내역에서 주문번호 고객번호 금액을 보이시오
select orderid, custid, salesprice
from orders od
where salesprice > (select avg(salesprice) from orders so where od.custid = so.custid);

---- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오. >> customer, orders
select sum(salesprice)
from (select * from customer where address like('%대한민국%')) cs , orders od
where cs.custid = od.custid;

select sum(salesprice)
from orders
where custid in (select custid from customer where address like('%대한민국%'));

-- 5. ALL (select 문) : select문의 모든 요소를 만족 해야한다는 개념
--    Some (select 문): select문의 최소한 한 개를 만족 (any도 된다)

---- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
select orderid, salesprice
from orders
where salesprice > all (select salesprice from orders where custid = 3);
-- where salesprice > (select max(salesprice) from orders where custid = 3);

select orderid, salesprice
from orders
where salesprice > some (select salesprice from orders where custid = 3);
-- where salesprice > (select min(salesprice) from orders where custid = 3);

-- 6. exists (select문): select문의 최소한 한 개라도 존재하면 true 
--    not exists (select문) : select문의 한 개도 존재하지 않는다면

---- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
select sum(salesprice)
from orders od
where exists (select * from customer cs where address like ('%대한민국%') and od.custid = cs.custid);

------ 다 ()문에 true가 되기 떄문에 그냥 order의 salesprice를 다 더한 값이 됨
select sum(salesprice)
from orders od
where exists (select * from customer cs where address like ('%대한민국%'));

