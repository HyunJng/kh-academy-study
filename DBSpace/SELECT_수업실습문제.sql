--01. 마당서점의 고객이 요구하는 다음 질문에 대한 SQL문을 작성하시오
--01.1. 도서번호가 1인 도서의 이름
select bookname, bookid from book where bookid = 1;
--01.2. 가격이 20000원 이상인 도서의 이름
select bookname, price from book where price >= 20000;
--01.3. 박지성의 총 구매액
select sum(salesprice) from orders 
where custid = (select custid from customer where name in('박지성'));
--01.4.박지성이 구매한 도서의 수
select count(*) from orders
where custid = (select custid from customer where name in('박지성'));
--01.5.박지성이 구매한 도서의 출판사 수 >> customer, book, orders
-- 방법 1
select count(distinct publisher) from orders, book
where orders.bookid = book.bookid and custid = (select custid from customer where name in('박지성'));
-- 방법2
select count(distinct publisher) from customer, orders, book
where orders.bookid = book.bookid and customer.custid = orders.custid 
and name = '박지성';

--01.6.박지성이 구매한 도서의 이름, 가격, 정가와의 판매가격 차이
-- 방법1
select bookname, price as 정가, salesprice as 판매가격, salesprice - price as "정가와의 차이"
from book, orders
where book.bookid = orders.bookid
and orders.custid = (select custid from customer where name = '박지성');
-- 방법2
select bookname, price as 정가, salesprice as 판매가격, abs(salesprice - price) as "정가와의 차이"
from book b, orders o, customer c
where b.bookid = o.bookid and o.custid = c.custid
and name = '박지성';

--01.7. 박지성이 구매하지 않은 도서의 이름
-- 방법1
select distinct bookname from book, orders
where book.bookid = orders.bookid
and orders.custid <> (select custid from customer where name = '박지성');



--02. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오
--02.1 마당 서점 도서의 총 개수
select count(*) from book;
--02.2 마당서점에 도서를 출고하는 출판사의 총 개수
select count(distinct publisher) from book;
--02.3 모든 고객의 이름, 주소
select name, address from customer;
--02.4 2014년 7월 4일~7월 7일 사이에 주문받은 도서의 주문번호
select orderid, orderdate from orders
where orderdate between '2014/07/04' and '2014/07/07';
--02.5. 2014년 7월 4일~7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
select orderid, orderdate from orders
where orderdate not between '2014/07/04' and '2014/07/07';
--02.6. 성이 '김'씨인 고객의 이름과 주소
select name, address from customer
where name like('김%');
--02.7. 성이 '김'씨이고 이름이 '아'로 끝나는 고객의 이름과 주소
select name, address from customer
where name like('김%아');
--02.8. 주문하지 않은 고객의 이름
-- 방법1
select name from customer c
where not exists(select * from orders o where c.custid = o.custid);
-- 방법2
select name from customer
where custid not in (select custid from orders);
-- 방법3
select name from customer
where custid <> all(select custid from orders);

--02.9. 주문 금액의 총액과 주문의 평균 금액
select sum(salesprice), count(*), avg(salesprice) from orders;
--02.10. 고객의 이름과 고객별 구매액
select name, sum(salesprice)
from customer c, orders o
where c.custid = o.custid
group by c.name;
--02.11 고객의 이름과 고개이 구매한 도서 목록 >> orders, book, customer
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid;
--02.12 도서의 가격과 판매가격의 차이가 가장 많은 주문
-- 방법1. 차이 값만 찾을 때
select max(price- salesprice) from orders, book
where book.bookid = orders.bookid;

-- 방법2. book정보도 알고 싶을 떄 ??
select orderid, bookname, price, salesprice, price - salesprice as 차이 
from book, orders
where book.bookid = orders.bookid 
and price - salesprice = 
(select max(price - salesprice) from book, orders where book.bookid = orders.bookid);

--02.13.도서이 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select name, avg(salesprice)as 평균금액
from customer, orders
where customer.custid = orders.custid
group by name
having avg(salesprice) > (select avg(salesprice) from orders);




--03. 마당서점에서 다음의 심화된 질문에 대해 SQL문을 작성하시오
--03.1 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름 ***
select name, bookname, publisher
from book b, orders o, customer c
where o.bookid = b.bookid and c.custid = o.custid
and c.name <> '박지성' and publisher = some (select b2.publisher from customer c2, orders o2, book b2 
                      where c2.custid = o2.custid and o2.bookid = b2.bookid and c2.name = '박지성');

--03.2 두 개 이상이 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name, count(distinct publisher)
from orders o, customer c, book b
where o.bookid = b.bookid and c.custid = o.custid
group by name
having count(distinct publisher) >= 2;

