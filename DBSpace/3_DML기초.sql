-- 8. insert문
-- book table에 새로운 도서 '스포츠 의학'을 삽입하시오. 스포츠 의학은 한솔의학서적에서 출간했으며 가격은 90000원이다.
insert into book(bookid, bookname, publisher, price)
values (11, '스포츠 의학', '한솔의학서적', 90000);

select * from book;

-- insert할 때 모든 속성값을 사용할 필요는 없음 
-- (단, primary key와 not null, unique 등으로 제약이 된 경우는 insert할 때 속성값을 지정해주어야한다.)
insert into book(bookid, bookname, publisher)
values(14, '스포츠 의학2', '한솔의학서적');

select * from book;

-- attribute의 순서를 알고있으면 table뒤 속성 명시 생략 가능
insert into book
values (16, '스포츠 의학3', '한솔의학서적', 90000);

-- attribute 순서는 바꿀 수 있다.
insert into book(bookname, bookid, publisher, price)
values ('스포츠 의학4', 17, '한솔의학서적', 90000);

select * from book;

rollback;
-- 9. update문 : 수정
-- 주의 :  UPDATE SQL문장을 사용할 때 반드시 where 조건문을 사용해야 함. (사용하지 않으면 모든 형의 속성값을 변경)
update customer
set address = '대한민국 부산'
where custid = 5;

update customer
set address = '대한민국 부산'; -- where이 없으면 모든 튜플 바꿈

select * from customer;

-- 박세리의 주소를 김연아의 주소로 변경
update customer
set address = (select address
            from customer
            where name = '김연아')
where name like '박세리';

-- 10. delete문
DELETE FROM Customer
WHERE custid=5;
select * from customer;
-- 참조 무결성 제약조건이 restricted이라서 DELETE불가능
DELETE FROM Customer;
