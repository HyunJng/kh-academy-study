create table KH_TCHR(
    tchr_no number primary key,
    tchr_name varchar2(15) not null,
    tchr_tel varchar2(12) not null
);

create table KH_EDU(
    edu_no number primary key, 
    edu_tchr number,
    foreign key(edu_tchr) references KH_TCHR(tchr_no),
    edu_name varchar2(30) not null,
    edu_date date
);
comment on column kh_tchr.tchr_no is '강사번호';
comment on column kh_tchr.tchr_name is '강사명';
comment on column kh_tchr.tchr_tel is '연락처';

comment on column KH_EDU.edu_no is '강의번호';
comment on column KH_EDU.edu_tchr is '강사번호';
comment on column KH_EDU.edu_name is '수업명';
comment on column KH_EDU.edu_date is '강의일';

insert into KH_TCHR
values(1, '홍길동', '01011112222');
insert into KH_TCHR
values(2, '김철수', '01022223333');
insert into KH_TCHR
values(3, '코준', '01033334444');

insert into KH_EDU(edu_no, edu_tchr, edu_name, edu_date)
values(1, 2, '강철몸 헬스 특강', to_date('21/01/01', 'yy/mm/dd'));
insert into KH_EDU
values(2, 2, '자바와 헬스', to_date('21/12/01', 'yy/mm/dd'));
insert into KH_EDU
values(3, 3, '코며드는 HTML', to_date('21/01/01', 'yy/mm/dd'));
insert into KH_EDU
values(4, 3, 'DB와 SQL', to_date('23/05/05', 'yy/mm/dd'));

select * from kh_edu;
select * from KH_TCHR;

select edu_name "강의명", T.tchr_name "강사명", edu_date "강의일" 
from kh_edu "E" right outer join kh_tchr "T"
on E.edu_tchr = T.tchr_no;