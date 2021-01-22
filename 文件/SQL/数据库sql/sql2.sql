
select concat('drop table if exists ', table_name, ';')
from information_schema.tables
where table_schema = 'wxdb';


create table user(
  uid int unsigned primary key auto_increment,
  unionid varchar(255) unique,
  username varchar(255) default '昵称',
  password varchar(255) ,
  phonenumber varchar(255) unique,
  portrait varchar(255),
  regist_date bigint not null,
  sub_unionid char(18) unique not null,
  user_invite_code char(18) unique not null
) engine=innodb default charset=utf8;

# noinspection SqlNoDataSourceInspection
-- 用户表
create table user(
  uid int unsigned primary key auto_increment,
  unionid varchar(255) unique,
  wechatid varchar(255) unique,
  phonenumber varchar(255) unique,
  password varchar(255),
  username varchar(255) default '昵称',
  portrait varchar(255),
  regist_date bigint not null,
  sub_unionid char(18) unique not null,
  buy_unionid char(18) unique not null,
  user_invite_code char(18) unique not null
) engine=innodb default charset=utf8;

-- 邀请链表
create table relation(
    uid int unsigned not null,
    inviter_id int unsigned not null,
    type_id int unsigned not null,
    constraint relation_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

-- 店长申请表
create table apply(
  uid int unsigned unique not null,
  sub_unionid varchar(20) not null,
  username varchar(20) not null,
  type_id int not null,
  audit tinyint not null,
  member_number int not null,
  apply_date bigint not null,
  apply_date_text varchar(20)
)engine=innodb default charset=utf8;

-- 认证表
create table certifie(
  uid int unsigned unique not null,
  real_name varchar(20) not null,
  certificate_type varchar(20) not null,
  certificate_number varchar(20) not null,
  certificate_address varchar(255) not null,
  certificate_brithday varchar(30) not null,
  certificate_gender varchar(5) not null,
  phone_number varchar(11) not null,
  certificate_photo varchar(255) not null,
  cert_update_date varchar(20) not null,
  certificate_audit tinyint default false,
  certificate_audit_opinion text,
  constraint certifie_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

-- 银行卡表
create table bankcard(
  uid int unsigned unique not null,
  card_name varchar(20) not null,
  card_number varchar(255) not null,
  bank_name varchar(20) not null,
  card_bank_name varchar(30) not null,
  card_bank_number varchar(20) not null,
  card_phone varchar(11) not null,
  card_update_date varchar(30) not null,
  bankcard_audit tinyint default false,
  bankcard_audit_opinion text,
  constraint crad_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

-- 店铺表
create table store(
  uid int unsigned unique not null,
  store_portrait varchar(255),
  store_backgroud varchar(255),
  store_name varchar(255) not null,
  store_explain varchar(255) not null,
  recommend varchar(255)
)engine=innodb default charset=utf8;

-- 商品表
create table goods(
 goods_index varchar(255) unique not null,
 goods_id varchar(255),
 uid int unsigned not null,
 goods_tag varchar(255),
 goods_type bigint,
 top int unsigned,
 goods_date bigint
)engine=innodb default charset=utf8;

-- 搜索表
create table search(
  search_info text,
  uid int unsigned not null,
  constraint search_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

-- 提现表
create table withdrawal(
    withdrawal_id int unsigned primary key auto_increment,
    uid int unsigned not null,
    withdrawal_date bigint not null,
    withdrawal_number decimal(20,8) not null,
    withdrawal_finished tinyint not null,
    withdrawal_type varchar(20) not null,
    revenue_promote varchar(30),
    revenue_team varchar(30),
    revenue_platform varchar(30),
    withdrawal_opinion varchar(255)
)engine=innodb default charset=utf8;

--收益表
create table revenue(
  uid int unsigned not null,
  orderId bigint not null,
  withdrawal tinyint not null,
  revenue_type int unsigned,
  revenue_amount decimal(20,8) not null,
  revenue_date bigint not null,
  index userindex (uid)
)engine=innodb default charset=utf8;

-- 预估表
create table estimate(
   e_id int unsigned primary key auto_increment,
   uid int unsigned not null,
   orderId bigint not null,
   promote_amount double(12,8) not null,
   promote_uid int unsigned not null,
   revenue_type int unsigned,
   revenue_amount double(12,8) not null,
   revenue_date date not null,
   orderTime bigint not null,
   index userindex (uid)
)engine=innodb default charset=utf8;

-- 订单表
create table orders(
  order_sub char(39) unique not null,
  uid int unsigned not null ,
  orderType int unsigned not null ,
  subUnionId char(18),
  positionId bigint not null,
  orderId bigint not null,
  validCode int unsigned not null,
  skuId bigint not null,
  skuName varchar(255) not null,

  estimate double(12,8) not null,
  revenue double(12,8),
  dmRate double not null,

  plus int unsigned not null,
  skuNum bigint not null,
  price double not null,
  skuReturnNum bigint default 0,
  orderTime bigint not null,
  finishTime bigint not null,
  payMonth int unsigned,
  traceType int unsigned,

  actualFee double(12,8) not null,
  actualCosPrice double not null,
  estimateCosPrice double not null,
  estimateFee double(12,8) not null,
  finalRate double not null,
  subSideRate double not null,
  subsidyRate double not null,
  commissionRate double not null

)engine=innodb default charset=utf8;

-- 反馈
create table opinion(
   opinion_id int unsigned primary key auto_increment,
   uid int unsigned not null,
   username varchar(255) not null,
   opinion_detail text not null,
   opinion_date datetime not null
)engine=innodb default charset=utf8;

-- 消息
create table message(
   message_id int unsigned primary key auto_increment,
   message_title varchar(255) not null,
   message_content text not null,
   message_connection varchar(255) ,
   message_note varchar(255) ,
   message_date bigint not null ,
   message_date_text varchar(255) not null,
   message_sort int unsigned
)engine=innodb default charset=utf8;

-- 系统信息
create table info(
  index_id int unsigned not null,
  info_title varchar(255) not null,
  info_content text not null,
  info_type int unsigned not null
)engine=innodb default charset=utf8;

-- 联系方式
create table contact(
  contact_type int unsigned not null,
  contact_title varchar(255) not null,
  contact_content text not null
)engine=innodb default charset=utf8;

--记录表
create table record(
  record_id int unsigned primary key auto_increment,
  record text not null,
  record_date varchar(255) not null
)engine=innodb default charset=utf8;

-- 统计表
create table statistic(
  statistic_id int unsigned primary key auto_increment,
  start_date varchar(255),
  statistic_date varchar(255),
  revenues varchar(255),
  orders varchar(255),
  users int unsigned,
  members int unsigned,
  managers int unsigned,
  partners int unsigned,
  statistic_ms long
)engine=innodb default charset=utf8;

-- 管理员密码表
create table admin(
  password varchar(255) not null
)engine=innodb default charset=utf8;
insert into admin values ('12345678');


-- 缓存商品图片
create table imgurl(
  skuId bigint unique not null,
  imgUrl varchar(255) not null
)engine=innodb default charset=utf8;

-- 订单收益链记录表
create table link(
  order_sub char(39) unique not null,
  orderId bigint not null,
  uid int unsigned not null,
  link text not null,
  linkdate datetime
)engine=innodb default charset=utf8;

-- 大麦专区表
create table damai(
  id int unsigned primary key auto_increment,
  sort bigint not null,
  damai text not null,
  skuId bigint unique not null,
  rate decimal(20,8),
  tag decimal(20,8),
  editdate datetime not null
)engine=innodb default charset=utf8;

-- 弹窗表
create table promote(
  id int unsigned primary key auto_increment,
  promoted tinyint default false,
  picUrl varchar(255) not null,
  h5Url varchar(255) not null,
  editdate datetime not null
)engine=innodb default charset=utf8;

create table upgrade(
  uid int unsigned,
  mem_number int unsigned,
  total double,
  up_date datetime
)engine=innodb default charset=utf8;

create table test(
 uid int unsigned primary key auto_increment,
 re double(10,8),
 ve double(10,8)
)engine=innodb default charset=utf8;

insert into test values(1,1.1,2.2) on duplicate key update re = 1.1;



select * from main left join info on (main.uid = info.uid) left join test on (main.uid = test.uid);

select * from ( select
withdrawal.uid as uid,
withdrawal.withdrawal_id as withdrawal_id,
withdrawal.withdrawal_date as withdrawal_date,
withdrawal.withdrawal_number as withdrawal_number,
withdrawal.withdrawal_finished as withdrawal_finished,
withdrawal.withdrawal_type as withdrawal_type,
username as username,
phonenumber as phonenumber,
portrait as portrait,
regist_date as regist_date
from withdrawal inner join user on user.uid = withdrawal.uid)
draw
left join bankcard on (bankcard.uid = draw.uid) left join certifie on (certifie.uid = draw.uid);



create table main(
  uid int,
  name varchar(255)
)engine=innodb default charset=utf8;

create table follow(
  uid int,
  number int
)engine=innodb default charset=utf8;

create table test(
  uid int,
  test varchar(255)
)engine=innodb default charset=utf8;

create table info(
  uid int,
  info varchar(255)
)engine=innodb default charset=utf8;

select * from follow inner join main on main.uid = follow.uid;
select * from
(select main.uid as uid, number as number from follow inner join main on main.uid = follow.uid) draw
left join test on test.uid = draw.uid
left join info on info.uid = draw.uid;

# select * from A left join B on (A.id = B.uid) left join C on (A.id = C.tid)

select * from main c inner join follow on c.uid = follow.uid;
select * from main c inner join test on c.uid = follow.uid;
select * from follow c inner join main on c.uid = main.uid;

select * from main c left outer join follow on c.uid = follow.uid;
select * from main c right outer join follow on c.uid = follow.uid;

select c.name, (select group_concat(name) from follow s where s.uid =c.uid )from main c where c.uid =1;

select * from
(
select
u.uid,u.username,u.phonenumber,u.portrait,u.regist_date,
b.card_name,b.card_number,b.bank_name,b.card_bank_name,b.card_bank_number,b.card_phone,b.card_update_date,b.bankcard_audit,
c.real_name,c.certificate_type,c.certificate_number,c.phone_number,c.certificate_photo,c.cert_update_date,c.certificate_audit
 from user u,bankcard b,certifie c where u.uid in
(
select uid from withdrawal group  by b.uid
)
and b.uid= u.uid and c.uid = u.uid
) main inner join withdrawal on main.uid = withdrawal.uid;


select * from ( select u.uid,u.username,u.phonenumber,u.portrait,u.regist_date,b.card_name,b.card_number,b.bank_name,b.card_bank_name,b.card_bank_number,b.card_phone,b.card_update_date,b.bankcard_audit,c.real_name,c.certificate_type,c.certificate_number,c.phone_number,c.certificate_photo,c.cert_update_date,c.certificate_audit from user u,bankcard b,certifie c where u.uid in (select uid from withdrawal group  by b.uid ) and b.uid= u.uid and c.uid = u.uid) main inner join withdrawal on main.uid = withdrawal.uid;

select revenue_date from (
select revenue_date, revenue_type,count(*) as count,sum(revenue_amount) as amount from estimate where uid = 1 group by revenue_date,revenue_type
) a group by revenue_date;

