用户信息表
create table user(
  uid int unsigned primary key auto_increment, //0.自增主键
  unionid varchar(255) unique,                 //1.微信唯一ID
  username varchar(255) default '昵称',         //2.用户名
  password varchar(255) ,                      //3.用户密码
  phonenumber varchar(255) unique,             //4.手机号码
  portrait varchar(255) ,                      //5.用户头像
  regist_date bigint not null,                 //注册日期
  user_invite_code varchar(255) unique not null//唯一邀请码
) engine=innodb default charset=utf8;


//用户关系(类型)表 (用于快速查询邀请关系,账号类型)
create table relation(
    uid int unsigned not null,                           //用户id
    inviter_id int unsigned not null,                    //邀请人id(可能为店长)
    type_id int unsigned not null,                       //用户类型 0用户 1会员 2店长 3合伙人
    constraint relation_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

//
create table apply(
  apply_id int unsigned primary key auto_increment,
  uid int unsigned not null,        //uid
  username varchar(255) not null,   //用户名称
  type_id int not null,             //用户类型
  audit tinyint not null,           //是否审核通过
  member_number int not null,       //会员数量
  apply_date bigint not null,       //申请日期
  apply_date_text varchar(255)      //申请日期
)engine=innodb default charset=utf8;

//认证表
create table certifie(
    uid int unsigned unique not null,            //外键储存用户表uid
    real_name varchar(255) not null,            //真实姓名
    certificate_type varchar(255) not null,      //证件类型
    certificate_number varchar(255) not null,    //证件类型
    certificate_address varchar(255) not null,   //证件类型
    certificate_brithday varchar(255) not null,  //证件出生日期
    certificate_gender varchar(255) not null,    //性别
    phone_number varchar(255) not null,          //手机号
    certificate_photo varchar(255) not null,     //证件照片
    update_date varchar(255) not null,                   //更新日期
    constraint certifie_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;


//银行卡信息表
create table bankcard(
  uid int unsigned unique not null,             //外键储存用户表uid
  card_name varchar(255) not null,              //银行卡姓名
  card_number varchar(255) not null,            //银行卡号
  bank_name varchar(255) not null,              //银行姓名
  card_bank_name varchar(255) not null,         //银行卡开户行
  card_bank_number varchar(255) not null,       //银行卡开户行联行号
  card_phone varchar(255) not null,             //手机号码
  update_date varchar(255) not null,            //更新日期
  constraint crad_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;


//店铺信息表
create table store(
  uid int unsigned not null,                            //外键储存用户表uid
  store_portrait varchar(255),                          //店铺头像
  store_backgroud varchar(255),                         //店铺背景图片
  store_name varchar(255) not null,                     //店铺名称
  store_explain varchar(255) not null,                  //店铺说明
  store_commodity text,                                 //店铺商品[1,2,3,4,5,6]
  constraint store_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;


//搜索历史表(primary key)设置唯一主键可使用on duplicate key update
create table search(
  search_info text,                                     //多条搜索信息
  uid int unsigned unique not null,                     //外键储存用户表uid
  constraint search_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

//用户提现记录表
create table withdrawal(
    withdrawal_id int unsigned primary key auto_increment,
    uid int unsigned not null,                      //提现账号id
    withdrawal_date bigint not null,                //提现日期
    withdrawal_number decimal(20,8) not null,       //金额
    withdrawal_finished tinyint not null,           //提现是否完成
    withdrawal_type varchar(255) not null,          //提现方式
    revenue_promote varchar(255),                   //其中包含推广收益
    revenue_team varchar(255),                      //其中包含团队收益
    revenue_platform varchar(255),                  //其中包含平台收益
    revenue_onefelf varchar(255),                   //其中包含独占收益
    constraint withdrawal_uid foreign key(uid) references user(uid) on delete cascade on update cascade
)engine=innodb default charset=utf8;

/**
 *重点 收益表(每次收益每个涉及用户计算增加一条信息)
 */
create table revenue(
  revenue_id int unsigned primary key auto_increment,
  uid int unsigned not null,                  //收益者uid
  order_number bigint not null,             //收益计算的绑定订单
  order_state int unsigned not null,          //订单状态(是否完成)
  withdrawal tinyint not null,                //是否已计算到提现
  revenue_type int unsigned,                  //收益类型  1:推广收益 2:团队收益 3:平台奖励
  revenue_amount decimal(20,8) not null,      //受益者收益金额
  revenue_date long not null                  //收益计算时间戳
)engine=innodb default charset=utf8;


//我的订单 (点击量 订单数量 订单金额 预估佣金)//order为关键字
create table orders(
  order_id bigint primary key auto_increment,
  uid int unsigned not null,                                //uid
  order_number bigint unsigned unique not null,             //订单号
  order_state int unsigned not null,                        //订单状态
  order_decimal decimal(20,8),                              //订单佣金金额
  order_revenued tinyint,                                   //订单是否以计算到收益表
  order_date long not null                                  //订单日期
)engine=innodb default charset=utf8;


1:订单号
2:skUid
3:订单状态
4:商品名称
5:商品数量
6:商品单价
7:下单时间
8:商品退货数量
9:订单预计结算日期
10:订单收益
create table orders(
 uid int unsigned not null ,         //uid
 orderType int unsigned not null,    //订单类型 0:推广订单 1:购买订单
 subUnionId varchar(255) not null,   /subUnionId用户唯一标识
 positionId bigint not null,         //推广位id
 orderId bigint mot null ,           //订单号
 validCode int unsigned not null,    //订单状态
 estimateFee decimal not null,       //预估佣金
 actualCosPrice decimal not null,    //实际佣金(待修正)
 skuId bigint not null,              //商品id
 skuName varchar(255) not null,      //商品名称
 skuNum varchar(255) not null,       //商品数量
 price varchar(255) not null,        //商品单价
 skuReturnNum int unsigned default 0,//退货数量
 orderTime bigint not null,          //订单时间
 finishTime bigint not null,         //完成订单时间
 payMonth varchar(255) not null,     //预计结算日期
 traceType int unsigned,             //2同店 3跨店
 unique orderindex (subUnionId(255),orderId)
)engine=innodb default charset=utf8;


//反馈意见表
create table opinion(
   opinion_id int unsigned primary key auto_increment,    //反馈id
   uid int unsigned not null,                             //反馈者uid
   username varchar(255) not null,                        //反馈者名称
   opinion_detail text not null,                          //反馈信息
   opinion_date varchar(255) not null                     //反馈日期
)engine=innodb default charset=utf8;

//消息表
create table message(
   message_id int unsigned primary key auto_increment,    //反馈id
   message_title varchar(255) not null,                   //标题
   message_content varchar(255) not null,                 //内容
   message_connection varchar(255) ,                      //链接
   message_note varchar(255) ,                            //备注
   message_date bigint not null ,                         //日期
   message_date_text varchar(255) not null,
   message_sort int unsigned                  //排序序号
)engine=innodb default charset=utf8;

//攻略/教程/问题表
create table info(
  index_id int unsigned not null,   //攻略步骤id
  info_title varchar(255) not null, //标题
  info_content text not null,       //内容
  info_type int unsigned not null   //信息类型
)engine=innodb default charset=utf8;
insert into info values (1,'攻略1','11111',1);
insert into info values (2,'攻略1','11111',1);
insert into info values (3,'攻略1','11111',1);
insert into info values (1,'教程1','11111',2);
insert into info values (2,'教程2','11111',2);
insert into info values (3,'教程3','11111',2);
insert into info values (1,'晋升学习1','11111',3);
insert into info values (2,'晋升学习2','11111',3);
insert into info values (3,'晋升学习3','11111',3);
insert into info values (4,'晋升学习4','11111',3);
insert into info values (1,'常见问题1','11111',4);
insert into info values (2,'常见问题2','11111',4);
insert into info values (1,'邀请海报','11111',5);
insert into info values (1,'用户规范条例1','11111',6);
insert into info values (2,'用户规范条例2','11111',6);
insert into info values (1,'客服1','11111',7);
insert into info values (2,'客服2','11111',7);
insert into info values (1,'店长微信推荐1','11111',8);
insert into info values (2,'店长微信推荐1','11111',8);

//合作/联系表
create table contact(
  contact_type int unsigned not null,  //类型id
  contact_title varchar(255) not null, //标题
  contact_content text not null        //内容
)engine=innodb default charset=utf8;

insert into contact values (1,'合作','合作的详细信息');
insert into contact values (2,'联系','联系信息的详细信息');
insert into contact values (3,'关于我们','关于我们的详细信息');

//事件(异常事件记录)
create table record(
  record_id int unsigned primary key auto_increment,
  record text not null,
  record_date varchar(255) not null
)engine=innodb default charset=utf8;


//统计表
create table statistic(
  statistic_id int unsigned primary key auto_increment,
  start_date varchar(255),
  statistic_date varchar(255),
  calculate varchar(255),
  revenues varchar(255),
  orders varchar(255),
  users int unsigned,
  members int unsigned,
  managers int unsigned,
  partners int unsigned,
  statistic_ms long
)engine=innodb default charset=utf8;

create table setting(
    set_id int not null,
    independscale decimal(2,2) not null,         //独立收益比例
    promotescale decimal(2,2) not null,          //推广收益比例
    teamscale decimal(2,2) not null,             //团队收益比例
    platformscale decimal(2,2) not null,         //平台收益比例)
    partnerscale decimal(2,2) not null,          //合伙人收益比例(平台收益的比例))
    manager_levels int,                          //店长层级限制
    member_require int,                          //店长会员要求
    withdrawal_interval int,                     //提现间隔
    token_validity bigint                        //token有效期
)engine=innodb default charset=utf8;

create table admin(
  password varchar(255) not null
)engine=innodb default charset=utf8;


select sum(revenue_amount) from revenue group by revenue_type;

select * from (
select c.uid, c.username,c.portrait,c.regist_date,relation.type_id from user c inner join relation on c.uid = relation.uid where relation.inviter_id = 1
) u
left join (select sum(revenue_amount),uid from revenue group by revenue_type) re on re.uid = u.uid ;

select * from (
select c.uid, c.username,c.portrait,c.regist_date,relation.type_id from user c inner join relation on c.uid = relation.uid where relation.inviter_id = 1
) u
left join (select sum(revenue_amount) as promoteamout,uid as pid,revenue_type as pt from revenue) p on p.pid = u.uid and p.pt = 1
left join (select sum(revenue_amount) as teamamout,uid as tid, revenue_type as tt from revenue) t on t.tid = u.uid and t.tt = 2;

select * from (
select c.uid, c.username,c.portrait,c.regist_date,relation.type_id from user c inner join relation on c.uid = relation.uid where relation.inviter_id = 1
) u
left join (select sum(revenue_amount) as promoteamout,uid as pid,revenue_type as pt from revenue where revenue_type= 1) p on p.pid = u.uid
left join (select sum(revenue_amount) as teamamout,uid as tid, revenue_type as tt from revenue where revenue_type= 2) t on t.tid = u.uid;


SELECT business.bussId, (select count(invoices.userId) from invoice where invoice.bussId = a.bussId AND invoice.userId = '3000' ) as invoices, (select COUNT(rating.bussId) from rating where rating.bussId = a.bussId ) as ratingCount,
 FROM business a
 WHERE business.bussId=100


 select c.uid, c.username,c.portrait,c.regist_date,relation.type_id,
 (select sum(revenue_amount) from revenue where uid = c.uid and revenue_type = 1) as promoteamout,
 (select sum(revenue_amount) from revenue where uid = c.uid and revenue_type = 2) as promoteamout
  from user c inner join relation on c.uid = relation.uid where relation.inviter_id = 1;
