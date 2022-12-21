create user hospital
identified by hospital;

drop table UserInfo;

create table UserInfo(  
  seq      number(5) not null ,
  id    varchar2(200),  
  name varchar2(200),
  password   varchar2(200),
  email  varchar2(2000),
  tel   varchar2(200),
  adr       varchar2(200),
  role varchar2(10),
  constraint pk_user primary key (id)  
);

select * from UserInfo;

drop table deal_table;
create table deal_table(    
  reg_date varchar(200),
  seller varchar2(200),
  customer    varchar2(200),  
  goods  varchar2(2000),
  count   varchar2(200),
  C_adr varchar2(200),
  cost       NUMBER
);
alter table deal_table add cost number;
alter table deal_table drop column cost;
select * from deal_table;

drop table seller_goods;
create table seller_goods(
  seq      number(5) not null ,
  reg_date VARCHAR2(200),
  id varchar2(200),
  goods  varchar2(2000),
  goods_info varchar2(2000),
  goods_img varchar2(2000),
  cost       NUMBER

);
select * from seller_goods;
commit;