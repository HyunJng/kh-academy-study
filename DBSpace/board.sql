drop table BOARD;

create table BOARD(  
  seq      number(5),
  title    varchar2(200),  
  writer   varchar2(20),
  content  varchar2(2000),
  regdate  date default sysdate,
  cnt      number(5) default 0,
  constraint pk_board primary key (seq)  
);

insert into BOARD (seq, title, writer, content) values(1, '게시글1', '글쓴이1', '게시글 내용 1');
insert into BOARD (seq, title, writer, content) values(2, '게시글2', '글쓴이2', '게시글 내용 2');
insert into BOARD (seq, title, writer, content) values(3, '게시글3', '글쓴이3', '게시글 내용 3');
insert into BOARD (seq, title, writer, content) values(4, '게시글4', '글쓴이4', '게시글 내용 4');
insert into BOARD (seq, title, writer, content) values(5, '게시글5', '글쓴이5', '게시글 내용 5');
insert into BOARD (seq, title, writer, content) values(6, '게시글6', '글쓴이6', '게시글 내용 6');
insert into BOARD (seq, title, writer, content) values(7, '게시글7', '글쓴이7', '게시글 내용 7');
insert into BOARD (seq, title, writer, content) values(8, '게시글8', '글쓴이8', '게시글 내용 8');
insert into BOARD (seq, title, writer, content) values(9, '게시글9', '글쓴이9', '게시글 내용 9');
insert into BOARD (seq, title, writer, content) values(10, '게시글10', '글쓴이10', '게시글 내용 10');

select * from board;

drop table USERS;

create table USERS(
  id        varchar2(8),  
  password  varchar2(8),
  name      varchar2(20),
  role      varchar2(5),
  constraint pk_users primary key (id)
);

insert into USERS (id, password, name, role) values('1111', '1234', '관리자', 'admin');
insert into USERS (id, password, name, role) values('2222', '1234', '사용자', 'user');

select * from users;
select * from users where id='1111' and password='1234';

select * from users where id='1111' and password='1234';

commit;