--03.3 전체 고객의 30% 이상이 구매한 도서 < 별칭 having왜 안되는지
-- 방법1
select bookname
from orders o, customer c, book b
where o.bookid = b.bookid and c.custid = o.custid
group by bookname
having count(*)/(select count(*) from customer) >= 0.3;

-- 방법2
select bookname
from book,customer,orders
where book.bookid = orders.bookid and customer.custid = orders.custid
group by bookname
having count(orders.bookid)>=(select count(*)*0.3 from customer);



--04. scott데이터베이스를 이용해 다음 질문에 대해 SQL문을 작성하시오
--04.1. 사원의 이름과 직위를 출력하시오, 단, 사원의 이름은 '사원이름', 직위는 '사원직위'로 나오도록 작성
select ename as 사원이름 , job as 사원직위 from emp;
--04.2. 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하시오
select ename as 사원이름, sal as 급여 from emp
where deptno = 30;
--04.3. 사원번호와 이름, 현재 급여와 10% 인상된 급여를 사원번호순으로 출력.
select ename as 사원이름, sal as 현재급여, sal*0.1 as 증가액, sal * 1.1 as "인상된 급여" 
from emp
order by empno;
--04.4. 'S'로 시작하는 모든 사ㅜ언과 부서번호를 출력
select ename as 사원이름, deptno as "부서번호" from emp
where ename like('S%');
--04.5 모든 사원의 최대 및 최소 급여와 합계 및 평균 급여를 출력하시오. 단, 소수점 이하는 반올림하여 정수로 출력
select min(sal) as MIN, max(sal) as MAX, round(sum(sal)) as SUM, round(avg(sal)) as AVG
from emp;
--04.6 업무 이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하시오. 열 이름은 각각 '업무'와 '업무별 사원수'로 한다.
select job as 업무, count(*) as "업무별 사원수" from emp
group by job;
--04.7 사원의 최대 급여와 최소 급여의 차액을 출력하시오
select max(sal) - min(sal) as "최대급여-최소급여" from emp;
--04.8 30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력
select count(*) as "구성원 수", sum(sal) as "급여합", round(avg(sal)) as "급여평균"
from emp
where deptno=30;
--04.9 평균 급여가 가장 높은 부서의 번호를 출력하시오
-- 방법1
select deptno
from (select deptno, avg(sal)from emp group by deptno order by avg(sal) DESC)
where rownum = 1;
-- 방법2
select deptno
from emp
group by deptno
having avg(sal) = (select max(avg(sal))from emp group by deptno);
--04.10 세일즈맨을 제외하고, 각 업무별 사원들의 총 급여가 3000원 이상인 각 업무에 대해서,
--      업무명과 각 업무별 평균 급여를 출력하되, 평균 급여의 내림차순으로 출력하시오.
select job, avg(sal) from emp 
where job <> 'SALESMAN'
group by job
having sum(sal) >= 3000 -- 총? sum?
order by avg(sal) DESC;
--04.11. 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하시오
select count(*) from emp
where mgr is not null;
--04.12. emp테이블에서 이름, 급여, 커미션 금액, 총액(sal+comm)을 구하여 총액이 많은 순으로 출력하라
--      단, 커미션이 NULL인 사람은 제외
select ename, sal, comm, sal+comm as "총액" from emp
where comm is not null
order by 총액;
--04.13. 각 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하시오
select deptno, job, count(*)
from emp
group by deptno, job
order by deptno;
--04.14. 사원이 한 명도 없는 부서의 이름을 출력하시오
-- 방법1
select dname
from dept left outer join emp
on dept.deptno = emp.deptno
where empno is null;
-- 방법2
select dname from dept where deptno not in (select deptno from emp);
--04.15. 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오
select job, count(*)
from emp
group by job
having count(*)>= 4;
--04.16. 사원번호가 7400 이상 7600 이하인 사원의 이름을 출력하시오
select ename, empno from emp
where empno between 7400 and 7600;
--04.17. 사원의 이름과 사원의 부서를 출력하시오
select ename, deptno from emp;
--04.18. 사원의 이름과 팀장의 이름을 출력하시오
-- 방법1
select ename,(select ename from emp e2 where e1.mgr = e2.empno)
from emp e1;
-- 방법2
select employee.ename, manager.ename
from emp employee, emp manager
where manager.empno(+) = employee.mgr;
--04.19. 사원 SCOTT보다 급여를 많이 받는 사람의 이름을 출력하시오
select ename, sal
from emp 
where sal >= (select sal from emp where ename = 'SCOTT');
--04.20. 사원 SCOTT이 일하는 부서번호 혹은 DALLAS에 있는 부서 번호를 출력하시오
select deptno
from emp
where ename = 'SCOTT';
